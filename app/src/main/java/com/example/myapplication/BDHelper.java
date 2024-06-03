package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BDHelper extends SQLiteOpenHelper {
public static final int DATABASE_VERSION = 1;
public static final String DATABASE_NAME = "androiddb";
public static final String TABLE_CONS = "android";

public static final String KEY_RES_1 = "res1";
public static final String KEY_RES_2 = "res2";
    public BDHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_CONS + "(" + KEY_RES_1 + " text, " + KEY_RES_2 + " integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_CONS);

        onCreate(db);
    }
}
