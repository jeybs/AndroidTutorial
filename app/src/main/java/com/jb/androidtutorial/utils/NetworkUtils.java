package com.jb.androidtutorial.utils;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by b on 6/3/17.
 */

public class NetworkUtils {

    /**
     * Validate if connected to network
     * @param context
     * @return
     */
    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager)
                context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }

}
