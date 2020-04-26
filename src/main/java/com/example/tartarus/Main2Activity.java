package com.example.tartarus;

// importing all needed imports

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

/**
 * description:  second screen of the app
 * param @: nothing
 *
 */

public class Main2Activity extends AppCompatActivity {

    // making text veiw variable
    TextView hpNumber, weaponName, mainAreaText;
    // making button varibles
    Button action1, action2, action3, action4;
    // making image area for the f=game screen
    ImageView storyImage;

    // creates object of the story this is how the buttons will work together with the moving of the text

    Story story = new Story(this);

    // need a shared prefrence varible name for saving data
    private final String SHARED_PREFS = "shared preferences";

    // need a shared prefrence extra varible name for saving data
    String HP = "Healthpoints";
    String WEAPON = "weapon";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // finding text veiws by id
        storyImage = findViewById(R.id.storyImage);
        hpNumber = findViewById(R.id.hpNumber);
        weaponName = findViewById(R.id.weapon);
        mainAreaText = findViewById(R.id.mainTextArea);

        // finding buttons by id
        action1 = findViewById(R.id.action1);
        action2 = findViewById(R.id.Continuing);
        action3 = findViewById(R.id.action3);
        action4 = findViewById(R.id.action4);

        // sets up att the variables like hp and the wepon name
        story.startup();
        // if there is data in shared prefrences or on your last play through you
        // saved this load and overites the data in the start up method
        loadData();
        // sends player to starting location using a method
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

    /**
     * description: sends the next events name to the storys switch statment that directs the story
     *
     * @param view
     */
    public void action1(View view) {

        story.possibleEvent(story.nextAction1);

    }

    /**
     * description: sends the next events name to the storys switch statment that directs the story
     *
     * @param view
     */
    public void action2(View view) {

        story.possibleEvent(story.nextAction2);

    }

    /**
     * description: sends the next events name to the storys switch statment that directs the story
     *
     * @param view
     */
    public void action3(View view) {

        story.possibleEvent(story.nextAction3);

    }

    /**
     * description: sends the next events name to the storys switch statment that directs the story
     *
     * @param view
     */
    public void action4(View view) {

        story.possibleEvent(story.nextAction4);

    }

    /**
     *  description: brings user from game screen to starting screen
     */
    public void goToTitle(){

        Intent titleScreen = new Intent(this, MainActivity.class);
        startActivity(titleScreen);
    }

    /**
     *  description: saves game
     */

    public void saveing() {


        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(HP, String.valueOf(story.player.hp));
        editor.putString(WEAPON, story.player.currentWeapon.name);



        editor.apply();

        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();
    }

    /**
     *  description: loads game rewrites values in game
     */
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

    /**
     *  description: resets all shared prefrences values
     */

    public void newGame(){

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);

        sharedPreferences.edit().clear().commit();


    }



}
