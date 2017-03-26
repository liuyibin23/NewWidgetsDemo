package com.lyb.newwidgetsdemo.homepage;

import android.content.Context;
import android.icu.util.Calendar;
import android.provider.Settings;

/**
 * Created by Administrator on 2017/3/25.
 */

public class ZhihuDailyPresenter implements ZhihuDailyContract.Presenter {

    private ZhihuDailyContract.View mView;
    private Context mContext;

    public ZhihuDailyPresenter(Context context,ZhihuDailyContract.View view)
    {
        mContext = context;
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void start() {
        loadPosts(System.currentTimeMillis(),true);
    }

    @Override
    public void loadPosts(long date, boolean clearing) {

    }

    @Override
    public void refresh() {

    }

    @Override
    public void loadMore(long date) {

    }

    @Override
    public void startReading(int position) {

    }

    @Override
    public void feelLucky() {

    }
}
