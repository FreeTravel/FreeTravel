package com.ma.freetravel.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ma.freetravel.R;
import com.ma.freetravel.bean.QueryBean;
import com.ma.freetravel.widget.MyListView;

import java.util.List;

/**
 * Created by 哈士奇爱吃苹果 on 2016/11/24.
 */
public class QueryAdapter extends RecyclerView.Adapter<QueryAdapter.MyViewHolder>{
    private QueryBean queryBean;
    private Context context;
    private List<Integer> list;


    public QueryAdapter(QueryBean queryBean, Context context, List<Integer> list) {
        this.queryBean = queryBean;
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

        switch (list.get(position)){
            case 0:
                holder.textView.setText("动态");
                Item1Adapter adadpter=  new Item1Adapter(queryBean.getTrendList(),context);
                holder.myListView.setAdapter(adadpter);
                break;
            case 1:
                holder.textView.setText("商品");
                holder.myListView.setAdapter(new Item2Adapter(queryBean.getProductList(),context));
                break;
            case 2:
                holder.textView.setText("目的地");
                holder.myListView.setAdapter(new Item3Adapter(queryBean.getPoiList(),context));
                break;
            case 3:
                holder.textView.setText("用户");
            holder.myListView.setAdapter(new Item4Adapter(queryBean.getUserList(),context));
                break;

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
        public MyListView myListView;
      private TextView textView;
        public MyViewHolder(View itemView) {
            super(itemView);
            myListView= (MyListView) itemView.findViewById(R.id.mylistview);
            textView=(TextView) (itemView.findViewById(R.id.tv_mylistview));
        }
    }

}
