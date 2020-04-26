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

import weapon.fist_Weapon;
import weapon.knife_Weapon;
import weapon.rapier_Weapon;
import weapon.sword_Weapon;

public class Main2Activity extends AppCompatActivity {

    MainActivity m3;
    TextView hpNumber, weaponName, mainAreaText;
    Button action1, action2, action3, action4;
    ImageView storyImage;

    Story story = new Story(this);

    private final String SHARED_PREFS = "shared preferences";

    String HP = "Healthpoints";
    String WEAPON = "weapon";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        storyImage = findViewById(R.id.storyImage);
        hpNumber = findViewById(R.id.hpNumber);
        weaponName = findViewById(R.id.weapon);
        mainAreaText = findViewById(R.id.mainTextArea);


        action1 = findViewById(R.id.action1);
        action2 = findViewById(R.id.Continuing);
        action3 = findViewById(R.id.action3);
        action4 = findViewById(R.id.action4);


        story.startup();
        loadData();
        story.townGate();



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


    public void saveing() {


        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(HP, String.valueOf(story.player.hp));
        editor.putString(WEAPON, story.player.currentWeapon.name);



        editor.apply();

        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();
    }

    public void loadData(){

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);

        if (sharedPreferences.contains(HP)) {
           hpNumber.setText(sharedPreferences.getString(HP, "15"));
           story.player.hp = Integer.parseInt(hpNumber.getText().toString());


        }
        if(sharedPreferences.contains(WEAPON)){
            weaponName.setText(sharedPreferences.getString(WEAPON, "Fist"));
            story.player.currentWeapon.name = weaponName.getText().toString();
        }

        if(story.player.currentWeapon.name.equalsIgnoreCase("rapier")){
            story.player.currentWeapon = new rapier_Weapon();
            weaponName.setText(story.player.currentWeapon.name);
        }
        else if(story.player.currentWeapon.name.equalsIgnoreCase("knife")){
            story.player.currentWeapon = new knife_Weapon();
            weaponName.setText(story.player.currentWeapon.name);
        }
        else if(story.player.currentWeapon.name.equalsIgnoreCase("sword")){
            story.player.currentWeapon = new sword_Weapon();
            weaponName.setText(story.player.currentWeapon.name);
        }
        else if(story.player.currentWeapon.name.equalsIgnoreCase("fist")){
            story.player.currentWeapon = new fist_Weapon();
            weaponName.setText(story.player.currentWeapon.name);
        }


    }

    public void newGame(){

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);

        sharedPreferences.edit().clear().commit();


    }



}
