package com.example.myapplicationdraft;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import java.util.Locale;

public class rekbank2 extends AppCompatActivity {

    private Button bri2, bni2, mandiri2, bsi2, btn2, banklain2, rekbankback2;
    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rekbank2); // Assuming this is the correct layout file

        initializeButtons();
        setButtonListeners();
    }

    private void initializeButtons() {
        bri2 = findViewById(R.id.bri2);
        bni2 = findViewById(R.id.bni2);
        mandiri2 = findViewById(R.id.mandiri2);
        bsi2 = findViewById(R.id.bsi2);
        btn2 = findViewById(R.id.btn2);
        banklain2 = findViewById(R.id.banklain2);
        rekbankback2 = findViewById(R.id.rekbankback2);
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
                Intent intent = new Intent(rekbank2.this, dftrnama.class);
                startActivity(intent);
            }
        };

        bri2.setOnClickListener(bankButtonClickListener);
        bni2.setOnClickListener(bankButtonClickListener);
        mandiri2.setOnClickListener(bankButtonClickListener);
        bsi2.setOnClickListener(bankButtonClickListener);
        btn2.setOnClickListener(bankButtonClickListener);
        banklain2.setOnClickListener(bankButtonClickListener);

        rekbankback2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if (status == TextToSpeech.SUCCESS) {
                            tts.setLanguage(Locale.US);
                            tts.setSpeechRate(2.f);
                            tts.speak(rekbankback2.getText().toString(), TextToSpeech.QUEUE_ADD, null);
                        }
                    }
                });
                Intent intent = new Intent(rekbank2.this, tfreklama.class);
                startActivity(intent);
            }
        });
    }
}