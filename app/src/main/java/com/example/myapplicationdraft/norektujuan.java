package com.example.myapplicationdraft;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class norektujuan extends AppCompatActivity {
    private EditText norektujuan;
    private Button dftreknext;
    private Button dftrekback;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_norektujuan);
        intView();
        setVariable();
        dftrekback = findViewById(R.id.dftrekback); // Find the button

        dftrekback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if (status == TextToSpeech.SUCCESS) {
                            tts.setLanguage(Locale.US);
                            tts.setSpeechRate(2.f);
                            tts.speak(dftrekback.getText().toString(), TextToSpeech.QUEUE_ADD, null);
                        }
                    }
                });
                Intent intent = new Intent(norektujuan.this, transfer.class);
                startActivity(intent);
            }
        });
    }
    private void setVariable(){
        dftreknext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if (status == TextToSpeech.SUCCESS) {
                            tts.setLanguage(Locale.US);
                            tts.setSpeechRate(2.f);
                            tts.speak(dftreknext.getText().toString(), TextToSpeech.QUEUE_ADD, null);
                        }
                    }
                });
                if (norektujuan.getText().toString().equals("10987")){
                    Intent intent = new Intent(norektujuan.this, masukkannominal.class);
                    startActivity(intent);
                }
            }
        });
    }
    private void intView(){
        norektujuan =findViewById(R.id.norektujuan);
        dftreknext = findViewById(R.id.dftreknext);
    }
}