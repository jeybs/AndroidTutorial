package com.jb.androidtutorial.recyclerview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.jb.androidtutorial.R;

import java.util.ArrayList;
import java.util.List;


public class RecyclerViewActivity extends AppCompatActivity implements RecyclerListCallback {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutmanager;
    private Activity activity;

    /**
     * Provide intent to start this activity
     * @return
     */
    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, RecyclerViewActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        activity = this;

        recyclerView = (RecyclerView) findViewById(R.id.recycler_list);

        List<String> nameList = new ArrayList<>();
        nameList.add("John Brad");
        nameList.add("Jeniffer Law");
        nameList.add("Michael V.");
        nameList.add("Chris Anthony");
        nameList.add("Popoy Basha");
        nameList.add("John Hener");
        nameList.add("Test Sample");
        nameList.add("John Brad");
        nameList.add("Jeniffer Law");
        nameList.add("Michael V.");
        nameList.add("Chris Anthony");
        nameList.add("Popoy Basha");
        nameList.add("John Hener");
        nameList.add("Test Sample");
        nameList.add("John Brad");
        nameList.add("Jeniffer Law");
        nameList.add("Michael V.");
        nameList.add("Chris Anthony");
        nameList.add("Popoy Basha");
        nameList.add("John Hener");
        nameList.add("Test Sample");

        mAdapter = new RecyclerViewAdapter(getApplicationContext(), nameList, this);
        mLayoutmanager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(mLayoutmanager);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onItemClick(String name) {
        Toast.makeText(
                this,
                activity.getString(R.string.text_welcome, name),
                Toast.LENGTH_SHORT).show();
    }
}
