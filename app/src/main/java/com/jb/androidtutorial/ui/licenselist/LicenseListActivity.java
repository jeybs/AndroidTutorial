package com.jb.androidtutorial.ui.licenselist;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jb.androidtutorial.R;
import com.jb.androidtutorial.data.source.remote.LicenseDataHelper;
import com.jb.androidtutorial.dialogs.CustomDialog;

import butterknife.ButterKnife;

public class LicenseListActivity extends AppCompatActivity {

    private Activity activity;
    private CustomDialog customDialog;
    private LicenseDataHelper licenseDataHelper;

    /**
     * Provide intent to start this activity
     * @return
     */
    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, LicenseListActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_license_list);
        ButterKnife.bind(this);

        activity = this;

        customDialog = new CustomDialog(activity);
        licenseDataHelper = new LicenseDataHelper(activity);
        licenseDataHelper.getLicenseKey();
    }

}
