package com.jb.androidtutorial.ui.viewpager;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.jb.androidtutorial.R;

import com.jb.androidtutorial.viewpager.fragments.fragment2.Fragment2;
import com.jb.androidtutorial.viewpager.fragments.Fragment3;
import com.jb.androidtutorial.viewpager.fragments.Fragment4;
import com.jb.androidtutorial.viewpager.fragments.ViewPagerFragment;


import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends AppCompatActivity {

    private TabLayout tab;
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
        tab = (TabLayout) findViewById(R.id.tab);


        List<String> titles = new ArrayList<>();
        titles.add("Tab 1");
        titles.add("Tab 2");
        titles.add("Tab 3");
        titles.add("Tab 4");

        List<Fragment> fragmentList = new ArrayList();
        fragmentList.add(ViewPagerFragment.getInstance(R.drawable.test_a));
        fragmentList.add(Fragment2.getInstance());
        fragmentList.add(Fragment3.getInstance());
        fragmentList.add(Fragment4.getInstance());

        mAdapter = new ViewPagerAdapter(fragmentList, getSupportFragmentManager(), titles);

        mViewPager.setAdapter(mAdapter);
        tab.setupWithViewPager(mViewPager);

        for(int index=0; index < tab.getTabCount(); index++) {
            tab.getTabAt(index).setIcon(R.mipmap.ic_launcher_round);
        }
    }

}
