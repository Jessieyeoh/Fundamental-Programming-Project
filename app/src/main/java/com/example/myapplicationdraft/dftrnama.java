package com.example.myapplicationdraft;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import java.util.Locale;

public class dftrnama extends AppCompatActivity {

    private Button nama1, nama2, nama3, nama4, nama5, nama6, dftrnamaback;
    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dftrnama); // Assuming this is the correct layout file

        initializeButtons();
        setButtonListeners();
    }

    private void initializeButtons() {
        nama1 = findViewById(R.id.nama1);
        nama2 = findViewById(R.id.nama2);
        nama3 = findViewById(R.id.nama3);
        nama4 = findViewById(R.id.nama4);
        nama5 = findViewById(R.id.nama5);
        nama6 = findViewById(R.id.nama6);
        dftrnamaback = findViewById(R.id.dftrnamaback);
    }

    private void setButtonListeners() {
        View.OnClickListener bankButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String buttonText = ((Button) v).getText().toString();
                tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if (status == TextToSpeech.SUCCESS) {
                            tts.setLanguage(Locale.US);
                            tts.setSpeechRate(2.f);
                            tts.speak(buttonText, TextToSpeech.QUEUE_ADD, null);
                        }
                    }
                });
                Intent intent = new Intent(dftrnama.this, masukkannominal.class);
                startActivity(intent);
            }
        };

        nama1.setOnClickListener(bankButtonClickListener);
        nama2.setOnClickListener(bankButtonClickListener);
        nama3.setOnClickListener(bankButtonClickListener);
        nama4.setOnClickListener(bankButtonClickListener);
        nama5.setOnClickListener(bankButtonClickListener);
        nama6.setOnClickListener(bankButtonClickListener);

        dftrnamaback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if (status == TextToSpeech.SUCCESS) {
                            tts.setLanguage(Locale.US);
                            tts.setSpeechRate(2.f);
                            tts.speak(dftrnamaback.getText().toString(), TextToSpeech.QUEUE_ADD, null);
                        }
                    }
                });
                Intent intent = new Intent(dftrnama.this, rekbank2.class);
                startActivity(intent);
            }
        });
    }
}