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

public class masukkannominal extends AppCompatActivity {
    private EditText entnom;
    private Button entNomNext;
    private Button entNomBack;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_masukkannominal);
        intView();
        setVariable();
        entNomBack = findViewById(R.id.entNomBack); // Find the button

        entNomBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if (status == TextToSpeech.SUCCESS) {
                            tts.setLanguage(Locale.US);
                            tts.setSpeechRate(2.f);
                            tts.speak(entNomBack.getText().toString(), TextToSpeech.QUEUE_ADD, null);
                        }
                    }
                });
                Intent intent = new Intent(masukkannominal.this, transfer.class);
                startActivity(intent);
            }
        });
    }
    private void setVariable(){
        entNomNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if (status == TextToSpeech.SUCCESS) {
                            tts.setLanguage(Locale.US);
                            tts.setSpeechRate(2.f);
                            tts.speak(entNomNext.getText().toString(), TextToSpeech.QUEUE_ADD, null);
                        }
                    }
                });
                if (entnom.getText().toString().equals("55000")){
                    Intent intent = new Intent(masukkannominal.this, masukkanpin.class);
                    startActivity(intent);
                }
            }
        });
    }
    private void intView(){
        entnom =findViewById(R.id.entnom);
        entNomNext = findViewById(R.id.entNomNext);
    }
}