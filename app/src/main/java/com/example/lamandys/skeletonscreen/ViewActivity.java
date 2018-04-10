package com.example.lamandys.skeletonscreen;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.ViewSkeletonScreen;

/**
 * 作者：子川
 * 时间：2018/4/10 下午5:00
 * 邮箱：lantianhua@linghit.com
 * 说明：单纯的显示view的activity
 */
public class ViewActivity extends AppCompatActivity {

    private ViewSkeletonScreen skeletonScreen;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rv_item);
        TextView textView = findViewById(R.id.item_text);
        textView.setText("单独的view");
        init();
    }

    private void init() {
        View rootView = findViewById(R.id.item_root);
        skeletonScreen = Skeleton.bind(rootView)
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
