package com.example.myapplicationdraft;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class home extends AppCompatActivity {
    private Button ceksaldo;
    private Button exit;
    private Button transfer;
    private Button qris;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ceksaldo = findViewById(R.id.ceksaldo); // Find the button

        ceksaldo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if (status == TextToSpeech.SUCCESS) {
                            tts.setLanguage(Locale.US);
                            tts.setSpeechRate(2.f);
                            tts.speak(ceksaldo.getText().toString(), TextToSpeech.QUEUE_ADD, null);
                        }
                    }
                });
                Intent intent = new Intent(home.this, saldo.class);
                startActivity(intent);
            }
        });
        exit = findViewById(R.id.exit);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if (status == TextToSpeech.SUCCESS) {
                            tts.setLanguage(Locale.US);
                            tts.setSpeechRate(2.f);
                            tts.speak(exit.getText().toString(), TextToSpeech.QUEUE_ADD, null);
                        }
                    }
                });
                Intent intent = new Intent(home.this, MainActivity.class);
                startActivity(intent);
            }
        });
        transfer = findViewById(R.id.transfer);

        transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if (status == TextToSpeech.SUCCESS) {
                            tts.setLanguage(Locale.US);
                            tts.setSpeechRate(2.f);
                            tts.speak(transfer.getText().toString(), TextToSpeech.QUEUE_ADD, null);
                        }
                    }
                });
                Intent intent = new Intent(home.this, transfer.class);
                startActivity(intent);
            }
        });
        qris = findViewById(R.id.qris);

        qris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if (status == TextToSpeech.SUCCESS) {
                            tts.setLanguage(Locale.US);
                            tts.setSpeechRate(2.f);
                            tts.speak(qris.getText().toString(), TextToSpeech.QUEUE_ADD, null);
                        }
                    }
                });
                Intent intent = new Intent(home.this, qrcode.class);
                startActivity(intent);
            }
        });
    }
}