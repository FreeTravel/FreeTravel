package com.ma.freetravel.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.ma.freetravel.R;
import com.ma.freetravel.bean.Dynamic;
import com.ma.freetravel.bean.Picture;
import com.ma.freetravel.ui.MapActivity;
import com.ma.freetravel.ui.ShowPictureActivity;
import com.ma.freetravel.widget.CircleImageView;
import com.ma.freetravel.widget.OnMeasureGridView;
import com.squareup.picasso.Picasso;

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
            holder.txt_local.setVisibility(View.VISIBLE);
        }
        final Dynamic.DataBean.TrendsListBean bean = getItem(position);
        holder.txt_name.setText(" " + bean.getAuthor().getUser_name());
        holder.txt_time.setText(" " + bean.getHuman_ctime());
        holder.txt_content.setText(bean.getContent());
        holder.txt_favorite.setText(" " + bean.getFav_count());
        if (TextUtils.isEmpty(bean.getGeoinfo())) {
            holder.txt_local.setVisibility(View.GONE);
        }
        holder.txt_local.setText(" " + bean.getGeoinfo());
        String avatar = bean.getAuthor().getAvatar();
        if (!TextUtils.isEmpty(avatar)) {
            Picasso.with(getContext())
                    .load(avatar)
                    .into(holder.headView);
        }
        int imge_count = Integer.parseInt(bean.getImage_count());
        if (imge_count == 1) {
            holder.mGridView.setNumColumns(1);
        } else if (imge_count == 2 || imge_count == 4) {
            holder.mGridView.setNumColumns(2);
        } else if (imge_count == 3 || imge_count > 4) {
            holder.mGridView.setNumColumns(3);
        }
        List<Dynamic.DataBean.TrendsListBean.ImageListBean> list = bean.getImage_list();
        if (list.size() > 9) {
            list = list.subList(0, 9);
        }
        GridViewAdapter adapter = new GridViewAdapter(list, getContext());
        holder.mGridView.setAdapter(adapter);
        final List<Dynamic.DataBean.TrendsListBean.ImageListBean> finalList = list;
        holder.mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int[] screenLocation = new int[2];
                View child = ((ViewGroup) view).getChildAt(0);
                child.getLocationOnScreen(screenLocation);
                Picture picture = new Picture(child.getWidth(), child.getHeight(),
                        finalList.get(position).getImage_width(), finalList.get(position).getImage_height(),
                        screenLocation[0], screenLocation[1], finalList.get(position).getImage_url());
                Intent intent = new Intent(getContext(), ShowPictureActivity.class);
                intent.putExtra("params", picture);
                getContext().startActivity(intent);
                ((Activity) getContext()).overridePendingTransition(0, 0);
            }
        });
        holder.txt_local.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MapActivity.class);
                intent.putExtra("lon", bean.getLon());
                intent.putExtra("lat", bean.getLat());
                intent.putExtra("title", bean.getGeoinfo());
                getContext().startActivity(intent);
            }
        });


        return convertView;
    }

    static class ViewHolder {
        CircleImageView headView;
        TextView txt_name, txt_time, txt_content, txt_favorite, txt_local;
        OnMeasureGridView mGridView;

        public ViewHolder(View convertView) {
            headView = (CircleImageView) convertView.findViewById(R.id.item_img_headicon);
            txt_name = (TextView) convertView.findViewById(R.id.item_txt_name);
            txt_time = (TextView) convertView.findViewById(R.id.item_txt_time);
            txt_content = (TextView) convertView.findViewById(R.id.item_txt_content);
            txt_favorite = (TextView) convertView.findViewById(R.id.item_txt_favorite);
            txt_local = (TextView) convertView.findViewById(R.id.item_txt_local);
            mGridView = (OnMeasureGridView) convertView.findViewById(R.id.item_graidView);
        }
    }
}
