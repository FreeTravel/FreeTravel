package com.ma.freetravel.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ma.freetravel.R;
import com.ma.freetravel.bean.Dynamic;
import com.ma.freetravel.widget.CircleImageView;

import java.util.List;

/**
 * @author :ZJF
 * @version : 2016-11-22 下午 4:34
 */

public class DynamicAdapter extends BaseListViewAdapter<Dynamic.DataBean.TrendsListBean> {


    public DynamicAdapter(List<Dynamic.DataBean.TrendsListBean> data, Context context) {
        super(data, context);
    }

    @Override
    public View getItemView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = getInflater().inflate(R.layout.dynamicfra_layout_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Dynamic.DataBean.TrendsListBean bean = getItem(position);
        holder.txt_name.setText(bean.getAuthor().getUser_name());
        holder.txt_time.setText(bean.getHuman_ctime());
        holder.txt_content.setText(bean.getContent());
        holder.txt_favorite.setText(" " + bean.getFav_count());

        return convertView;
    }

    static class ViewHolder {
        CircleImageView headView;
        TextView txt_name, txt_time, txt_content, txt_favorite;

        public ViewHolder(View convertView) {
            headView = (CircleImageView) convertView.findViewById(R.id.item_img_headicon);
            txt_name = (TextView) convertView.findViewById(R.id.item_txt_name);
            txt_time = (TextView) convertView.findViewById(R.id.item_txt_time);
            txt_content = (TextView) convertView.findViewById(R.id.item_txt_content);
            txt_favorite = (TextView) convertView.findViewById(R.id.item_txt_favorite);
        }
    }
}
