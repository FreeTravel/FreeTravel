package com.ma.freetravel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ma.freetravel.R;
import com.ma.freetravel.bean.CityBeans;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by 哈士奇爱吃苹果 on 2016/11/25.
 */
public class CityItem3Adapter extends BaseAdapter {
    private List<CityBeans.DataBean.RecommendPinListBean.EntertainmentBean> data;
    private Context context;

    public CityItem3Adapter(List<CityBeans.DataBean.RecommendPinListBean.EntertainmentBean> data, Context context) {
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
        ViewHolder viewHolder=null;
        if(convertView==null){
           convertView= LayoutInflater.from(context).inflate(R.layout.place_item,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.name_cn= (TextView) convertView.findViewById(R.id.tvcn_place_item);
            viewHolder.iv= (ImageView) convertView.findViewById(R.id.iv_place_item);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        CityBeans.DataBean.RecommendPinListBean.EntertainmentBean entertainmentBean = data.get(position);
        viewHolder.name_cn.setText(entertainmentBean.getTitle());
        Picasso.with(context).load(entertainmentBean.getCover_image()).into(viewHolder.iv);
        return convertView;
    }

    class ViewHolder{

        public ImageView iv;
        public TextView name_cn;

    }
}