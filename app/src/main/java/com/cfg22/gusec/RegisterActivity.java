package com.cfg22.gusec;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.cfg22.gusec.databinding.ActivityRegisterBinding;
import com.cfg22.gusec.databinding.ActivityResultBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class RegisterActivity extends AppCompatActivity {

    ActivityRegisterBinding binding;
    FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AnimationDrawable drawable = (AnimationDrawable) binding.layout.getBackground();
        drawable.setEnterFadeDuration(10);
        drawable.setExitFadeDuration(5000);
        drawable.start();

        firestore = FirebaseFirestore.getInstance();

        binding.submitBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.email.getEditText().getText().toString();
                String phone = binding.phone.getEditText().getText().toString();
                String pass = binding.password.getEditText().getText().toString();
                String name = binding.name.getEditText().getText().toString();
                String startup = binding.startup.getEditText().getText().toString();
                String add = binding.address.getEditText().getText().toString();
                String coll = binding.college.getEditText().getText().toString();
                Boolean isStudent = binding.studentToggle.isChecked();
                String desc = binding.desc.getEditText().getText().toString();
                String model = binding.bizModel.getEditText().getText().toString();
                String pitch = binding.pitch.getEditText().getText().toString();
                String vid = binding.video.getEditText().getText().toString();

                if(email.isEmpty()) {
                    binding.email.setError("This is required");
                    binding.email.requestFocus();
                }
                else if(phone.isEmpty()) {
                    binding.phone.setError("This is required");
                    binding.phone.requestFocus();
                }
                else if(pass.isEmpty()) {
                    binding.password.setError("This is required");
                    binding.password.requestFocus();
                }
                else if(name.isEmpty()) {
                    binding.name.setError("This is required");
                    binding.name.requestFocus();
                }
                else if(startup.isEmpty()) {
                    binding.startup.setError("This is required");
                    binding.startup.requestFocus();
                }
                else if(add.isEmpty()) {
                    binding.address.setError("This is required");
                    binding.address.requestFocus();
                }
                else if(coll.isEmpty()) {
                    binding.college.setError("This is required");
                    binding.college.requestFocus();
                }
                else if(desc.isEmpty()) {
                    binding.desc.setError("This is required");
                    binding.desc.requestFocus();
                }
                else if(model.isEmpty()) {
                    binding.bizModel.setError("This is required");
                    binding.bizModel.requestFocus();
                }
                else if(pitch.isEmpty()) {
                    binding.pitch.setError("This is required");
                    binding.pitch.requestFocus();
                }
                else {
                    CollectionReference registerCollection = firestore.collection("Registrations");
                    DocumentReference currDoc = registerCollection.document();

                    String ID = currDoc.getId();
                    Registration newReg = new Registration(ID, pass, name, startup, phone, email, add, coll, isStudent, desc, model, pitch, vid);

                    currDoc.set(newReg).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(RegisterActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(RegisterActivity.this, ResultActivity.class);
                            intent.putExtra("status", "Pending");
                            startActivity(intent);
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(RegisterActivity.this, "Could not register!", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }
}