package com.example.lamandys.skeletonscreen;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.ethanhua.skeleton.RecyclerViewSkeletonScreen;
import com.ethanhua.skeleton.Skeleton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<String> titles;

    private RecyclerViewSkeletonScreen skeletonScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.rv_skeleton);
        initSource();
        init();
    }

    private void initSource() {
        titles = new ArrayList<>();
        titles.add("1");
        titles.add("2");
        titles.add("3");
        titles.add("4");
        titles.add("5");
        titles.add("6");
        titles.add("7");
        titles.add("8");
        titles.add("9");
        titles.add("10");
        titles.add("11");
        titles.add("12");
        titles.add("13");
        titles.add("14");
        titles.add("15");
        titles.add("16");
        titles.add("17");
    }

    private void init() {
        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
        manager.setOrientation(LinearLayout.VERTICAL);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setHasFixedSize(true);
        MyAdapter adapter = new MyAdapter(titles);
        adapter.setOnClickItem(new MyAdapter.IOnClickItem() {
            @Override
            public void onClick() {
                startActivity(new Intent(MainActivity.this,ViewActivity.class));
            }
        });
        mRecyclerView.setAdapter(adapter);
        skeletonScreen = Skeleton.bind(mRecyclerView)
                .adapter(adapter)
                .load(R.layout.rv_item_skeleton)
                .show();
        new Handler(getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                skeletonScreen.hide();
            }
        },5000);
    }
}
