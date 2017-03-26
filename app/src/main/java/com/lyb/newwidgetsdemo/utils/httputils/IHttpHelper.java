package com.lyb.newwidgetsdemo.utils.httputils;

/**
 * Created by Administrator on 2017/3/26.
 */

public interface IHttpHelper {
    void Get(String url, OnHttpResponseListener listener);
}
