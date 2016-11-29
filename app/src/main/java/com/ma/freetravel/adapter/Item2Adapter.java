package com.ma.freetravel.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ma.freetravel.R;
import com.ma.freetravel.bean.QueryBean;
import com.ma.freetravel.ui.WebViewActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by 哈士奇爱吃苹果 on 2016/11/25.
 */
public class Item2Adapter extends BaseAdapter {

    List<QueryBean.ProductListBean> data;
    Context context;

    public Item2Adapter(List<QueryBean.ProductListBean> data, Context context) {
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
        MyViewHolder2 holder2 = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.query_item2, parent, false);
            holder2 = new MyViewHolder2();
            holder2.i_view = (ImageView) convertView.findViewById(R.id.iv_query_item2);
            holder2.titles = (TextView) convertView.findViewById(R.id.title_query_item2);
            holder2.price = (TextView) convertView.findViewById(R.id.price_query_item2);
            holder2.linearLayout= (LinearLayout) convertView.findViewById(R.id.linearLayout);
            convertView.setTag(holder2);
        }else {
            holder2 = (MyViewHolder2) convertView.getTag();
        }
        final QueryBean.ProductListBean productListBean = data.get(position);
        Picasso.with(parent.getContext()).load(productListBean.getCoverImage()).into(holder2.i_view);
        holder2.titles.setText(productListBean.getTitle());
        holder2.price.setText(productListBean.getLprice());
        holder2.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("qqqq","点击");
                Intent intent=new Intent(context, WebViewActivity.class);
                intent.putExtra("path",productListBean.getAppUrl());
                context.startActivity(intent);
            }
        });
        return convertView;
    }


    class MyViewHolder2 {
        public ImageView i_view;
        public TextView titles, price;
        public LinearLayout linearLayout;
    }

}
