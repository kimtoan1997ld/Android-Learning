package com.kimtoan.imageview;

import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    ImageView imgHinh;
    RelativeLayout manhinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgHinh = (ImageView) findViewById(R.id.img);
        manhinh = (RelativeLayout) findViewById(R.id.mh);


        imgHinh.setImageResource(R.drawable.android1);
        manhinh.setBackgroundResource(R.drawable.hn);

    }
}
