package com.cfg22.gusec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;

import com.cfg22.gusec.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View root = binding.getRoot();
        setContentView(root);

        AnimationDrawable drawable = (AnimationDrawable) binding.layout.getBackground();
        drawable.setEnterFadeDuration(10);
        drawable.setExitFadeDuration(5000);
        drawable.start();

        binding.regPageBT.setOnClickListener(view -> startActivity(new Intent(LoginActivity.this, RegisterActivity.class)));

        binding.trackRegBT.setOnClickListener(view -> startActivity(new Intent(LoginActivity.this, TrackActivity.class)));
    }
}