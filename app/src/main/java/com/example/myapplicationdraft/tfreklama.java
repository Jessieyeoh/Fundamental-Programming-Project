package com.example.myapplicationdraft;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class tfreklama extends AppCompatActivity {
    private Button reklamasama;
    private Button reklamabeda;
    private Button reklmback;
    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tfreklama);
        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    tts.setLanguage(Locale.US);
                    tts.setSpeechRate(2.f);
                }
            }
        });
        reklamasama = findViewById(R.id.reklamasama); // Find the button

        reklamasama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tts.speak(reklamasama.getText().toString(), TextToSpeech.QUEUE_ADD, null);
                Intent intent = new Intent(tfreklama.this, dftrnama.class);
                startActivity(intent);
            }
        });
        reklamabeda = findViewById(R.id.reklamabeda);

        reklamabeda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tts.speak(reklamabeda.getText().toString(), TextToSpeech.QUEUE_ADD, null);
                Intent intent = new Intent(tfreklama.this, rekbank2.class);
                startActivity(intent);
            }
        });
        reklmback = findViewById(R.id.reklmback);

        reklmback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tts.speak(reklmback.getText().toString(), TextToSpeech.QUEUE_ADD, null);
                Intent intent = new Intent(tfreklama.this, transfer.class);
                startActivity(intent);
            }
        });
    }
}