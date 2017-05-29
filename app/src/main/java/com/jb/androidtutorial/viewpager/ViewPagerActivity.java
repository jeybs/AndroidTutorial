package com.jb.androidtutorial.viewpager;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.jb.androidtutorial.R;
import com.jb.androidtutorial.recyclerview.RecyclerViewActivity;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private ViewPagerAdapter mAdapter;

    /**
     * Provide intent to start this activity
     * @return
     */
    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, ViewPagerActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        mViewPager = (ViewPager) findViewById(R.id.view_pager);

        List<Integer> mPicturesList = new ArrayList<>();
        mPicturesList.add(R.drawable.test_a);
        mPicturesList.add(R.drawable.test_b);
        mPicturesList.add(R.drawable.test_d);
        mPicturesList.add(R.drawable.test_c);


        mAdapter = new ViewPagerAdapter(getSupportFragmentManager(), mPicturesList);

        mViewPager.setAdapter(mAdapter);
    }

}
