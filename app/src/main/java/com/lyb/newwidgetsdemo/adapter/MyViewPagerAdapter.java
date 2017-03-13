package com.lyb.newwidgetsdemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.lyb.newwidgetsdemo.ContentFragment;

import java.util.List;

/**
 * Created by Administrator on 2017/3/13.
 */
public class MyViewPagerAdapter extends FragmentStatePagerAdapter {

    private String[] mTitles;
    public MyViewPagerAdapter(FragmentManager fm, String[] titles) {
        super(fm);
        mTitles = titles;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

    @Override
    public Fragment getItem(int position) {
        return ContentFragment.newInstance(mTitles[position]);
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }
}
