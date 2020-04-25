package com.example.tartarus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button start, continuing;



    Main2Activity gs;
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

                continuing(v);
            }
        });
    }

    public void start(View view){
        Intent startingScreen = new Intent(this, Main2Activity.class);
        startActivity(startingScreen);

    }

    public void continuing(View view){
        Intent startingScreen = new Intent(this, Main2Activity.class);
        startActivity(startingScreen);

    }
}
