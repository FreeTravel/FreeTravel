package com.ma.freetravel.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ma.freetravel.R;
import com.ma.freetravel.ui.MusicPlayAcitvity;

/**
 * Created by tian on 2016/12/1.
 */

public class MusicLvAdapter extends BaseAdapter {
private Context context;
    private String[][] data;

    public MusicLvAdapter(Context context, String[][] data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data!=null?data.length:0;
    }

    @Override
    public Object getItem(int position) {
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if (convertView == null) {
            convertView= LayoutInflater.from(context).inflate(R.layout.item_lv_moviemusic,parent,false);
            holder=new ViewHolder();
            holder.textView= ((TextView) convertView.findViewById(R.id.musicName_item_moviemusic));
            holder.imageView= ((ImageView) convertView.findViewById(R.id.icon_music));
            convertView.setTag(holder);
        }else {
            holder= ((ViewHolder) convertView.getTag());
        }
        final String[] strings = data[position];
        holder.textView.setText(strings[0]);
        holder.imageView.setImageResource(R.mipmap.music_listen);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,MusicPlayAcitvity.class);
                intent.putExtra("musicPath",strings[1]);
                context.startActivity(intent);
            }
        });
        return convertView;
    }
    class ViewHolder{
        TextView textView;
        ImageView imageView;
    }
}
