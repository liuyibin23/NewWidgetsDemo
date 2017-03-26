package com.lyb.newwidgetsdemo.utils.httputils;

/**
 * Created by Administrator on 2017/3/26.
 */

public interface OnHttpResponseListener {

    /**
     * 请求成功时回调
     * @param result
     * */
    void onSuccess(String result);

    /**
     * 请求失败时回调
     * @param error
     * */
    <T> void onError(T error);
}
