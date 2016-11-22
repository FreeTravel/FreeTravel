package com.ma.freetravel.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ma.freetravel.R;
import com.ma.freetravel.bean.MovieLv;

/**
 * Created by Administrator on 2016/11/22.
 */

public class BannerRecyclerAdapter extends BaseRecyclerAdapter<MovieLv> {

    @Override
    public RecyclerView.ViewHolder onCreate(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBind(RecyclerView.ViewHolder viewHolder, int RealPosition, MovieLv data) {

    }

    class MyHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        private ImageView imageView;

        public MyHolder(View itemView) {
            super(itemView);
        }
    }
}
