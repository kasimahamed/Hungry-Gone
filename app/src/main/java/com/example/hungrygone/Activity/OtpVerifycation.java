package com.example.hungrygone.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hungrygone.R;
import com.example.hungrygone.databinding.ActivityMainBinding;
import com.example.hungrygone.databinding.ActivityOtpVerifycationBinding;

public class OtpVerifycation extends AppCompatActivity implements View.OnClickListener {
    private ActivityOtpVerifycationBinding binding;
    private String otp = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        binding = ActivityOtpVerifycationBinding.inflate(getLayoutInflater());
        View root = binding.getRoot();
        setContentView(root);
        binding.layoutBack.setOnClickListener(this);
        binding.appCompatButton.setOnClickListener(this);
        otp = getIntent().getStringExtra("OTP");
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                otpVerifycation(otp);
            }
        }, 2000);

    }

    private void otpVerifycation(String otp) {
        AlertDialog.Builder builder = new AlertDialog.Builder(OtpVerifycation.this);
        builder.setMessage(otp + "\n\n Please click OK to verify your mobile number");
        builder.setTitle("Your OTP is");
        builder.setCancelable(false);
        builder.setPositiveButton("OK", (DialogInterface.OnClickListener) (dialog, which) -> {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                @Override
                public void run() {
                    binding.otpPinView.setOTP(otp);
                    progress();
                }
            }, 500);
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    private void progress() {
        ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Verifying...");
        progressDialog.show();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                progressDialog.dismiss();
                Toast.makeText(OtpVerifycation.this, "Verified Successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(OtpVerifycation.this, Home.class));
                finish();
            }
        }, 2000);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.layout_back) {
            finish();
        } else if (view.getId() == R.id.appCompatButton) {
            if (binding.otpPinView.getOTP().toString() == "") {
                Toast.makeText(this, "Please Enter Otp", Toast.LENGTH_SHORT).show();
            } else if (binding.otpPinView.getOTP().toString() != otp){
                Toast.makeText(this, "Please Enter Valid OTP", Toast.LENGTH_SHORT).show();
            }else {
                startActivity(new Intent(OtpVerifycation.this, Home.class));
            }
        }
    }
}