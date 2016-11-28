package com.ma.freetravel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ma.freetravel.R;
import com.ma.freetravel.bean.CityBeans;
import com.ma.freetravel.widget.CircleImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by 哈士奇爱吃苹果 on 2016/11/25.
 */
public class CityItem1Adapter extends BaseAdapter {
    private List<CityBeans.DataBean.IndexTrendsBean.TrendsListBean> data;
    private Context context;

    public CityItem1Adapter(List<CityBeans.DataBean.IndexTrendsBean.TrendsListBean> data, Context context) {
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
        Viewholder viewholder=null;
        if (viewholder==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.dynamic_lv_item,parent,false);
            viewholder=new Viewholder();
            viewholder.author= (TextView) convertView.findViewById(R.id.user_tv_dynamic_item);
            viewholder.num= (TextView) convertView.findViewById(R.id.num_dynamic_item);
            viewholder.countrll= (TextView) convertView.findViewById(R.id.controll_dynamic_item);
            viewholder.time= (TextView) convertView.findViewById(R.id.time_dynamic_item);
            viewholder.imageView= (CircleImageView) convertView.findViewById(R.id.iv_dynamic_item);
            convertView.setTag(viewholder);
        }else {
            viewholder= (Viewholder) convertView.getTag();
        }
        CityBeans.DataBean.IndexTrendsBean.TrendsListBean trendsListBean = data.get(position);
        viewholder.num.setText(trendsListBean.getImage_count());
        viewholder.countrll.setText(trendsListBean.getContent());
        viewholder.author.setText(trendsListBean.getAuthor().getUser_name());
        viewholder.time.setText(trendsListBean.getHuman_ctime());
        Picasso.with(context).load(trendsListBean.getAuthor().getAvatar()).into(viewholder.imageView);
        return convertView;
    }

    class Viewholder {
        TextView author,num,countrll,time;
        CircleImageView imageView;
    }
}
