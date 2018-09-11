package com.kimtoan.aswitch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Switch swtWiff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swtWiff = (Switch) findViewById(R.id.switch1);

        swtWiff.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, "You Are Turn On WIFI", Toast.LENGTH_SHORT);
                }
                else{
                    Toast.makeText(MainActivity.this, "You Are Turn off WIFI", Toast.LENGTH_SHORT);
                }
            }
        });
    }
}
