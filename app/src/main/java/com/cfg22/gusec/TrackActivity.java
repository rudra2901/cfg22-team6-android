package com.cfg22.gusec;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.Toast;

import com.cfg22.gusec.databinding.ActivityRegisterBinding;
import com.cfg22.gusec.databinding.ActivityTrackBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class TrackActivity extends AppCompatActivity {
    ActivityTrackBinding binding;

    FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTrackBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AnimationDrawable drawable = (AnimationDrawable) binding.layout.getBackground();
        drawable.setEnterFadeDuration(10);
        drawable.setExitFadeDuration(5000);
        drawable.start();

        firestore = FirebaseFirestore.getInstance();

        binding.trackBT.setOnClickListener(view -> {
            String email = binding.email.getEditText().getText().toString();
            String pass = binding.email.getEditText().getText().toString();

            if(email.isEmpty()) {
                binding.email.setError("This is required");
                binding.email.requestFocus();
            }
            else if(pass.isEmpty()) {
                binding.password.setError("This is required");
                binding.password.requestFocus();
            }
            else {
                firestore.collection("Registrations")
                        .whereEqualTo("email", email)
                        .get()
                        .addOnCompleteListener(task -> {
                            if(task.isSuccessful()) {
                                int i = 0;
                                QueryDocumentSnapshot doc = null;
                                for(QueryDocumentSnapshot res : task.getResult()) {
                                    doc = res;
                                    i++;
                                    //break;
                                    Registration reg;
                                    if (doc != null) {
                                        reg = doc.toObject(Registration.class);
                                        if (reg.getPass().equals(pass)) {
                                            Intent intent = new Intent(TrackActivity.this, ResultActivity.class);
                                            intent.putExtra("status", reg.getStatus());
                                            startActivity(intent);
                                        } else {
                                            Toast.makeText(TrackActivity.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                                            break;
                                        }
                                    } else {
                                        Toast.makeText(TrackActivity.this, "No User Found", Toast.LENGTH_SHORT).show();
                                        break;
                                    }
                                }
                            }
                        });
            }
        });
    }
}