package com.example.user.homework;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBOpenHelper extends SQLiteOpenHelper {

    public static final String DATABASE_TABLE = "note";
    public static final String DATABASE_ID = "number";
    public static final String DATABASE_TITLE = "title";
    public static final String DATABASE_CONTENT = "body";
    private static final String CREATE_TABLE = "create table " + DATABASE_TABLE + "(" +
            DATABASE_ID + ", " + DATABASE_TITLE +", " + DATABASE_CONTENT + ");";
    private static final String DATABASE_NAME = "note.db";

    public DBOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
