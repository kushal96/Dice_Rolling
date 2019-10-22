package com.example.assignment_2;

import android.content.Context;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Dice_Rolling extends AppCompatActivity {

    public static final Random RamNumber = new Random();//variable for random number generator
    private Button dice_roll;//button variable
    private ImageView dice1,dice2,dice3,dice4,dice5,dice6;//variable for dice images

    private SensorManager dice_rolling;//variable for sensing

    private float accelerometervalue;
    private float accelerometerlast;
    private float shakeValue;//variable for shake detetction
    private EditText getDiceValue;//variable for entering dice number
    private TextView ques;//variable for question
    static MediaPlayer mp;//variable for sound effect

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dice_rolling = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        dice_rolling.registerListener(sensorListener,dice_rolling.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);

        accelerometervalue =  SensorManager.GRAVITY_EARTH;
        accelerometerlast =  SensorManager.GRAVITY_EARTH;
        shakeValue =  0.00f;

        setContentView(R.layout.activity_dice__rolling);
        //variables for finding elements from xml
        dice_roll = (Button)findViewById(R.id.dice_roll);
        dice1 = (ImageView)findViewById(R.id.dice1);
        dice2 = (ImageView)findViewById(R.id.dice2);
        dice3 = (ImageView)findViewById(R.id.dice3);
        dice4 = (ImageView)findViewById(R.id.dice4);
        dice5 = (ImageView)findViewById(R.id.dice5);
        dice6 = (ImageView)findViewById(R.id.dice6);
        ques = findViewById(R.id.textViewQues);

        //in the beginnning all the dices will be disable
        dice1.setVisibility(View.INVISIBLE);
        dice2.setVisibility(View.INVISIBLE);
        dice3.setVisibility(View.INVISIBLE);
        dice4.setVisibility(View.INVISIBLE);
        dice5.setVisibility(View.INVISIBLE);
        dice6.setVisibility(View.INVISIBLE);
        // [6]
        final MediaPlayer mPlayer = MediaPlayer.create(this,R.raw.roll_dice);

        getDiceValue= (EditText)findViewById(R.id.getDiceValue);

        //button click method
        dice_roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //while button is clicked the question will be disappeared


                //variable for fetching dice number from user input and using in switch case
                String dice_no = getDiceValue.getText().toString();
                // [1]
                switch (dice_no){//According to user input dice will be appeared
                       case "1":
                        //starts the dice rolling sound
                        mPlayer.start();
                        //logic for making dice visible and invisible
                        dice1.setVisibility(View.VISIBLE);
                        dice2.setVisibility(View.INVISIBLE);
                        dice3.setVisibility(View.INVISIBLE);
                        dice4.setVisibility(View.INVISIBLE);
                        dice5.setVisibility(View.INVISIBLE);
                        dice6.setVisibility(View.INVISIBLE);
                        ques.setVisibility(View.GONE);
                        //fetches dice value from random function
                        int val1_1 = dice_value();
                        int pic1_1 = getResources().getIdentifier("dice_side_" + val1_1, "drawable", "com.example.assignment_2");
                        //for interchanging the dice images according to  random number generated from random function
                        dice1.setImageResource(pic1_1);
                        break;
                    case "2":
                        // [6]
                        mPlayer.start();
                        dice1.setVisibility(View.VISIBLE);
                        dice2.setVisibility(View.VISIBLE);
                        dice3.setVisibility(View.INVISIBLE);
                        dice4.setVisibility(View.INVISIBLE);
                        dice5.setVisibility(View.INVISIBLE);
                        dice6.setVisibility(View.INVISIBLE);
                        ques.setVisibility(View.GONE);
                        int val2_1 = dice_value();
                        int val2_2 = dice_value();
                        int pic2_1 = getResources().getIdentifier("dice_side_" + val2_1, "drawable", "com.example.assignment_2");
                        int pic2_2 = getResources().getIdentifier("dice_side_" + val2_2, "drawable", "com.example.assignment_2");
                        dice1.setImageResource(pic2_1);
                        dice2.setImageResource(pic2_2);
                        break;
                    case "3":
                        mPlayer.start();
                        dice1.setVisibility(View.VISIBLE);
                        dice2.setVisibility(View.VISIBLE);
                        dice3.setVisibility(View.VISIBLE);
                        dice4.setVisibility(View.INVISIBLE);
                        dice5.setVisibility(View.INVISIBLE);
                        dice6.setVisibility(View.INVISIBLE);
                        ques.setVisibility(View.GONE);
                        int val3_1 = dice_value();
                        int val3_2 = dice_value();
                        int val3_3 = dice_value();
                        int pic3_1 = getResources().getIdentifier("dice_side_" + val3_1, "drawable", "com.example.assignment_2");
                        int pic3_2 = getResources().getIdentifier("dice_side_" + val3_2, "drawable", "com.example.assignment_2");
                        int pic3_3 = getResources().getIdentifier("dice_side_" + val3_3, "drawable", "com.example.assignment_2");
                        dice1.setImageResource(pic3_1);
                        dice2.setImageResource(pic3_2);
                        dice3.setImageResource(pic3_3);
                        break;
                    case "4":
                        mPlayer.start();
                        dice1.setVisibility(View.VISIBLE);
                        dice2.setVisibility(View.VISIBLE);
                        dice3.setVisibility(View.VISIBLE);
                        dice4.setVisibility(View.VISIBLE);
                        dice5.setVisibility(View.INVISIBLE);
                        dice6.setVisibility(View.INVISIBLE);
                        ques.setVisibility(View.GONE);
                        int val4_1 = dice_value();
                        int val4_2 = dice_value();
                        int val4_3 = dice_value();
                        int val4_4 = dice_value();
                        int pic4_1 = getResources().getIdentifier("dice_side_" + val4_1, "drawable", "com.example.assignment_2");
                        int pic4_2 = getResources().getIdentifier("dice_side_" + val4_2, "drawable", "com.example.assignment_2");
                        int pic4_3 = getResources().getIdentifier("dice_side_" + val4_3, "drawable", "com.example.assignment_2");
                        int pic4_4 = getResources().getIdentifier("dice_side_" + val4_4, "drawable", "com.example.assignment_2");
                        dice1.setImageResource(pic4_1);
                        dice2.setImageResource(pic4_2);
                        dice3.setImageResource(pic4_3);
                        dice4.setImageResource(pic4_4);
                        break;
                    case "5":
                        mPlayer.start();
                        dice1.setVisibility(View.VISIBLE);
                        dice2.setVisibility(View.VISIBLE);
                        dice3.setVisibility(View.VISIBLE);
                        dice4.setVisibility(View.VISIBLE);
                        dice5.setVisibility(View.VISIBLE);
                        dice6.setVisibility(View.INVISIBLE);
                        ques.setVisibility(View.GONE);
                        int val5_1 = dice_value();
                        int val5_2 = dice_value();
                        int val5_3 = dice_value();
                        int val5_4 = dice_value();
                        int val5_5 = dice_value();
                        int pic5_1 = getResources().getIdentifier("dice_side_" + val5_1, "drawable", "com.example.assignment_2");
                        int pic5_2 = getResources().getIdentifier("dice_side_" + val5_2, "drawable", "com.example.assignment_2");
                        int pic5_3 = getResources().getIdentifier("dice_side_" + val5_3, "drawable", "com.example.assignment_2");
                        int pic5_4 = getResources().getIdentifier("dice_side_" + val5_4, "drawable", "com.example.assignment_2");
                        int pic5_5 = getResources().getIdentifier("dice_side_" + val5_5, "drawable", "com.example.assignment_2");
                        dice1.setImageResource(pic5_1);
                        dice2.setImageResource(pic5_2);
                        dice3.setImageResource(pic5_3);
                        dice4.setImageResource(pic5_4);
                        dice5.setImageResource(pic5_5);
                        break;
                    case "6":
                        mPlayer.start();
                        dice1.setVisibility(View.VISIBLE);
                        dice2.setVisibility(View.VISIBLE);
                        dice3.setVisibility(View.VISIBLE);
                        dice4.setVisibility(View.VISIBLE);
                        dice5.setVisibility(View.VISIBLE);
                        dice6.setVisibility(View.VISIBLE);
                        ques.setVisibility(View.GONE);
                        int val6_1 = dice_value();
                        int val6_2 = dice_value();
                        int val6_3 = dice_value();
                        int val6_4 = dice_value();
                        int val6_5 = dice_value();
                        int val6_6 = dice_value();
                        int pic6_1 = getResources().getIdentifier("dice_side_" + val6_1, "drawable", "com.example.assignment_2");
                        int pic6_2 = getResources().getIdentifier("dice_side_" + val6_2, "drawable", "com.example.assignment_2");
                        int pic6_3 = getResources().getIdentifier("dice_side_" + val6_3, "drawable", "com.example.assignment_2");
                        int pic6_4 = getResources().getIdentifier("dice_side_" + val6_4, "drawable", "com.example.assignment_2");
                        int pic6_5 = getResources().getIdentifier("dice_side_" + val6_5, "drawable", "com.example.assignment_2");
                        int pic6_6 = getResources().getIdentifier("dice_side_" + val6_6, "drawable", "com.example.assignment_2");
                        dice1.setImageResource(pic6_1);
                        dice2.setImageResource(pic6_2);
                        dice3.setImageResource(pic6_3);
                        dice4.setImageResource(pic6_4);
                        dice5.setImageResource(pic6_5);
                        dice6.setImageResource(pic6_6);
                        break;
                    default://which tells users dice will be appaeared only input value is between 1 to 6
                        Toast.makeText(Dice_Rolling.this, "Only 1 to 6 input accepted", Toast.LENGTH_SHORT).show();
                }
            }

        });

    }
    //method for random number generation
    public static int dice_value(){
        return RamNumber.nextInt(6)+1;
    }
    //method nd logic for shake detection
    //[4]
    private final SensorEventListener sensorListener = new SensorEventListener() {
        MediaPlayer mp;
        @Override
        public void onSensorChanged(SensorEvent event) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            accelerometerlast = accelerometervalue;
            //logic for shake detection
            accelerometervalue = (float) Math.sqrt((double) (x*x + y*y + z*z));
            float delta = accelerometervalue-accelerometerlast;
            shakeValue = shakeValue *0.9f + delta;


            if (shakeValue > 3){//sensitivity for shake detection
                // [6]
                final MediaPlayer mPlayer = MediaPlayer.create(Dice_Rolling.this,R.raw.roll_dice);
                String dice_no = getDiceValue.getText().toString();
                // [1]
                switch (dice_no) {
                    case "1":
                        //same logic implemented as Button click
                        ques.setVisibility(View.GONE);
                        mPlayer.start();
                        dice1.setVisibility(View.VISIBLE);
                        dice2.setVisibility(View.INVISIBLE);
                        dice3.setVisibility(View.INVISIBLE);
                        dice4.setVisibility(View.INVISIBLE);
                        dice5.setVisibility(View.INVISIBLE);
                        dice6.setVisibility(View.INVISIBLE);
                        int val1_1 = dice_value();
                        int pic1_1 = getResources().getIdentifier("dice_side_" + val1_1, "drawable", "com.example.assignment_2");
                        dice1.setImageResource(pic1_1);
                        break;
                    case "2":
                        ques.setVisibility(View.GONE);
                        mPlayer.start();
                        dice1.setVisibility(View.VISIBLE);
                        dice2.setVisibility(View.VISIBLE);
                        dice3.setVisibility(View.INVISIBLE);
                        dice4.setVisibility(View.INVISIBLE);
                        dice5.setVisibility(View.INVISIBLE);
                        dice6.setVisibility(View.INVISIBLE);
                        int val2_1 = dice_value();
                        int val2_2 = dice_value();
                        int pic2_1 = getResources().getIdentifier("dice_side_" + val2_1, "drawable", "com.example.assignment_2");
                        int pic2_2 = getResources().getIdentifier("dice_side_" + val2_2, "drawable", "com.example.assignment_2");
                        dice1.setImageResource(pic2_1);
                        dice2.setImageResource(pic2_2);
                        break;
                    case "3":
                        ques.setVisibility(View.GONE);
                        mPlayer.start();
                        dice1.setVisibility(View.VISIBLE);
                        dice2.setVisibility(View.VISIBLE);
                        dice3.setVisibility(View.VISIBLE);
                        dice4.setVisibility(View.INVISIBLE);
                        dice5.setVisibility(View.INVISIBLE);
                        dice6.setVisibility(View.INVISIBLE);
                        int val3_1 = dice_value();
                        int val3_2 = dice_value();
                        int val3_3 = dice_value();
                        int pic3_1 = getResources().getIdentifier("dice_side_" + val3_1, "drawable", "com.example.assignment_2");
                        int pic3_2 = getResources().getIdentifier("dice_side_" + val3_2, "drawable", "com.example.assignment_2");
                        int pic3_3 = getResources().getIdentifier("dice_side_" + val3_3, "drawable", "com.example.assignment_2");
                        dice1.setImageResource(pic3_1);
                        dice2.setImageResource(pic3_2);
                        dice3.setImageResource(pic3_3);
                        break;
                    case "4":
                        ques.setVisibility(View.GONE);
                        mPlayer.start();
                        dice1.setVisibility(View.VISIBLE);
                        dice2.setVisibility(View.VISIBLE);
                        dice3.setVisibility(View.VISIBLE);
                        dice4.setVisibility(View.VISIBLE);
                        dice5.setVisibility(View.INVISIBLE);
                        dice6.setVisibility(View.INVISIBLE);
                        int val4_1 = dice_value();
                        int val4_2 = dice_value();
                        int val4_3 = dice_value();
                        int val4_4 = dice_value();
                        int pic4_1 = getResources().getIdentifier("dice_side_" + val4_1, "drawable", "com.example.assignment_2");
                        int pic4_2 = getResources().getIdentifier("dice_side_" + val4_2, "drawable", "com.example.assignment_2");
                        int pic4_3 = getResources().getIdentifier("dice_side_" + val4_3, "drawable", "com.example.assignment_2");
                        int pic4_4 = getResources().getIdentifier("dice_side_" + val4_4, "drawable", "com.example.assignment_2");
                        dice1.setImageResource(pic4_1);
                        dice2.setImageResource(pic4_2);
                        dice3.setImageResource(pic4_3);
                        dice4.setImageResource(pic4_4);
                        break;
                    case "5":
                        ques.setVisibility(View.GONE);
                        mPlayer.start();
                        dice1.setVisibility(View.VISIBLE);
                        dice2.setVisibility(View.VISIBLE);
                        dice3.setVisibility(View.VISIBLE);
                        dice4.setVisibility(View.VISIBLE);
                        dice5.setVisibility(View.VISIBLE);
                        dice6.setVisibility(View.INVISIBLE);
                        int val5_1 = dice_value();
                        int val5_2 = dice_value();
                        int val5_3 = dice_value();
                        int val5_4 = dice_value();
                        int val5_5 = dice_value();
                        int pic5_1 = getResources().getIdentifier("dice_side_" + val5_1, "drawable", "com.example.assignment_2");
                        int pic5_2 = getResources().getIdentifier("dice_side_" + val5_2, "drawable", "com.example.assignment_2");
                        int pic5_3 = getResources().getIdentifier("dice_side_" + val5_3, "drawable", "com.example.assignment_2");
                        int pic5_4 = getResources().getIdentifier("dice_side_" + val5_4, "drawable", "com.example.assignment_2");
                        int pic5_5 = getResources().getIdentifier("dice_side_" + val5_5, "drawable", "com.example.assignment_2");
                        dice1.setImageResource(pic5_1);
                        dice2.setImageResource(pic5_2);
                        dice3.setImageResource(pic5_3);
                        dice4.setImageResource(pic5_4);
                        dice5.setImageResource(pic5_5);
                        break;
                    case "6":
                        ques.setVisibility(View.GONE);
                        mPlayer.start();
                        dice1.setVisibility(View.VISIBLE);
                        dice2.setVisibility(View.VISIBLE);
                        dice3.setVisibility(View.VISIBLE);
                        dice4.setVisibility(View.VISIBLE);
                        dice5.setVisibility(View.VISIBLE);
                        dice6.setVisibility(View.VISIBLE);
                        int val6_1 = dice_value();
                        int val6_2 = dice_value();
                        int val6_3 = dice_value();
                        int val6_4 = dice_value();
                        int val6_5 = dice_value();
                        int val6_6 = dice_value();
                        int pic6_1 = getResources().getIdentifier("dice_side_" + val6_1, "drawable", "com.example.assignment_2");
                        int pic6_2 = getResources().getIdentifier("dice_side_" + val6_2, "drawable", "com.example.assignment_2");
                        int pic6_3 = getResources().getIdentifier("dice_side_" + val6_3, "drawable", "com.example.assignment_2");
                        int pic6_4 = getResources().getIdentifier("dice_side_" + val6_4, "drawable", "com.example.assignment_2");
                        int pic6_5 = getResources().getIdentifier("dice_side_" + val6_5, "drawable", "com.example.assignment_2");
                        int pic6_6 = getResources().getIdentifier("dice_side_" + val6_6, "drawable", "com.example.assignment_2");
                        dice1.setImageResource(pic6_1);
                        dice2.setImageResource(pic6_2);
                        dice3.setImageResource(pic6_3);
                        dice4.setImageResource(pic6_4);
                        dice5.setImageResource(pic6_5);
                        dice6.setImageResource(pic6_6);
                        break;
                    default://which tells users dice will be appaeared only input value is between 1 to 6
                        Toast.makeText(Dice_Rolling.this, "Only 1 to 6 input accepted", Toast.LENGTH_SHORT).show();
                }
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {//element of sensor detection

        }
    };


}
