package com.jb.androidtutorial.data.source.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

public class UserDataSourceHelper {

    private Context mContext;
    private UserDbHelper dbHelper;

    private SQLiteDatabase db;

    public UserDataSourceHelper(Context context) {
        mContext = context;

        dbHelper = new UserDbHelper(context);
    }

    /**
     * Save username and password
     * @param username
     * @param password
     * @return
     */
    public boolean saveUsername(String username, String password) {
        boolean isSuccess = false;

        db = dbHelper.getWritableDatabase();
        db.beginTransaction();

        try {
            ContentValues cv = new ContentValues();
            cv.put(dbHelper.COLUMN_USER_NAME, username);
            cv.put(dbHelper.COLUMN_USER_PASSWORD, password);

            if(db.insert(dbHelper.TABLE_USER, null, cv) > 0) isSuccess = true;

            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }

        db.close();

        return isSuccess;
    }

    /**
     * Check if username is already been exist
     * @param username
     * @return
     */
    public boolean checkUsername(String username) {
        db = dbHelper.getReadableDatabase();

        String[] columns = new String[] {
                dbHelper.COLUMN_USER_NAME,
                dbHelper.COLUMN_USER_PASSWORD
        };
        String arg[] = new String[] { username };
        String selection = dbHelper.COLUMN_USER_NAME + "=?";

        Cursor cursor = db.query(dbHelper.TABLE_USER, columns, selection, arg, null, null, null);

        if(cursor != null) {
            if(cursor.getCount() > 0) {
                db.close();
                return true;
            }
        }

        db.close();
        return false;
    }

    /**
     * Authenticate credentials
     * @param username
     * @param password
     */
    public UserData login(String username, String password) {
        UserData userData = null;

        db = dbHelper.getReadableDatabase();

        String[] columns = new String[] {
                dbHelper.COLUMN_USER_NAME,
                dbHelper.COLUMN_USER_PASSWORD
        };
        String arg[] = new String[] { username };
        String selection = dbHelper.COLUMN_USER_NAME + "=?";

        Cursor cursor = db.query(dbHelper.TABLE_USER, columns, selection, arg, null, null, null);

        if(cursor != null) {
            if(cursor.getCount() > 0) {
                cursor.moveToFirst();

                String dbUsername = cursor.getString(cursor.getColumnIndex(dbHelper.COLUMN_USER_NAME));
                String dbPassword = cursor.getString(cursor.getColumnIndex(dbHelper.COLUMN_USER_PASSWORD));

                if(password.equals(dbPassword)) {
                    userData = new UserData();
                    userData.setUsername(dbUsername);
                    userData.setPassword(dbPassword);
                }
            }
        }

        db.close();
        return userData;
    }

}
