package com.example.myapplicationdraft;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class norektujuan2 extends AppCompatActivity {
    private EditText norektujuan2;
    private Button dftreknext2;
    private Button dftrekback2;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_norektujuan2);
        intView();
        setVariable();
        dftrekback2 = findViewById(R.id.dftrekback2); // Find the button

        dftrekback2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if (status == TextToSpeech.SUCCESS) {
                            tts.setLanguage(Locale.US);
                            tts.setSpeechRate(2.f);
                            tts.speak(dftrekback2.getText().toString(), TextToSpeech.QUEUE_ADD, null);
                        }
                    }
                });
                Intent intent = new Intent(norektujuan2.this, transfer.class);
                startActivity(intent);
            }
        });
    }
    private void setVariable(){
        dftreknext2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if (status == TextToSpeech.SUCCESS) {
                            tts.setLanguage(Locale.US);
                            tts.setSpeechRate(2.f);
                            tts.speak(dftreknext2.getText().toString(), TextToSpeech.QUEUE_ADD, null);
                        }
                    }
                });
                if (norektujuan2.getText().toString().equals("10987")){
                    Intent intent = new Intent(norektujuan2.this, masukkannominal2.class);
                    startActivity(intent);
                }
            }
        });
    }
    private void intView(){
        norektujuan2 =findViewById(R.id.norektujuan2);
        dftreknext2 = findViewById(R.id.dftreknext2);
    }
}