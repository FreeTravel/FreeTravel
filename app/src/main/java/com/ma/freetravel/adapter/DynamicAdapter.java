package com.ma.freetravel.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.ma.freetravel.R;
import com.ma.freetravel.bean.Dynamic;
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
        }
        Dynamic.DataBean.TrendsListBean bean = getItem(position);
        holder.txt_name.setText(" " + bean.getAuthor().getUser_name());
        holder.txt_time.setText(" " + bean.getHuman_ctime());
        holder.txt_content.setText(bean.getContent());
        holder.txt_favorite.setText(" " + bean.getFav_count());
        String avatar = bean.getAuthor().getAvatar();
        if(!TextUtils.isEmpty(avatar)){
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
        holder.mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });


        return convertView;
    }

    static class ViewHolder {
        CircleImageView headView;
        TextView txt_name, txt_time, txt_content, txt_favorite;
        OnMeasureGridView mGridView;

        public ViewHolder(View convertView) {
            headView = (CircleImageView) convertView.findViewById(R.id.item_img_headicon);
            txt_name = (TextView) convertView.findViewById(R.id.item_txt_name);
            txt_time = (TextView) convertView.findViewById(R.id.item_txt_time);
            txt_content = (TextView) convertView.findViewById(R.id.item_txt_content);
            txt_favorite = (TextView) convertView.findViewById(R.id.item_txt_favorite);
            mGridView = (OnMeasureGridView) convertView.findViewById(R.id.item_graidView);
        }
    }
}
