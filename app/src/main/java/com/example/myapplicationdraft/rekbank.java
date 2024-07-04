package com.example.myapplicationdraft;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import java.util.Locale;

public class rekbank extends AppCompatActivity {

    private Button bri, bni, mandiri, bsi, btn, banklain, rekbankback;
    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rekbank); // Assuming this is the correct layout file

        initializeButtons();
        setButtonListeners();
    }

    private void initializeButtons() {
        bri = findViewById(R.id.bri);
        bni = findViewById(R.id.bni);
        mandiri = findViewById(R.id.mandiri);
        bsi = findViewById(R.id.bsi);
        btn = findViewById(R.id.btn);
        banklain = findViewById(R.id.banklain);
        rekbankback = findViewById(R.id.rekbankback);
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
                Intent intent = new Intent(rekbank.this, norektujuan2.class);
                startActivity(intent);
            }
        };

        bri.setOnClickListener(bankButtonClickListener);
        bni.setOnClickListener(bankButtonClickListener);
        mandiri.setOnClickListener(bankButtonClickListener);
        bsi.setOnClickListener(bankButtonClickListener);
        btn.setOnClickListener(bankButtonClickListener);
        banklain.setOnClickListener(bankButtonClickListener);

        rekbankback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if (status == TextToSpeech.SUCCESS) {
                            tts.setLanguage(Locale.US);
                            tts.setSpeechRate(2.f);
                            tts.speak(rekbankback.getText().toString(), TextToSpeech.QUEUE_ADD, null);
                        }
                    }
                });
                Intent intent = new Intent(rekbank.this, tfrekbaru.class);
                startActivity(intent);
            }
        });
    }
}