package com.jb.androidtutorial.ui.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by 81014102 on 29/05/2017.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<Integer> mImageList;

    public ViewPagerAdapter(FragmentManager fm, List<Integer> imageList) {
        super(fm);

        mImageList = imageList;
    }

    @Override
    public Fragment getItem(int position) {
        int image = mImageList.get(position);

        Bundle bundle = new Bundle();
        bundle.putInt("slider", image);

        ViewPagerFragment fragment = new ViewPagerFragment();
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public int getCount() {
        return mImageList.size();
    }
}
