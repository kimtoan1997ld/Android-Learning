package com.kimtoan.random;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button Click;
    EditText Number1, Number2;
    TextView Result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Reflection();
        Click.setOnClickListener(new View.OnClickListener() {
            @Override

                public void onClick(View v) {
                String n1 = Number1.getText().toString().trim();
                String n2 = Number2.getText().toString().trim();
                Log.i("text",n1);
                Log.i("text",n2);
                if(n1.isEmpty()|| n2.length() == 0)
                {
                    Toast.makeText(MainActivity.this, "Please Enter Enough Number",Toast.LENGTH_SHORT);
                }
                else
                {
                    // Convert to Int
                    int min = Integer.parseInt(n1);
                    int max = Integer.parseInt(n2);

                    Log.i("text",min + "");
                    Log.i("text",max+"");
                    if(min - max > 0)
                    {
                        Toast.makeText(MainActivity.this, "Please Enter Number Min less than Max number",Toast.LENGTH_SHORT);
                    }
                  else{
                        Random random = new Random();
                        int result = random.nextInt(max - min + 1) + min;
                        Log.i("text",result + "");
                        // convert between int to string
                        Result.setText(result + "");
                    }
                }

            }
        });
    }

    private void Reflection(){
        Click = (Button) findViewById(R.id.bntClick);
        Number1 = (EditText) findViewById(R.id.edtNumber1);
        Number2 = (EditText) findViewById(R.id.editText2);
        Result = (TextView) findViewById(R.id. txtResult);
    }
}
