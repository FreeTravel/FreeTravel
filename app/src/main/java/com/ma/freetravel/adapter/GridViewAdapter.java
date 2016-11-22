package com.ma.freetravel.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ma.freetravel.R;
import com.ma.freetravel.bean.Dynamic;
import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * @author :ZJF
 * @version : 2016-11-07 下午 9:39
 */

public class GridViewAdapter extends BaseListViewAdapter<Dynamic.DataBean.TrendsListBean.ImageListBean> {

    private float width;

    public GridViewAdapter(List<Dynamic.DataBean.TrendsListBean.ImageListBean> data, Context context) {
        super(data, context);
        width = context.getResources().getDisplayMetrics().widthPixels;
    }

    @Override
    public View getItemView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = getInflater()
                    .inflate(R.layout.dynamicfra_item_gridview_img_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (getCount() == 1) {
            Picasso.with(getContext())
                    .load(getItem(position).getImage_url())
                    .resize(getItem(position).getImage_width(), getItem(position).getImage_height())
                    .into(holder.mImageView);
        } else if (getCount() == 2 || getCount() == 4) {
            Picasso.with(getContext())
                    .load(getItem(position).getImage_url())
                    .resize(((int) (width / 2)), ((int) (width / 2)))
                    .into(holder.mImageView);
        } else {
            Picasso.with(getContext())
                    .load(getItem(position).getImage_url())
                    .resize(((int) (width / 3)), ((int) (width / 3)))
                    .into(holder.mImageView);
        }

        return convertView;
    }

    static class ViewHolder {
        ImageView mImageView;

        public ViewHolder(View convertView) {
            mImageView = (ImageView) convertView.findViewById(R.id.item_img_icon);
        }
    }
}
