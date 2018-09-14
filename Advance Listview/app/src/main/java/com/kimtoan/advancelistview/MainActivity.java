package com.kimtoan.advancelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvFruits;
    ArrayList arrayFruits;
    FruitAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Reflection();
        adapter = new FruitAdapter(this, R.layout.layout_fruits, arrayFruits);
        lvFruits.setAdapter(adapter);
    }

    private void Reflection() {
        lvFruits = (ListView) findViewById(R.id.listviewFruit);
        arrayFruits = new ArrayList<>();

        arrayFruits.add(new Fruits("Straberry", "Straberry at Da Lat", R.drawable.strawberry));
        arrayFruits.add(new Fruits("Tomato", "tomato at Da Lat", R.drawable.tomato));
        arrayFruits.add(new Fruits("apple", "apple at USA", R.drawable.apple));
        arrayFruits.add(new Fruits("rabutan", "rabutan at Dong Nai", R.drawable.rabutan));
    }
}
