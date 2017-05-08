package com.example.user.homework;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

public class EditNoteActivity extends AppCompatActivity {

    private EditText edtTitle, edtContent;
    SQLiteDatabase database;
    DBOpenHelper openHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);
        edtTitle = (EditText)findViewById(R.id.edtTitle);
        edtContent = (EditText)findViewById(R.id.edtContent);
        openHelper = new DBOpenHelper(this);
        database = openHelper.getWritableDatabase();
    }

    @Override
    protected void onPause() {
        super.onPause();
        String title = edtTitle.getText().toString();
        String content = edtContent.getText().toString();
        Cursor cursor = database.rawQuery("select * from " + DBOpenHelper.DATABASE_TABLE, null);
        int index = cursor.getCount();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBOpenHelper.DATABASE_ID, index);
        if(!title.isEmpty()){
            contentValues.put(DBOpenHelper.DATABASE_TITLE, title);
        }else{
            contentValues.put(DBOpenHelper.DATABASE_TITLE, "No Title");
        }
        if(!content.isEmpty()) {
            contentValues.put(DBOpenHelper.DATABASE_CONTENT, content);
        }else{
            contentValues.put(DBOpenHelper.DATABASE_CONTENT, "");
        }
        Log.d("title", edtTitle.getText().toString());
        database.insert(DBOpenHelper.DATABASE_TABLE, null, contentValues);
        database.close();
    }
}
