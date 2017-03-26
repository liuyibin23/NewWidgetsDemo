package com.lyb.newwidgetsdemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.lyb.newwidgetsdemo.homepage.ContentFragment;
import com.lyb.newwidgetsdemo.homepage.ZhihuDailyFragment;
import com.lyb.newwidgetsdemo.homepage.ZhihuDailyPresenter;

/**
 * Created by Administrator on 2017/3/13.
 */
public class MyViewPagerAdapter extends FragmentStatePagerAdapter {

    private String[] mTitles;
    private ZhihuDailyFragment mZhihuDailyFragment;
    public MyViewPagerAdapter(FragmentManager fm, String[] titles,ZhihuDailyFragment zhihuDailyFragment) {
        super(fm);
        mTitles = titles;
        mZhihuDailyFragment = zhihuDailyFragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0) {
            return mZhihuDailyFragment;
        }
        else {
            return ContentFragment.newInstance(mTitles[position]);
        }
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }
}
