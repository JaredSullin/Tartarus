package com.example.tartarus;

// importing all needed imports

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 *   description:  starting screen of the app
 *  param @: nothing
 */

public class MainActivity extends AppCompatActivity {

    // a check to see if the person is restarting the game
    public static int restart = 0;
    // button variable names
    Button start, continuing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = findViewById(R.id.button1);
        continuing = findViewById(R.id.Continuing);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                start(v);
            }
        });

        continuing.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                MainActivity.restart = 1;
                restart(v);

            }
        });
    }

    /**
     * description: brings user to the game screen
     * @param view
     */
    public void start(View view){
        Intent startingScreen = new Intent(this, Main2Activity.class);
        startActivity(startingScreen);

    }

    /**
     * description restarts save data and brings you to game screen
     * @param view
     */
    public void restart(View view){
        Intent startingScreen = new Intent(this, Main2Activity.class);
        startActivity(startingScreen);

    }


}
