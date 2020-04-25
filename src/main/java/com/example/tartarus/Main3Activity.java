package com.example.tartarus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main3Activity extends AppCompatActivity {

    Main2Activity gs;
    Story story;

    Button inventoryBackButton, invbutton1, invbutton2, invbutton3, invbutton4, invbutton5, invbutton6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        inventoryBackButton = findViewById(R.id.backBGameScreen);

        invbutton1 = findViewById(R.id.invbutton1);
        invbutton2 = findViewById(R.id.invbutton2);
        invbutton3 = findViewById(R.id.invbutton3);
        invbutton4 = findViewById(R.id.invbutton4);
        invbutton5 = findViewById(R.id.invbutton5);
        invbutton6 = findViewById(R.id.invbutton6);


        inventoryBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                leaveInventory(v);

            }
        });


        invbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                itemused(invbutton1.getText().toString());
                invbutton1.setText("");
            }
        });

        invbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                itemused(invbutton2.getText().toString());
                invbutton2.setText("");
            }
        });

        invbutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                itemused(invbutton3.getText().toString());
                invbutton3.setText("");
            }
        });

        invbutton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                itemused(invbutton4.getText().toString());
                invbutton4.setText("");
            }
        });

        invbutton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                itemused(invbutton5.getText().toString());
                invbutton5.setText("");
            }
        });

        invbutton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                itemused(invbutton6.getText().toString());
                invbutton6.setText("");

            }
        });

    }

    public void leaveInventory(View view){
        Intent inventoryScreen = new Intent(this, Main2Activity.class);
        startActivity(inventoryScreen);

    }



    public void itemused(String name){

        switch(name){
            case "potion":
                story.player.hp =story.player.hp+ 3;
                gs.hpNumber.setText(story.player.hp + "");

                break;
            case "apple":
                story.player.hp =story.player.hp+ 1;
                gs.hpNumber.setText(story.player.hp + "");

                break;
            case "": break;

        }
    }


}
