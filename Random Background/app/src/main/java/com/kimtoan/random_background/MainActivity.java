package com.kimtoan.random_background;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    LinearLayout linear;
    ArrayList<Integer> arrayImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linear = (LinearLayout)findViewById(R.id.myLinearLayout);

        arrayImage = new ArrayList<>();
        arrayImage.add(R.drawable.images);
        arrayImage.add(R.drawable.bacground1);
        arrayImage.add(R.drawable.background2);

        Random random = new Random();
        int vitri = random.nextInt(arrayImage.size());

        linear.setBackgroundResource(arrayImage.get(vitri));
    }
}
