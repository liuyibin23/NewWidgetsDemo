package com.lyb.newwidgetsdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.lyb.newwidgetsdemo.R;
import com.lyb.newwidgetsdemo.model.ZhihuDailyNews;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/25.
 * 知乎日报消息适配器
 * latest posts adapter
 */

public class ZhihuDailyNewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Context mContext;
    private List<ZhihuDailyNews.Question> mStories;
    public LayoutInflater mLayoutInflater;

    public ZhihuDailyNewsAdapter(Context context, ArrayList<ZhihuDailyNews.Question> stories){
        mContext = context;
        mStories = stories;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new NormalViewHolder(mLayoutInflater.inflate(R.layout.list_item_image_text,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof NormalViewHolder) {
            ZhihuDailyNews.Question item = mStories.get(position);
            if(item.getImages().size() == 0){
                ((NormalViewHolder) holder).itemImg.setImageResource(R.drawable.placeholder);
            }else{
                Glide.with(mContext)
                        .load(item.getImages())
                        .asBitmap()
                        .placeholder(R.drawable.placeholder)
                        .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                        .error(R.drawable.placeholder)
                        .centerCrop()
                        .into(((NormalViewHolder) holder).itemImg);
            }
            ((NormalViewHolder)holder).tvLatestNewsTitle.setText(item.getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return mStories.size();
    }

    public class NormalViewHolder extends RecyclerView.ViewHolder{

        private ImageView itemImg;
        private TextView tvLatestNewsTitle;

        public NormalViewHolder(View itemView) {
            super(itemView);
            itemImg = (ImageView)itemView.findViewById(R.id.list_item_imageview);
            tvLatestNewsTitle = (TextView)itemView.findViewById(R.id.list_item_textview);
        }
    }

}
