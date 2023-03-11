package com.example.lim2;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class fhome extends AppCompatActivity {
    private TextToSpeech mTTS;
    Button mButtonSpeak;
    TextView textbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fhome);
        mButtonSpeak= findViewById(R.id.button6);
        textbox=findViewById(R.id.textView8);
        mTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
              if (status==TextToSpeech.SUCCESS){
                  mTTS.setLanguage(Locale.ENGLISH);
              }else{
                  mButtonSpeak.setEnabled(true);
              }
            }
        });
        mButtonSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
            }
        });
    }

    private void speak(){
        String text=textbox.getText().toString();
        mTTS.setSpeechRate(0.8f);
        mTTS.speak(text,TextToSpeech.QUEUE_FLUSH,null);
    }
}