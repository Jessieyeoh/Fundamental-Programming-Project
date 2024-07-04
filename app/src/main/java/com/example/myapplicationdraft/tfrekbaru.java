package com.example.myapplicationdraft;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class tfrekbaru extends AppCompatActivity {
    private Button rekbarusama;
    private Button rekbarubeda;
    private Button rekbrback;
    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tfrekbaru);
        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    tts.setLanguage(Locale.US);
                    tts.setSpeechRate(2.f);
                }
            }
        });
        rekbarusama = findViewById(R.id.rekbarusama); // Find the button

        rekbarusama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tts.speak(rekbarusama.getText().toString(), TextToSpeech.QUEUE_ADD, null);
                Intent intent = new Intent(tfrekbaru.this, norektujuan.class);
                startActivity(intent);
            }
        });
        rekbarubeda = findViewById(R.id.rekbarubeda);

        rekbarubeda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tts.speak(rekbarubeda.getText().toString(), TextToSpeech.QUEUE_ADD, null);
                Intent intent = new Intent(tfrekbaru.this, rekbank.class);
                startActivity(intent);
            }
        });
        rekbrback = findViewById(R.id.rekbrback);

        rekbrback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tts.speak(rekbrback.getText().toString(), TextToSpeech.QUEUE_ADD, null);
                Intent intent = new Intent(tfrekbaru.this, transfer.class);
                startActivity(intent);
            }
        });
    }
}