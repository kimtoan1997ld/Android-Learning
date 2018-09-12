package com.kimtoan.animalrace;

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

    TextView txtDiem;
    CheckBox cbOne, cbTwo, cbThree;
    SeekBar skOne, skTwo, skThree;
    Button bnPlay;
    int score = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Reflection();


        final CountDownTimer countDownTimer = new CountDownTimer(60000,300) {
            @Override
            public void onTick(long millisUntilFinished) {
                int number  = 5;
                Random random = new Random();
                int one = random.nextInt(number);
                int two = random.nextInt(number);
                int three = random.nextInt(number);

                // seek bar Enable
                skOne.setEnabled(false);
                skTwo.setEnabled(false);
                skThree.setEnabled(false);
                // check win
                if(skOne.getProgress() >=  skOne.getMax())
                {
                    this.cancel();
                    bnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "One Win", Toast.LENGTH_SHORT).show();


                    //  check bet
                    if(cbOne.isChecked()){
                        score += 10;
                        Toast.makeText(MainActivity.this, "you are correct", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        score -= 10;
                        Toast.makeText(MainActivity.this, "you are wrong", Toast.LENGTH_SHORT).show();
                    }

                    txtDiem.setText(score + "");
                    EnableCheckbox();
                }

                if(skTwo.getProgress() >= skTwo.getMax())
                {
                    this.cancel();
                    bnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Two Win", Toast.LENGTH_SHORT).show();

                    //  check bet
                    if(cbTwo.isChecked()){
                        score += 10;
                        Toast.makeText(MainActivity.this, "you are correct", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        score -= 10;
                        Toast.makeText(MainActivity.this, "you are wrong", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(score + "");
                    EnableCheckbox();
                }

                if(skThree.getProgress() >= skThree.getMax()){
                    this.cancel();
                    bnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Three Win", Toast.LENGTH_SHORT).show();


                    //  check bet
                    if(cbThree.isChecked()){
                        score += 10;

                        Toast.makeText(MainActivity.this, "you are correct", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        score -= 10;
                        Toast.makeText(MainActivity.this, "you are wrong", Toast.LENGTH_SHORT).show();
                    }

                    txtDiem.setText(score + "");
                    EnableCheckbox();
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

                if(cbOne.isChecked() || cbTwo.isChecked() || cbThree.isChecked()){

                    skOne.setProgress(0);
                    skTwo.setProgress(0);
                    skThree.setProgress(0);

                    bnPlay.setVisibility(View.INVISIBLE);
                    countDownTimer.start();

                    DisableCheckbox();
                }
                else{
                    Toast.makeText(MainActivity.this, "Please bet One Animal", Toast.LENGTH_SHORT).show();
                }

            }
        });

        cbOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    // don't check 2 and 3
                    cbTwo.setChecked(false);
                    cbThree.setChecked(false);
                }
            }
        });

        cbTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    // don't check 1 and 3
                    cbOne.setChecked(false);
                    cbThree.setChecked(false);
                }
            }
        });

        cbThree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    // don't check 1 and 2
                    cbOne.setChecked(false);
                    cbTwo.setChecked(false);
                }
            }
        });
    }

    private void EnableCheckbox(){
        cbOne.setEnabled(true);
        cbTwo.setEnabled(true);
        cbThree.setEnabled((true));

    }

    private void DisableCheckbox(){
        cbOne.setEnabled(false);
        cbTwo.setEnabled(false);
        cbThree.setEnabled((false));
    }
    private void Reflection() {
        txtDiem     = (TextView) findViewById(R.id.txt_Diem);
        bnPlay      = (Button) findViewById(R.id.buttonPlay);
        cbOne       = (CheckBox) findViewById(R.id.checkboxOne);
        cbTwo       = (CheckBox) findViewById(R.id.checkboxTwo);
        cbThree     = (CheckBox) findViewById(R.id.checkboxThree);
        skOne       = (SeekBar) findViewById(R.id.seekbarOne);
        skTwo       = (SeekBar) findViewById(R.id.seekbarTwo);
        skThree     = (SeekBar) findViewById(R.id.seekbarThree);

    }
}
