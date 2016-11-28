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
public class CityItem2Adapter extends BaseAdapter {
    private List<CityBeans.DataBean.CmsListBean> data;
    private Context context;

    public CityItem2Adapter(List<CityBeans.DataBean.CmsListBean> data, Context context) {
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
        if (viewHolder==null){
            convertView=LayoutInflater.from(context).inflate(R.layout.city_foot_lv_item,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.tv_num= (TextView) convertView.findViewById(R.id.tv_num_item_city);
            viewHolder.tv_title= (TextView) convertView.findViewById(R.id.tv_title_item_foot);
            viewHolder.iv_pic= (ImageView) convertView.findViewById(R.id.iv_item_foot);
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        final CityBeans.DataBean.CmsListBean cmsListBean = data.get(position);
        viewHolder.tv_title.setText(cmsListBean.getTitle());
        viewHolder.tv_num.setText(cmsListBean.getLike_count());
        Picasso.with(context).load(cmsListBean.getCover_image()).into(viewHolder.iv_pic);


        return convertView;
    }

    class ViewHolder{
        TextView tv_title,tv_num;
        ImageView iv_pic;
    }
}
