package com.example.myapplicationdraft;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.bca_icon);

        // Handler to delay activity switch
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start MainActivity2 after 2 seconds
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
                finish(); // Close the current activity
            }
        }, 2000); // Delay in milliseconds (2 seconds)
    }
}