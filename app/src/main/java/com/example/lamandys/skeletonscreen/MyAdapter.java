package com.example.lamandys.skeletonscreen;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ethanhua.skeleton.SkeletonAdapter;

import java.util.List;

/**
 * 作者：子川
 * 时间：2018/4/10 下午4:17
 * 邮箱：lantianhua@linghit.com
 * 说明：适配器
 */
public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<String> titles;

    public MyAdapter(List<String> titles) {
        this.titles = titles;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new MyHolder(inflater.inflate(R.layout.rv_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
        ((MyHolder) holder).text.setText(titles.get(holder.getAdapterPosition()));
        ((MyHolder) holder).itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickItem != null) {
                    onClickItem.onClick();
                }
            }
        });
    }

    private IOnClickItem onClickItem;

    public void setOnClickItem(IOnClickItem onClickItem) {
        this.onClickItem = onClickItem;
    }

    public interface IOnClickItem {
        void onClick();
    }

    @Override
    public int getItemCount() {
        return titles == null ? 0 : titles.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder {

        private TextView text;

        public MyHolder(View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.item_text);
        }
    }
}
