package com.jb.androidtutorial.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jb.androidtutorial.R;
import com.jb.androidtutorial.ui.licenselist.LicenseListActivity;
import com.jb.androidtutorial.ui.recyclerview.HelloActivity;
import com.jb.androidtutorial.ui.signup.Authentication;
import com.jb.androidtutorial.ui.viewpager.ViewPagerActivity;

import com.jb.androidtutorial.utils.NetworkUtils;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnRecycler;
    private Button btnViewPager;
    private Button btnSignUp;
    private Button btnLicenseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRecycler = (Button) findViewById(R.id.button_recycler);
        btnViewPager = (Button) findViewById(R.id.button_view_pager);
        btnSignUp = (Button) findViewById(R.id.button_signup);
        btnLicenseList = (Button) findViewById(R.id.button_license_list);

        btnRecycler.setOnClickListener(this);
        btnViewPager.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);
        btnLicenseList.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_recycler:
                boolean isConnected = NetworkUtils.isNetworkConnected(this);

                if(isConnected) {
                    startActivity(HelloActivity.getStartIntent(this));
                } else {
                    Toast.makeText(this, "No Internet", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.button_view_pager:
                startActivity(ViewPagerActivity.getStartIntent(this));
                break;
            case R.id.button_signup:
                startActivity(Authentication.getStartIntent(this));
                break;
            case R.id.button_license_list:
                startActivity(LicenseListActivity.getStartIntent(this));
                break;
            default: break;
        }
    }
}
