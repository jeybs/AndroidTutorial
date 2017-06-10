package com.jb.androidtutorial.ui.viewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jb.androidtutorial.R;

/**
 * Created by 81014102 on 29/05/2017.
 */

public class ViewPagerFragment extends Fragment {

    private ImageView imageSlider;
    private int image;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_image, container, false);

        image = getArguments().getInt("slider");

        imageSlider = (ImageView) view.findViewById(R.id.image_slider);
        imageSlider.setImageResource(image);

        return view;
    }
}
