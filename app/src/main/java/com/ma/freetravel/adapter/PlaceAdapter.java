package com.ma.freetravel.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ma.freetravel.R;
import com.ma.freetravel.bean.CountryBean;
import com.squareup.picasso.Picasso;

/**
 * Created by 哈士奇爱吃苹果 on 2016/11/22.
 */
public class PlaceAdapter extends BaseRecyclerAdapter<CountryBean.DataBean.CityListBean> {

    private Context context;

    public PlaceAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreate(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.place_item,parent,false);
        MyHolder myHolder=new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBind(RecyclerView.ViewHolder viewHolder, int RealPosition, CountryBean.DataBean.CityListBean data) {
        if (viewHolder instanceof MyHolder){
            MyHolder myHolder= (MyHolder) viewHolder;
            myHolder.name_cn.setText(data.getPlace_name());
            myHolder.name_en.setText(data.getPlace_name_en());
            Picasso.with(context).load(data.getCover_image()).into(myHolder.iv);
        }


    }

    class MyHolder extends RecyclerView.ViewHolder{

        public ImageView iv;
        public TextView name_cn,name_en;
        public MyHolder(View itemView) {
            super(itemView);
            iv= (ImageView) itemView.findViewById(R.id.iv_place_item);
            name_cn= (TextView) itemView.findViewById(R.id.tvcn_place_item);
            name_en= (TextView) itemView.findViewById(R.id.tven_place_item);
        }
    }
}
