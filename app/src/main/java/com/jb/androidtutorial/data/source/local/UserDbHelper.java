package com.jb.androidtutorial.data.source.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class UserDbHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "user";
    private static final int DB_VERSION = 1;

    // Users table
    public static final String TABLE_USER = "user_table";
    public static final String COLUMN_USER_ID = "user_id";
    public static final String COLUMN_USER_NAME = "username";
    public static final String COLUMN_USER_PASSWORD = "password";

    public UserDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE IF NOT EXISTS " + TABLE_USER + " ("
                        + COLUMN_USER_ID + " integer primary key autoincrement, "
                        + COLUMN_USER_NAME + " text not null, "
                        + COLUMN_USER_PASSWORD + " text not null);"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
    }
}
