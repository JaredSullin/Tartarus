package com.example.tartarus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    MainActivity m3;
    TextView hpNumber, weaponName, mainAreaText;
    Button action1, action2, action3, action4, inventory;
    ImageView storyImage;

    Story story = new Story(this);

    private final String SHARED_PREFS = "shared preferences";
    String HP = "text";
    String WEAPON = "weapon";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        storyImage = findViewById(R.id.storyImage);
        hpNumber = findViewById(R.id.hpNumber);
        weaponName = findViewById(R.id.weapon);
        mainAreaText = findViewById(R.id.mainTextArea);

        inventory = findViewById(R.id.inventoryButton);

        action1 = findViewById(R.id.action1);
        action2 = findViewById(R.id.Continuing);
        action3 = findViewById(R.id.action3);
        action4 = findViewById(R.id.action4);


        story.startup();
        story.townGate();

        inventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                goToInventory();
            }
        });

        action1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                story.possibleEvent(story.nextAction1);

            }
        });

        action2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                story.possibleEvent(story.nextAction2);

            }
        });

        action3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                story.possibleEvent(story.nextAction3);

                if (story.nextAction3.equals("oldWoman")){
                    saveing();
                }


            }
        });

        action4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                story.possibleEvent(story.nextAction4);


            }
        });



    }

    public void action1(View view) {

        story.possibleEvent(story.nextAction1);

    }
    public void action2(View view) {

        story.possibleEvent(story.nextAction2);

    }
    public void action3(View view) {

        story.possibleEvent(story.nextAction3);

    }
    public void action4(View view) {

        story.possibleEvent(story.nextAction4);

    }
    public void goToTitle(){

        Intent titleScreen = new Intent(this, MainActivity.class);
        startActivity(titleScreen);
    }

    public void goToInventory(){

        Intent InventoryScreen = new Intent(this, Main3Activity.class);

        startActivity(InventoryScreen);

    }

    public void saveing() {


        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(HP, story.player.hp);
        editor.putString(WEAPON, story.player.currentWeapon.name);


        editor.apply();
        editor.commit();

        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();
    }

    public void loadData(){

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);

        if (sharedPreferences.contains(HP)) {
            hpNumber.setText(sharedPreferences.getInt(HP, 15));
        }
        if(sharedPreferences.contains(WEAPON)){
            weaponName.setText(sharedPreferences.getString(WEAPON, ""));
        }
    }


}
