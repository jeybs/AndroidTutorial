package com.jb.androidtutorial.viewpager.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jb.androidtutorial.R;
import com.jb.androidtutorial.recyclerview.RecyclerViewActivity;

public class ViewPagerFragment extends Fragment {

    private ImageView imageSlider;
    private int image;

    private static final String KEY_SLIDER = "slider";

    /**
     * Provide instance of this fragment
     * @param image
     * @return
     */
    public static ViewPagerFragment getInstance(int image) {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_SLIDER, image);

        ViewPagerFragment fragment = new ViewPagerFragment();
        fragment.setArguments(bundle);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_image, container, false);

        image = getArguments().getInt(KEY_SLIDER, 0);

        imageSlider = (ImageView) view.findViewById(R.id.image_slider);
        imageSlider.setImageResource(image);


        imageSlider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(RecyclerViewActivity.getStartIntent(getActivity()));
            }
        });

        return view;
    }
}
