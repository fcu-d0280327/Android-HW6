package com.example.user.homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class EditNoteActivity extends AppCompatActivity {

    private EditText edtTitle, edtContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);
        edtTitle = (EditText)findViewById(R.id.edtTitle);
        edtContent = (EditText)findViewById(R.id.edtContent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        String title = edtTitle.getText().toString();
        String content = edtContent.getText().toString();
        Toast.makeText(this, "title:"+ title + " content:" + content, Toast.LENGTH_SHORT).show();
    }
}
