package com.example.flashtap;

import androidx.appcompat.app.AppCompatActivity;

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



public class MainActivity extends AppCompatActivity {

    FlashTapGame game = new FlashTapGame();

    final int[] imgIds = new int[]
            {
                    R.drawable.white, R.drawable.blue,
                    R.drawable.orange, R.drawable.purple,
                    R.drawable.red,
            };
    final int numberOfColors = 5;
    private TextView instructionsLabel;
    private ImageView colorImage;
    private Button startButton;
    private boolean startButtonClicked = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        instructionsLabel = (TextView) findViewById(R.id.instructionsLabel);
        colorImage = (ImageView) findViewById(R.id.colorImage);
        startButton = (Button) findViewById(R.id.startButton);

        startButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                startClick();
            };
        });

        CycleColors();
    }

    public void CycleColors()
    {
        // for(int i = 0; i < numberOfColors; i++ )
          //  colorImage.setImageResource(imgIds[i]);


        while(startButtonClicked == true)

    }
    public void startClick()
    {
        startButtonClicked = true;
    }

}
