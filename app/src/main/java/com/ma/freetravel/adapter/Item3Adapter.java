package com.ma.freetravel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ma.freetravel.R;
import com.ma.freetravel.bean.QueryBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by 哈士奇爱吃苹果 on 2016/11/25.
 */
public class Item3Adapter extends BaseAdapter {

    List<QueryBean.PoiListBean> data;
    Context context;

    public Item3Adapter(List<QueryBean.PoiListBean> data, Context context) {
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
        MyViewHolder3 holder3=null;
        if (convertView==null){
            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.query_item3,parent,false);
            holder3=new MyViewHolder3();
            holder3.image_view= (ImageView) convertView.findViewById(R.id.iv_query_item3);
            holder3.kin= (TextView) convertView.findViewById(R.id.kind_query_item3);
            holder3.place= (TextView) convertView.findViewById(R.id.place_query_item3);
            convertView.setTag(holder3);
        }else {
            holder3= (MyViewHolder3) convertView.getTag();
        }

        QueryBean.PoiListBean poiListBean = data.get(position);
        Picasso.with(parent.getContext()).load(poiListBean.getCoverImage()).into(holder3.image_view);
        holder3.kin.setText(poiListBean.getTitle());
        holder3.place.setText(poiListBean.getType());
        return convertView;
    }

    class MyViewHolder3{
        public ImageView image_view;
        public TextView kin,place;

    }
}
