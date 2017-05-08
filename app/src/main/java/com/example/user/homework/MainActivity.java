package com.example.user.homework;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnAdd;
    private ListView lvNote;
    private ArrayList<String> arrayList;
    private SQLiteDatabase database;
    private DBOpenHelper openHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        openHelper = new DBOpenHelper(this);
        database = openHelper.getReadableDatabase();
    }

    private void findViews(){
        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent().setClass(MainActivity.this, EditNoteActivity.class));
            }
        });

        lvNote = (ListView)findViewById(R.id.lvNote);
    }

    private ArrayList<String> getTitleFromDatabase(){
        ArrayList<String> item = new ArrayList<String>();
        Cursor cursor = database.rawQuery("select * from " + DBOpenHelper.DATABASE_TABLE, null);

        String[] names = cursor.getColumnNames();

        for (int i = 0; i < names.length; i++){
            Log.d("columnName", cursor.getColumnIndex(names[i]) + ":" + names[i]);
        }

        cursor.moveToFirst();
        for (int i = 0; i < cursor.getCount(); i++){
            String title = cursor.getString(cursor.getColumnIndex(names[1]));
            Log.d(DBOpenHelper.DATABASE_TITLE, title);
            item.add(title);
            cursor.moveToNext();
        }
        return item;
    }

    @Override
    protected void onResume() {
        super.onResume();
        arrayList = getTitleFromDatabase();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, arrayList);
        lvNote.setAdapter(arrayAdapter);
    }
}
