package com.lyb.newwidgetsdemo.homepage;

import com.lyb.newwidgetsdemo.BasePresenter;
import com.lyb.newwidgetsdemo.BaseView;
import com.lyb.newwidgetsdemo.model.ZhihuDailyNews;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/3/25.
 */

public class ZhihuDailyContract {

    interface View extends BaseView<Presenter>{

        void showError();

        void showLoading();

        void stopLoading();

        void showResults(ArrayList<ZhihuDailyNews.Question> stories);

    }

    interface Presenter extends BasePresenter{

        void loadPosts(long date,boolean clearing);

        void refresh();

        void loadMore(long date);

        void startReading(int position);

        void feelLucky();
    }
}
