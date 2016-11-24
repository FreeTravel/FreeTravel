package com.ma.freetravel.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ma.freetravel.R;
import com.ma.freetravel.bean.PlaceBean;
import com.squareup.picasso.Picasso;

/**
 * Created by 哈士奇爱吃苹果 on 2016/11/22.
 */
public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.MyHolder> {

    private Context context;
    private PlaceBean list;


    public CountryAdapter(Context context, PlaceBean list) {
        this.context = context;
        this.list = list;
    }

    //声明全局的回调接口  用于接收MainActivity传递过来的实例化接口对象
    private OnItemClickCallBack  onItemClickCallBack;
    //这方法 给MainActivity调用  传实例化接口对象
    public void setOnItemClickCallBack(OnItemClickCallBack  onItemClickCallBack){
        this.onItemClickCallBack = onItemClickCallBack;
    }

    /**
     * 自定义回调接口  用于点击事件
     */
    public interface  OnItemClickCallBack{
        void OnItemClickLister(View view ,int pos);
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.place_item,parent,false);
        final MyHolder myHolder=new MyHolder(view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onItemClickCallBack!=null){
                    //myViewHolder.getAdapterPosition()获取位置
                    onItemClickCallBack.OnItemClickLister(v,myHolder.getAdapterPosition());
                }
            }
        });
        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

        holder.name_cn.setText(list.getData().get(position).getPlace_name());
        holder.name_en.setText(list.getData().get(position).getPlace_name_en());
        String path=list.getData().get(position).getCover_image();

        if (path != null&&path.length()>0) {
            Picasso.with(context).load(path).into(holder.iv);

        }


    }

    @Override
    public int getItemCount() {
        return list!=null?list.getData().size():0;
    }

    class MyHolder extends RecyclerView.ViewHolder{

        private ImageView iv;
        private TextView name_cn,name_en;
        public MyHolder(View itemView) {
            super(itemView);
            iv= (ImageView) itemView.findViewById(R.id.iv_place_item);
            name_cn= (TextView) itemView.findViewById(R.id.tvcn_place_item);
            name_en= (TextView) itemView.findViewById(R.id.tven_place_item);
        }
    }
}
