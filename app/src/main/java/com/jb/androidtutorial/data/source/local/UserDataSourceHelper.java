package com.jb.androidtutorial.data.source.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import java.util.ArrayList;
import java.util.List;

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


            long affectedRow = db.insert(dbHelper.TABLE_USER, null, cv);

            if(affectedRow > 0) isSuccess = true;

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

        String selection = dbHelper.COLUMN_USER_NAME + "=?";

        String arg[] = new String[] { username };

        Cursor cursor = db.query(dbHelper.TABLE_USER, null, selection, arg, null, null, null);

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

        String selection = dbHelper.COLUMN_USER_NAME + "=?";
        String arg[] = new String[] { username };

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

    public List<UserData> getUsers() {
        List<UserData> userDataList = new ArrayList<>();

        db = dbHelper.getReadableDatabase();

        String[] columns = new String[] {
                dbHelper.COLUMN_USER_NAME,
                dbHelper.COLUMN_USER_PASSWORD
        };

        Cursor cursor = db.query(dbHelper.TABLE_USER, columns, null, null, null, null, null);

        if(cursor != null) {
            if(cursor.getCount() > 0) {
                cursor.moveToFirst();

                do {

                    String dbUsername = cursor.getString(cursor.getColumnIndex(dbHelper.COLUMN_USER_NAME));
                    String dbPassword = cursor.getString(cursor.getColumnIndex(dbHelper.COLUMN_USER_PASSWORD));

                    UserData user = new UserData();
                    user.setUsername(dbUsername);
                    user.setPassword(dbPassword);

                    userDataList.add(user);
                } while (cursor.moveToNext());


            }
        }

        db.close();
        return userDataList;
    }


    public void updateUser(String username, String password) {
        db = dbHelper.getWritableDatabase();

        String selection = dbHelper.COLUMN_USER_NAME + "=?";
        String arg[] = new String[] { username };

        db.beginTransaction();

        try {
            ContentValues cv = new ContentValues();
            cv.put(dbHelper.COLUMN_USER_PASSWORD, password);

            int row = db.update(dbHelper.TABLE_USER, cv, selection, arg);

            if(row > 0) {
                // Success
            } else {
                // Failed
            }

            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }

        db.close();
    }

    public void delete(String username) {
        String selection = dbHelper.COLUMN_USER_NAME + "=?";
        String arg[] = new String[] { username };

        db = dbHelper.getWritableDatabase();
        db.delete(dbHelper.TABLE_USER, selection, arg);
        db.close();
    }
}
