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

public class masukkanpin extends AppCompatActivity {
    private EditText entpin;
    private Button entPinNext;
    private Button entPinBack;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_masukkanpin);
        intView();
        setVariable();
        entPinBack = findViewById(R.id.entPinBack); // Find the button

        entPinBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if (status == TextToSpeech.SUCCESS) {
                            tts.setLanguage(Locale.US);
                            tts.setSpeechRate(2.f);
                            tts.speak(entPinBack.getText().toString(), TextToSpeech.QUEUE_ADD, null);
                        }
                    }
                });
                Intent intent = new Intent(masukkanpin.this, masukkannominal.class);
                startActivity(intent);
            }
        });
    }
    private void setVariable(){
        entPinNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if (status == TextToSpeech.SUCCESS) {
                            tts.setLanguage(Locale.US);
                            tts.setSpeechRate(2.f);
                            tts.speak(entPinNext.getText().toString(), TextToSpeech.QUEUE_ADD, null);
                        }
                    }
                });
                if (entpin.getText().toString().equals("123456")){
                    Intent intent = new Intent(masukkanpin.this, berhasil.class);
                    startActivity(intent);
                }
            }
        });
    }
    private void intView(){
        entpin =findViewById(R.id.entpin);
        entPinNext = findViewById(R.id.entPinNext);
    }
}