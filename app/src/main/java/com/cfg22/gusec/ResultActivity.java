package com.cfg22.gusec;

import androidx.activity.result.ActivityResult;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;

import com.cfg22.gusec.databinding.ActivityResultBinding;

public class ResultActivity extends AppCompatActivity {

    ActivityResultBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultBinding.inflate(getLayoutInflater());
        View root = binding.getRoot();
        setContentView(root);

        AnimationDrawable drawable = (AnimationDrawable) binding.layout.getBackground();
        drawable.setEnterFadeDuration(10);
        drawable.setExitFadeDuration(5000);
        drawable.start();

        Bundle extras = getIntent().getExtras();
        String stat = extras.getString("status");

        if(stat.equals("Rejected")) {
            binding.statusTV.setText(stat);
            binding.statusTV.setTextColor(getResources().getColor(R.color.red));
            binding.mess2.setText("Reasons for the same have been sent to your email. You can try again after solving the issues");
        }
        else if(stat.equals("Accepted")) {
            binding.statusTV.setText(stat);
            binding.statusTV.setTextColor(getResources().getColor(R.color.accepted));
            binding.mess2.setText("Congratulations! Next steps for onboarding have been sent to your email.");
        }
    }
}