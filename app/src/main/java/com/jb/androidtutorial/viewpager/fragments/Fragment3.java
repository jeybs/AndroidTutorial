package com.jb.androidtutorial.viewpager.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jb.androidtutorial.R;

/**
 * Created by b on 6/3/17.
 */

public class Fragment3 extends Fragment {

    /**
     * Provide instance of this fragment
     * @return
     */
    public static Fragment3 getInstance() {
        Bundle bundle = new Bundle();

        Fragment3 fragment = new Fragment3();
        fragment.setArguments(bundle);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_3, container, false);


        return view;
    }

}
