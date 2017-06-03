package com.jb.androidtutorial.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SharedPrefsUtils {

    private static final String SHARED_PREFS_NAME = "data";

    private static final String KEY_CLICK_DATA = "click_data";

    private SharedPreferences mSharedPrefsUtils;
    private Editor mEditor;

    public SharedPrefsUtils(Context context) {
        mSharedPrefsUtils = context.getSharedPreferences(SHARED_PREFS_NAME, context.MODE_PRIVATE);
        mEditor = mSharedPrefsUtils.edit();
    }

    public void saveClickData(String data) {
        mEditor.putString(KEY_CLICK_DATA, data).commit();
    }

    public String getClickData() {
        return mSharedPrefsUtils.getString(KEY_CLICK_DATA, "");
    }
}
