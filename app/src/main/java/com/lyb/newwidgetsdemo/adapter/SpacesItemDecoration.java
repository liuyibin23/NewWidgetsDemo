package com.lyb.newwidgetsdemo.adapter;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Administrator on 2017/3/26.
 */

public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
    private int mSpace;

    public SpacesItemDecoration(int space){
        mSpace = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
//        outRect.left = mSpace;
//        outRect.right = mSpace;
        outRect.bottom = mSpace;

        // Add top margin only for the first item to avoid double space between items
        if(parent.getChildPosition(view) == 0)
            outRect.top = mSpace;
    }
}
