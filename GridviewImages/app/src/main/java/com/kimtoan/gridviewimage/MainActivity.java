package com.kimtoan.gridviewimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gvFlags;
    ArrayList<Images> arrayImage;
    ImageAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Reflection();
        adapter = new ImageAdapter(this, R.layout.image_line, arrayImage);
        gvFlags.setAdapter(adapter);

        gvFlags.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, arrayImage.get(position).getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void Reflection() {
        gvFlags = (GridView) findViewById(R.id.gridviewFlags);
        arrayImage = new ArrayList<>();
        arrayImage.add(new Images("Country 1", R.drawable.bodaonha));
        arrayImage.add(new Images("Country 2", R.drawable.cambodia));
        arrayImage.add(new Images("Country 3", R.drawable.halan));
        arrayImage.add(new Images("Country 4", R.drawable.conghoaczech));
        arrayImage.add(new Images("Country 5", R.drawable.indo));
        arrayImage.add(new Images("Country 6", R.drawable.malaysia));
        arrayImage.add(new Images("Country 7", R.drawable.singapore));
        arrayImage.add(new Images("Country 8", R.drawable.vietnam));
        arrayImage.add(new Images("Country 9", R.drawable.laos));
    }
}
