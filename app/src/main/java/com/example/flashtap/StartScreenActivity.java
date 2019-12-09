package com.example.flashtap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView.OnEditorActionListener;
import android.view.KeyEvent;

public class StartScreenActivity extends AppCompatActivity implements View.OnClickListener
{
    private Button startGameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        startGameButton = findViewById(R.id.startGameButton);

        startGameButton.setOnClickListener(this);
    }
    public void onClick(View v)
    {
        //Start new activity
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
