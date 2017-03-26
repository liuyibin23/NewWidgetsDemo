package com.lyb.newwidgetsdemo.homepage;

import android.content.Context;
import android.net.Uri;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lyb.newwidgetsdemo.R;
import com.lyb.newwidgetsdemo.adapter.MyViewPagerAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity
    implements ViewPager.OnPageChangeListener{

    private ZhihuDailyPresenter mZhihuDailyPresenter;
    private ZhihuDailyFragment mZhihuDailyFragment;

    private DrawerLayout mDrawerLayout;
    private CoordinatorLayout mCoordinatorLayout;
    private AppBarLayout mAppBarLayout;
    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private FloatingActionButton mFloatingActionButton;

    //TabLayout中的tab标题
    private String[] mTitles;
    private List<Fragment> mFragments;
    // ViewPager的数据适配器
    private MyViewPagerAdapter mViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mZhihuDailyFragment = ZhihuDailyFragment.newInstance();
        mZhihuDailyPresenter = new ZhihuDailyPresenter(this,mZhihuDailyFragment);

        initView();
        initData();
        configViews();
    }

    private void initView() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.id_drawerlayout);
        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.id_coordinatorlayout);
        mAppBarLayout = (AppBarLayout) findViewById(R.id.id_appbarlayout);
        mToolbar = (Toolbar) findViewById(R.id.id_toolbar);
        mTabLayout = (TabLayout) findViewById(R.id.id_tablayout);
        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
        mFloatingActionButton = (FloatingActionButton) findViewById(R.id.id_floatingactionbutton);
    }

    private void configViews() {

        mViewPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager(),mTitles,mZhihuDailyFragment);
        mViewPager.setAdapter(mViewPagerAdapter);
        // 设置ViewPager最大缓存的页面个数
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setOnPageChangeListener(this);

        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        for (String item : mTitles) {
            mTabLayout.addTab(mTabLayout.newTab().setText(item));
        }
        // 将TabLayout和ViewPager进行关联，让两者联动起来
        mTabLayout.setupWithViewPager(mViewPager);
//

    }

    private void initData() {
        mTitles = getResources().getStringArray(R.array.tab_titles);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        mToolbar.setTitle(mTitles[position]);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
