package com.jb.androidtutorial;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.jb.androidtutorial.recyclerview.HelloActivity;
import com.jb.androidtutorial.recyclerview.RecyclerViewActivity;
import com.jb.androidtutorial.utils.NetworkUtils;
import com.jb.androidtutorial.viewpager.ViewPagerActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnRecycler;
    private Button btnViewPager;
    private Button btnAsync;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRecycler = (Button) findViewById(R.id.button_recycler);
        btnViewPager = (Button) findViewById(R.id.button_view_pager);

        btnRecycler.setOnClickListener(this);
        btnViewPager.setOnClickListener(this);
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

            default: break;
        }
    }
}
