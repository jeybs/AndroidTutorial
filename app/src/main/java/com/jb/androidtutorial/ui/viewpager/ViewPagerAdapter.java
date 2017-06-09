package com.jb.androidtutorial.ui.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.jb.androidtutorial.viewpager.fragments.ViewPagerFragment;

import java.util.List;

/**
 * Created by 81014102 on 29/05/2017.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> mFragmentList;
    private List<String> mTitles;

    public ViewPagerAdapter(List<Fragment> fragmentList, FragmentManager fm, List<String> titles) {
        super(fm);

        mFragmentList = fragmentList;
        mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position).toUpperCase();
    }
}
