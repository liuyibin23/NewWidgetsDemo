package com.lyb.newwidgetsdemo.homepage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lyb.newwidgetsdemo.R;
import com.lyb.newwidgetsdemo.adapter.MyRecyclerViewAdapter;

/**
 * Created by Administrator on 2017/3/13.
 */
public class ContentFragment extends Fragment {

    private static String ARG_TEXT = "ARG_TEXT";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content,container,false);
        TextView textView = (TextView) view.findViewById(R.id.id_text);
        Bundle arg = getArguments();
        textView.setText(arg.getString(ARG_TEXT,""));
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.id_recyclerview);
        recyclerView.setAdapter(new MyRecyclerViewAdapter(getActivity()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false));
        return view;
    }

    public static ContentFragment newInstance(String strArg){
        ContentFragment fragment = new ContentFragment();
        Bundle arg = new Bundle();
        arg.putString(ARG_TEXT,strArg);
        fragment.setArguments(arg);
        return  fragment;
    }

}
