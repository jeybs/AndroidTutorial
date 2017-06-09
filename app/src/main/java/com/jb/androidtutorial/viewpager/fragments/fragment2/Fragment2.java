package com.jb.androidtutorial.viewpager.fragments.fragment2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jb.androidtutorial.R;

/**
 * Created by b on 6/3/17.
 */

public class Fragment2 extends Fragment {

    private TextView txtFragment2;

    /**
     * Provide instance of this fragment
     * @return
     */
    public static Fragment2 getInstance() {
        Fragment2 fragment = new Fragment2();

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_2, container, false);

        txtFragment2 = (TextView) view.findViewById(R.id.text_fragment_2);

        txtFragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtFragment2.setText("Hello World");
            }
        });

        return view;
    }

}
