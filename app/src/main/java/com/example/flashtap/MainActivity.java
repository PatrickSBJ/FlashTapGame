package com.example.flashtap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView.OnEditorActionListener;
import android.view.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


public class MainActivity extends AppCompatActivity {

    FlashTapGame game = new FlashTapGame();

    public static final String NAME = "Name";
    public static final String SCORE = "Score";

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
    private SharedPreferences sharedPrefs;
    private TextView nameEditText;
    private String playerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a List that will hold Map objects
        ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
        // Create Map objects, add data and put them in the List
        HashMap<String, String> map = new HashMap<String, String>();
        map.put(NAME, "Patrick");
        map.put(SCORE, "1,000,000");
        data.add(map);
        map = new HashMap<String, String>();
        map.put(NAME, "Em");
        map.put(SCORE, "99,000");
        data.add(map);
        map = new HashMap<String, String>();
        map.put(NAME, "Duong");
        map.put(SCORE, "55,000");
        data.add(map);

        // Create the adapter object
        SimpleAdapter adapter = new SimpleAdapter(this,
                data,
                R.layout.leaderboard_layout,
                new String[]{NAME, SCORE},
                new int[] {
                        R.id.NameTextView,
                        R.id.scoreTextView,
                } );

        ListView mainListView = findViewById(R.id.leaderboardListView);
        mainListView.setAdapter(adapter);

        instructionsLabel = (TextView) findViewById(R.id.instructionsLabel);
        nameEditText = findViewById(R.id.nameEditText);
        colorImage = (ImageView) findViewById(R.id.colorImage);
        startButton = (Button) findViewById(R.id.startButton);

        startButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                startClick();
            };
        });

        sharedPrefs = getSharedPreferences("Shared", MODE_PRIVATE);

        CycleColors();
    }
    @Override
    protected void onPause()
    {
        playerName = nameEditText.getText().toString();
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("playerName", playerName);
        editor.apply();
        super.onPause();
    }
    @Override
    protected void onResume()
    {

        playerName = sharedPrefs.getString("playerName", "");
        super.onResume();
    }
    public void CycleColors()
    {

        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                int repeatCount = 0;
                Handler handler = new Handler();

                SwitchImage();
                repeatCount ++;
                if(repeatCount < 5) {
                    handler.postDelayed(this, 3000);
                }
            }
        };
    }

    public void SwitchImage()
    {
        Random ran = new Random();
        int x = ran.nextInt(0) + 5;

        colorImage.setImageResource((imgIds[x]));
    }
    public void startClick()
    {
        startButtonClicked = true;
    }

}
