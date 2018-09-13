package com.kimtoan.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvLession;
    ArrayList<String> arrayCourse;
    Button bnAdd, bnUpdate, bnDelete;
    EditText txtNewLessionName;
    int Position = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Reflection();

        arrayCourse = new ArrayList<>();
        arrayCourse.add("Android");
        arrayCourse.add("PHP");
        arrayCourse.add("IOS");
        arrayCourse.add("Unity");
        arrayCourse.add("ASP.NET");

        // create Bridge to connect with array list

        final ArrayAdapter adaper = new ArrayAdapter(
                MainActivity.this,
                 android.R.layout.simple_list_item_1,
                 arrayCourse);

        // show list array
        lvLession.setAdapter(adaper);

        // set event

        lvLession.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,arrayCourse.get(position), Toast.LENGTH_SHORT).show();
            }
        });

        lvLession.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"Long click "+ position, Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        bnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lession =  txtNewLessionName.getText().toString();
                arrayCourse.add(lession);

                // reLoad listview
                adaper.notifyDataSetChanged();
            }
        });

        lvLession.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                txtNewLessionName.setText(arrayCourse.get(position));
                Position = position;
            }
        });

        // update
        bnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txtNewLessionName.getText().toString();
                if(name.isEmpty()){
                    Toast.makeText(MainActivity.this,"Please Choose Lession You Want To Update", Toast.LENGTH_SHORT).show();
                }
                else{
                    arrayCourse.set(Position, txtNewLessionName.getText().toString());
                    adaper.notifyDataSetChanged();
                }

            }
        });

        // delete
        bnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayCourse.remove(Position);
                adaper.notifyDataSetChanged();
            }
        });
    }

    private void Reflection() {
        lvLession = (ListView) findViewById(R.id.listviewLession);
        bnAdd = (Button) findViewById(R.id.buttonAdd);
        txtNewLessionName = (EditText) findViewById(R.id.editTextLessionName);
        bnUpdate = (Button) findViewById(R.id.buttonUpdate);
        bnDelete = (Button) findViewById(R.id.buttonDelete);

    }


}
