package com.lyb.newwidgetsdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.lyb.newwidgetsdemo.R;

/**
 * Created by Administrator on 2017/3/15.
 */

public class MyRecyclerViewHolder extends RecyclerView.ViewHolder {
    private TextView mTextView;
    public MyRecyclerViewHolder(View itemView) {
        super(itemView);
        setTextView((TextView)itemView.findViewById(R.id.id_itemtext));
    }

    public TextView getTextView() {
        return mTextView;
    }

    public void setTextView(TextView textView) {
        mTextView = textView;
    }
}
