package com.example.myapplicationdraft;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class saldo extends AppCompatActivity {
    private Button saldoback;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_saldo);
        saldoback = findViewById(R.id.saldoback); // Find the button

        saldoback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if (status == TextToSpeech.SUCCESS) {
                            tts.setLanguage(Locale.US);
                            tts.setSpeechRate(2.f);
                            tts.speak(saldoback.getText().toString(), TextToSpeech.QUEUE_ADD, null);
                        }
                    }
                });
                // Start the HomeActivity
                Intent intent = new Intent(saldo.this, home.class);
                startActivity(intent);
            }
        });
        TextView textView1 = findViewById(R.id.saldo);
        TextView textView2 = findViewById(R.id.isisaldo);

        String text1 = "Saldo Anda";
        String text2 = "Rp 2.500.000";

        textView1.setText(text1);
        textView2.setText(text2);

        String combinedText = text1 + ". " + text2;

        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    tts.setLanguage(new Locale("id", "ID"));
                    tts.speak(combinedText, TextToSpeech.QUEUE_FLUSH, null, null);
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }
}