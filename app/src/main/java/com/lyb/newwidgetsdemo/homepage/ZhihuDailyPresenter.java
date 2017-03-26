package com.lyb.newwidgetsdemo.homepage;

import android.content.Context;
import android.icu.util.Calendar;
import android.provider.Settings;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.lyb.newwidgetsdemo.model.ZhihuDailyNews;
import com.lyb.newwidgetsdemo.utils.Api;
import com.lyb.newwidgetsdemo.utils.DateFormatter;
import com.lyb.newwidgetsdemo.utils.NetworkState;
import com.lyb.newwidgetsdemo.utils.httputils.IHttpHelper;
import com.lyb.newwidgetsdemo.utils.httputils.OnHttpResponseListener;
import com.lyb.newwidgetsdemo.utils.httputils.VolleyHttpHelperImpl;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/3/25.
 */

public class ZhihuDailyPresenter implements ZhihuDailyContract.Presenter {

    private ZhihuDailyContract.View mView;
    private Context mContext;
    private IHttpHelper mHttpHelper;
    private DateFormatter mDateFormatter = new DateFormatter();
    private Gson mGson = new Gson();
    private ArrayList<ZhihuDailyNews.Question> mStories = new ArrayList<>();

    public ZhihuDailyPresenter(Context context,ZhihuDailyContract.View view)
    {
        mContext = context;
        mView = view;
        mView.setPresenter(this);
        mHttpHelper = new VolleyHttpHelperImpl(context);
    }

    @Override
    public void start() {
        loadPosts(System.currentTimeMillis(),true);
    }

    @Override
    public void loadPosts(long date, final boolean clearing) {

        mView.showLoading();
        if(NetworkState.networkConnected(mContext)){
            mHttpHelper.Get(Api.ZHIHU_HISTORY + mDateFormatter.ZhihuDailyDateFormat(date), new OnHttpResponseListener() {
                @Override
                public void onSuccess(String result) {
                    try{
                        ZhihuDailyNews zhihuDailyNews = mGson.fromJson(result,ZhihuDailyNews.class);
                        if(clearing){
                            mStories.clear();
                        }

                        for(ZhihuDailyNews.Question item :zhihuDailyNews.getStories()){
                            mStories.add(item);
                        }
                        mView.showResults(mStories);
                    }
                    catch (JsonSyntaxException ex){
                        mView.showError();
                    }
                    mView.stopLoading();

                }

                @Override
                public <T> void onError(T error) {
                    mView.stopLoading();
                    mView.showError();
                }
            });
        }else {
            if(clearing){
                mStories.clear();
            }
            mView.stopLoading();
            mView.showError();
        }

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
