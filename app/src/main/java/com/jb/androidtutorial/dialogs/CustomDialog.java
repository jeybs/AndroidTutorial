package com.jb.androidtutorial.dialogs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.jb.androidtutorial.R;

/**
 * Created by jb on 10/06/2017.
 */

public class CustomDialog {

    private Context mContext;

    public CustomDialog(Context context) {
        mContext = context;
    }

    /**
     * Provide basic dialog
     * @param title
     * @param message
     */
    public void showBasicDialog(String title, String message) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(mContext, R.style.AppCompatAlertDialogStyle);
        builder.setTitle(title);
        builder.setCancelable(false);
        builder.setMessage(message);

        builder.setPositiveButton(mContext.getString(R.string.ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.show();
    }

    public void showBasicDialog2(String title, String message, final DIalogClickCallback callback) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(mContext, R.style.AppCompatAlertDialogStyle);
        builder.setTitle(title);
        builder.setCancelable(false);
        builder.setMessage(message);

        builder.setPositiveButton(mContext.getString(R.string.ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                callback.onDialogOkClick();
            }
        });

        builder.show();
    }

}
