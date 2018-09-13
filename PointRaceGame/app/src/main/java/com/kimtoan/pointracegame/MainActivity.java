package com.kimtoan.pointracegame;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button bnPlay;
    TextView txtScore;
    CheckBox cbOne, cbTwo, cbThree;
    SeekBar skOne, skTwo, skThree;

    int score = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Reflection();

        skOne.setEnabled(false);
        skTwo.setEnabled(false);
        skThree.setEnabled(false);
        final CountDownTimer countDownTime = new CountDownTimer(60000, 300) {
            @Override
            public void onTick(long millisUntilFinished) {
                Random random = new Random();

                int one = random.nextInt(5);
                int two = random.nextInt(5);
                int three = random.nextInt(5);

                if(skOne.getProgress() >= skOne.getMax())
                {
                    this.cancel();
                    Toast.makeText(MainActivity.this, "One Win",Toast.LENGTH_SHORT).show();

                    if(cbOne.isChecked()){
                        score += 10;
                    }
                    else {
                        score -= 10;
                    }
                    ResetScore(score);
                    EnableCheckBox();
                    bnPlay.setVisibility(View.VISIBLE);
                    txtScore.setText(score + "");
                    EnableCheckBox();
                }
                if(skTwo.getProgress() >= skTwo.getMax())
                {
                    this.cancel();
                    Toast.makeText(MainActivity.this, "Two Win",Toast.LENGTH_SHORT).show();

                    if(cbTwo.isChecked()){
                        score += 10;
                    }
                    else {
                        score -= 10;
                    }

                    EnableCheckBox();
                    bnPlay.setVisibility(View.VISIBLE);
                    txtScore.setText(score + "");
                }
                if(skThree.getProgress() >= skThree.getMax())
                {
                    this.cancel();
                    Toast.makeText(MainActivity.this, "Three Win",Toast.LENGTH_SHORT).show();


                    if(cbOne.isChecked()){
                        score += 10;
                    }
                    else {
                        score -= 10;
                    }
                    ResetScore(score);
                    EnableCheckBox();
                    ResetScore(score);
                    txtScore.setText(score + "");
                    bnPlay.setVisibility(View.VISIBLE);

                }

                skOne.setProgress(skOne.getProgress() + one);
                skTwo.setProgress(skTwo.getProgress() + two);
                skThree.setProgress(skThree.getProgress() + three);


            }

            @Override
            public void onFinish() {

            }
        };
        bnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(cbOne.isChecked()|| cbTwo.isChecked()|| cbThree.isChecked())
                {
                    skOne.setProgress(0);
                    skTwo.setProgress(0);
                    skThree.setProgress(0);
                    bnPlay.setVisibility(View.INVISIBLE);
                    DisanableCheckBox();
                    countDownTime.start();

                }
                else
                {
                    Toast.makeText(MainActivity.this, "Please choose your bet",Toast.LENGTH_SHORT).show();
                }

            }
        });

        cbOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    cbTwo.setChecked(false);
                    cbThree.setChecked(false);
                }
            }
        });

        cbTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    cbOne.setChecked(false);
                    cbThree.setChecked(false);
                }
            }
        });

        cbThree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    cbOne.setChecked(false);
                    cbTwo.setChecked(false);

                }
            }
        });
    }

    private void EnableCheckBox(){
       cbOne.setEnabled(true);
       cbTwo.setEnabled(true);
       cbThree.setEnabled(true);
    }

    private void DisanableCheckBox(){
        cbOne.setEnabled(false);
        cbTwo.setEnabled(false);
        cbThree.setEnabled(false);
    }
    private void ResetScore(int score){
        if(score <= 0 ){
            score = 100;
        }
    }
    private void Reflection() {
        cbOne = (CheckBox) findViewById(R.id.checkboxOne);
        cbTwo = (CheckBox) findViewById(R.id.checkboxTwo);
        cbThree = (CheckBox) findViewById(R.id.checkboxThree);

        skOne = (SeekBar) findViewById(R.id.seekbarOne);
        skTwo = (SeekBar) findViewById(R.id.seekbarTwo);
        skThree = (SeekBar) findViewById(R.id.seekbarThree);

        txtScore = (TextView) findViewById(R.id.textviewScore);
        bnPlay = (Button) findViewById(R.id.buttonPlay);
    }
}
