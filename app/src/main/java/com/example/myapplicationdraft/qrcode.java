package com.example.myapplicationdraft;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class qrcode extends AppCompatActivity {

    private ImageView qrcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);
        qrcode = findViewById(R.id.qrcode);
        qrcode.setImageResource(R.drawable.qrcode);

        // Handler to delay activity switch
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start MainActivity2 after 2 seconds
                Intent intent = new Intent(qrcode.this, masukkannominal.class);
                startActivity(intent);
                finish(); // Close the current activity
            }
        }, 2000); // Delay in milliseconds (2 seconds)
    }
}