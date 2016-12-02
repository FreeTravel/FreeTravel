package com.ma.freetravel.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ma.freetravel.R;
import com.ma.freetravel.bean.MovieAlbum;
import com.ma.freetravel.url.Url;
import com.ma.freetravel.utils.FlagData;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by tian on 2016/11/28.
 */

public class AlbumLVAdapter<T> extends BaseListViewAdapter {
    private Context context;
    private List<T> objects;
    private String type;

    public AlbumLVAdapter(List<T> data, Context context,String type) {
        super(data, context);
        this.objects=data;
        this.context=context;
        this.type=type;
    }


    @Override
    public View getItemView(int position, View convertView, ViewGroup parent) {
        MyViewHolder holder=null;
        if (convertView == null) {
            convertView=getInflater().inflate(R.layout.item_lv_album,parent,false);
            holder=new MyViewHolder();
            holder.imageView= ((ImageView) convertView.findViewById(R.id.iv_item_album));
            holder.textView= ((TextView) convertView.findViewById(R.id.title_item_album));
            convertView.setTag(holder);
        }else {
            holder= ((MyViewHolder) convertView.getTag());
        }
        //填充数据
        if (type.equals(FlagData.FLAG_MOVIEALBUM)){
            MovieAlbum movieAlbum = ((MovieAlbum) objects.get(position));
            holder.textView.setText(movieAlbum.getTitle());
            String thePhoto = movieAlbum.getThePhoto();
            boolean b = thePhoto.startsWith("/ueditor");
            if (b){
                Picasso.with(context).load(Url.Head3+movieAlbum.getThePhoto()).into(holder.imageView);
            }else {
                Picasso.with(context).load(Url.Head_VpPath+movieAlbum.getThePhoto()).into(holder.imageView);
            }
        }

        return convertView;
    }

   class MyViewHolder {
       ImageView imageView;
       TextView textView;
   }
}
