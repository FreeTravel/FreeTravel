package com.ma.freetravel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ma.freetravel.R;
import com.ma.freetravel.bean.QueryBean;
import com.ma.freetravel.widget.CircleImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by 哈士奇爱吃苹果 on 2016/11/24.
 */
public class Item1Adapter extends BaseAdapter {
    List<QueryBean.TrendListBean> data;
    Context context;

    public Item1Adapter(List<QueryBean.TrendListBean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data!=null?data.size():0;
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
                MyViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.dynamic_lv_item, parent, false);
            holder = new MyViewHolder();
            holder.imageView = (CircleImageView) convertView.findViewById(R.id.iv_dynamic_item);
            holder.author = (TextView) convertView.findViewById(R.id.user_tv_dynamic_item);
            holder.kinds = (TextView) convertView.findViewById(R.id.num_dynamic_item);
            holder.contrl = (TextView) convertView.findViewById(R.id.controll_dynamic_item);
            holder.time = (TextView) convertView.findViewById(R.id.time_dynamic_item);
            convertView.setTag(holder);
        } else {
            holder = (MyViewHolder) convertView.getTag();
        }
        QueryBean.TrendListBean trendListBean = data.get(position);
        Picasso.with(context).load(trendListBean.getUser_avatar()).into(holder.imageView);
        holder.author.setText(trendListBean.getUser_name());
//            holder.kinds.setText(queryBean.getTrendList().get(position).getTags().get(position).getTag_name());
        holder.contrl.setText(trendListBean.getContent());
        holder.time.setText(trendListBean.getPlace_name());
        return convertView;
    }


    class MyViewHolder {
        public CircleImageView imageView;
        public TextView author, kinds, contrl, time;
    }
}
