package com.lyb.newwidgetsdemo.utils.httputils;

import android.content.Context;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.lyb.newwidgetsdemo.utils.VolleySingleton;

/**
 * Created by Administrator on 2017/3/26.
 */

public class VolleyHttpHelperImpl implements IHttpHelper {

    private Context mContext;

    public VolleyHttpHelperImpl(Context context){
        mContext =context;
    }

    @Override
    public void Get(String url, final OnHttpResponseListener listener) {
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                listener.onSuccess(s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                listener.onError(volleyError);
            }
        });

        request.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        VolleySingleton.getVolleySingleton(mContext).addToRequestQueue(request);
    }
}
