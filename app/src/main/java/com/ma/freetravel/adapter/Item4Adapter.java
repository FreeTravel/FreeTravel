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
 * Created by 哈士奇爱吃苹果 on 2016/11/25.
 */
public class Item4Adapter extends BaseAdapter {
    List<QueryBean.UserListBean> data;
    Context context;

    public Item4Adapter(List<QueryBean.UserListBean> data, Context context) {
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
        MyViewHolder4 holder4=null;
        if (convertView==null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.query_item4, parent, false);
            holder4 = new MyViewHolder4();
            holder4.imageView2 = (CircleImageView) convertView.findViewById(R.id.ivs_query_item4);
            holder4.user = (TextView) convertView.findViewById(R.id.user_query_item4);
            holder4.ids = (TextView) convertView.findViewById(R.id.id_query_item4);
            convertView.setTag(holder4);
        }else {
            holder4= (MyViewHolder4) convertView.getTag();
        }
        QueryBean.UserListBean userListBean = data.get(position);
        Picasso.with(parent.getContext()).load(userListBean.getCoverImage()).into(holder4.imageView2);
        holder4.user.setText(userListBean.getTitle());
        holder4.user.setText(userListBean.getUser_id());
        return convertView;
    }


    class MyViewHolder4 {
        public CircleImageView imageView2;
        public TextView user, ids;
    }
}
