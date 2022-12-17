package com.example.hungrygone.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.hungrygone.HelperClass.Commonfunctions;
import com.example.hungrygone.R;
import com.example.hungrygone.databinding.ActivityMainBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Commonfunctions.LoadPreferences(MainActivity.this);
        if (Commonfunctions.logged.equals("Logged")){
            startActivity(new Intent(MainActivity.this,Home.class));
            finish();
        }
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View root = binding.getRoot();
        setContentView(root);


        binding.appCompatButton.setOnClickListener(this::onClick);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.appCompatButton) {
            String otp = "";
            otp = String.valueOf(binding.textInputLayout.getEditText().getText());
            if (otp == "") {
                Toast.makeText(this, "Please Enter Your Mobile Number", Toast.LENGTH_SHORT).show();
            } else if (otp.length() != 10) {
                Toast.makeText(this, "Please Enter Valid Mobile Number", Toast.LENGTH_SHORT).show();
            } else {
                toGoOtpVerifyPageWithOtp();
            }
        }
    }

    private void toGoOtpVerifyPageWithOtp() {
        Random rand = new Random();
        String id = String.format("%04d", rand.nextInt(10000));
        startActivity(new Intent(MainActivity.this, OtpVerifycation.class).putExtra("OTP", id));
        finish();
    }
}