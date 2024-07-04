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

public class masukkannominal2 extends AppCompatActivity {
    private EditText entnom2;
    private Button entNomNext2;
    private Button entNomBack2;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_masukkannominal2);
        intView();
        setVariable();
        entNomBack2 = findViewById(R.id.entNomBack2); // Find the button

        entNomBack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if (status == TextToSpeech.SUCCESS) {
                            tts.setLanguage(Locale.US);
                            tts.setSpeechRate(2.f);
                            tts.speak(entNomBack2.getText().toString(), TextToSpeech.QUEUE_ADD, null);
                        }
                    }
                });
                Intent intent = new Intent(masukkannominal2.this, transfer.class);
                startActivity(intent);
            }
        });
    }
    private void setVariable(){
        entNomNext2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if (status == TextToSpeech.SUCCESS) {
                            tts.setLanguage(Locale.US);
                            tts.setSpeechRate(2.f);
                            tts.speak(entNomNext2.getText().toString(), TextToSpeech.QUEUE_ADD, null);
                        }
                    }
                });
                if (entnom2.getText().toString().equals("55000")){
                    Intent intent = new Intent(masukkannominal2.this, masukkanpin2.class);
                    startActivity(intent);
                }
            }
        });
    }
    private void intView(){
        entnom2 =findViewById(R.id.entnom2);
        entNomNext2 = findViewById(R.id.entNomNext2);
    }
}