package com.lyb.newwidgetsdemo;

import android.view.View;

/**
 * Created by Administrator on 2017/3/25.
 */

public interface BaseView<T> {
    /**
    * set the presenter of mvp
    * @param presenter
    */
    void setPresenter(T presenter);
    /**
     * init the views of fragment
     * @param view
     */
    void initViews(View view);
}
