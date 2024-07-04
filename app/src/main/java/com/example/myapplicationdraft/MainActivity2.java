package com.example.myapplicationdraft;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class MainActivity2 extends AppCompatActivity {
    private EditText password;
    private Button masuk;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        intView();
        setVariable();
    }
    private void setVariable(){
        masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if (status == TextToSpeech.SUCCESS) {
                            tts.setLanguage(Locale.US);
                            tts.setSpeechRate(2.f);
                            tts.speak(masuk.getText().toString(), TextToSpeech.QUEUE_ADD, null);
                        }
                    }
                });
                if (password.getText().toString().equals("1234")){
                    Intent intent = new Intent(MainActivity2.this, home.class);
                    startActivity(intent);
                }
            }
        });
    }
    private void intView(){
        password =findViewById(R.id.password);
        masuk = findViewById(R.id.masuk);
    }
}