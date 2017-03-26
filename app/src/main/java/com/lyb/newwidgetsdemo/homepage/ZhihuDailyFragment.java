package com.lyb.newwidgetsdemo.homepage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lyb.newwidgetsdemo.R;
import com.lyb.newwidgetsdemo.adapter.DividerItemDecoration;
import com.lyb.newwidgetsdemo.adapter.SpacesItemDecoration;
import com.lyb.newwidgetsdemo.adapter.ZhihuDailyNewsAdapter;
import com.lyb.newwidgetsdemo.model.ZhihuDailyNews;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/3/25.
 */

public class ZhihuDailyFragment extends Fragment implements ZhihuDailyContract.View {

    ZhihuDailyContract.Presenter mPresenter;
    RecyclerView mRecyclerView;
    ZhihuDailyNewsAdapter mRecyclerAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list,container,false);
        initViews(view);
        mPresenter.start();
        return view;
    }

    public static ZhihuDailyFragment newInstance() {
        return new ZhihuDailyFragment();
    }

    @Override
    public void setPresenter(ZhihuDailyContract.Presenter presenter) {
            mPresenter = presenter;
    }

    @Override
    public void initViews(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.fragmentlist_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL_LIST));
    }

    @Override
    public void showError() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void showResults(ArrayList<ZhihuDailyNews.Question> stories) {
        if (mRecyclerAdapter == null){
            mRecyclerAdapter = new ZhihuDailyNewsAdapter(getActivity(),stories);
            mRecyclerView.setAdapter(mRecyclerAdapter);
        }
        else{
            mRecyclerAdapter.notifyDataSetChanged();
        }
    }
}
