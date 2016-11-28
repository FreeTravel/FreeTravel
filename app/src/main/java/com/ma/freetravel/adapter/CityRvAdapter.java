package com.ma.freetravel.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ma.freetravel.R;
import com.ma.freetravel.bean.CityBeans;
import com.ma.freetravel.widget.MyGridView;
import com.ma.freetravel.widget.MyListView;

import java.util.List;

/**
 * Created by 哈士奇爱吃苹果 on 2016/11/25.
 */
public class CityRvAdapter extends RecyclerView.Adapter<CityRvAdapter.MyViewHolder>{


    private CityBeans cityBeans;
    private Context context;
    private List<Integer> list;

    public CityRvAdapter(CityBeans cityBeans, Context context, List<Integer> list) {
        this.cityBeans = cityBeans;
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.query_item, parent, false);
        MyViewHolder viewHolder=null;
        viewHolder=new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        switch (list.get(position)) {
            case 2:
                holder.textView.setText("最新动态");
                CityItem1Adapter adadpter=new CityItem1Adapter(cityBeans.getData().getIndex_trends().getTrends_list(),context);
                holder.myListView.setAdapter(adadpter);
                break;
            case 1:
                holder.textView.setText("发现新奇");
                CityItem2Adapter adapter=new CityItem2Adapter(cityBeans.getData().getCms_list(),context);
                holder.myListView.setAdapter(adapter);
                break;
            case 0:
                holder.textView.setText("好好玩");
                CityItem3Adapter adapter1=new CityItem3Adapter(cityBeans.getData().getRecommend_pin_list().getEntertainment(),context);
                holder.gridview.setAdapter(adapter1);
        }
    }

    @Override
    public int getItemViewType(int position) {

        return list.get(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public static  class MyViewHolder extends RecyclerView.ViewHolder{
        private final MyGridView gridview;
        public MyListView myListView;
        private TextView textView;
        public MyViewHolder(View itemView) {
            super(itemView);
            myListView= (MyListView) itemView.findViewById(R.id.mylistview);
            textView=(TextView) (itemView.findViewById(R.id.tv_mylistview));
            gridview = ((MyGridView) itemView.findViewById(R.id.mygridView));

        }
    }

}
