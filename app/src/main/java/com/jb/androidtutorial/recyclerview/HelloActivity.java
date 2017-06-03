package com.jb.androidtutorial.recyclerview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jb.androidtutorial.R;
import com.jb.androidtutorial.utils.SharedPrefsUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jb on 03/06/2017.
 */

public class HelloActivity extends AppCompatActivity {

    private Activity activity;
    private SharedPrefsUtils sharedPrefsUtils;
    private Button buttonSelect;
    private TextView textView;

    /**
     * Provide intent to start this activity
     * @return
     */
    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, HelloActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);

        activity = this;

        buttonSelect = (Button) findViewById(R.id.button_select_user);
        textView = (TextView) findViewById(R.id.text_view);

        sharedPrefsUtils = new SharedPrefsUtils(activity);

        buttonSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.startActivity(RecyclerViewActivity.getStartIntent(activity));
            }
        });
    }


    @Override
    public void onResume() {
        super.onResume();

        String user = sharedPrefsUtils.getClickData();

        if(!TextUtils.isEmpty(user)) {
            String hello = activity.getString(R.string.text_welcome, user);
            textView.setText(hello);
        }

    }
}
