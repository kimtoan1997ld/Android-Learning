package com.kimtoan.checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox cbAndroid, cbIOS, cbPHP;
    Button bnCommit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Reflection();
        cbAndroid.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if( isChecked){
                    Toast.makeText(MainActivity.this, "You Are choosing Android",Toast.LENGTH_SHORT);
                }
            }
        });
        cbIOS.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if( isChecked){
                    Toast.makeText(MainActivity.this, "You Are choosing IOS",Toast.LENGTH_SHORT);
                }
            }
        });

        cbPHP.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if( isChecked){
                    Toast.makeText(MainActivity.this, "You Are choosing PHP",Toast.LENGTH_SHORT);
                }
            }
        });

        bnCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lesson = "You Choose lesson : \n";
                if(cbAndroid.isChecked()){
                    lesson += cbAndroid.getText() + "\n";
                }
                if(cbIOS.isChecked()){
                    lesson += cbIOS.getText() + "\n";
                }
                if(cbPHP.isChecked()){
                    lesson += cbPHP.getText() + "\n";
                }

                Toast.makeText(MainActivity.this, lesson, Toast.LENGTH_SHORT);

            }
        });
    }

    private void Reflection() {
        cbAndroid   = (CheckBox)findViewById(R.id.checkBoxAndroid);
        cbIOS       = (CheckBox) findViewById(R.id.checkBoxIOS);
        cbPHP       = (CheckBox) findViewById(R.id.checkBoxPHP);
        bnCommit = (Button) findViewById(R.id.buttonCommit);
    }
}
