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

public class masukkanpin2 extends AppCompatActivity {
    private EditText entpin2;
    private Button entPinNext2;
    private Button entPinBack2;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_masukkanpin2);
        intView();
        setVariable();
        entPinBack2 = findViewById(R.id.entPinBack2); // Find the button

        entPinBack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if (status == TextToSpeech.SUCCESS) {
                            tts.setLanguage(Locale.US);
                            tts.setSpeechRate(2.f);
                            tts.speak(entPinBack2.getText().toString(), TextToSpeech.QUEUE_ADD, null);
                        }
                    }
                });
                Intent intent = new Intent(masukkanpin2.this, masukkannominal2.class);
                startActivity(intent);
            }
        });
    }
    private void setVariable(){
        entPinNext2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if (status == TextToSpeech.SUCCESS) {
                            tts.setLanguage(Locale.US);
                            tts.setSpeechRate(2.f);
                            tts.speak(entPinNext2.getText().toString(), TextToSpeech.QUEUE_ADD, null);
                        }
                    }
                });
                if (entpin2.getText().toString().equals("123456")){
                    Intent intent = new Intent(masukkanpin2.this, berhasil.class);
                    startActivity(intent);
                }
            }
        });
    }
    private void intView(){
        entpin2 =findViewById(R.id.entpin2);
        entPinNext2 = findViewById(R.id.entPinNext2);
    }
}