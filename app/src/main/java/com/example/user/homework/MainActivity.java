package com.example.user.homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnAdd;
    private ListView lvNote;
    private ArrayList<String> item;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        lvNote = (ListView)findViewById(R.id.lvNote);
        item = new ArrayList<String>();
        item.add("a");
        item.add("b");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, item);
        lvNote.setAdapter(arrayAdapter);
    }
}
