package com.ma.freetravel.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ma.freetravel.R;
import com.ma.freetravel.bean.MovieLv;
import com.ma.freetravel.url.Url;

import java.util.List;

/**
 * Created by tian on 2016/11/25.
 */

public class MovieLVAdapter extends BaseListViewAdapter<MovieLv>{
    private List<MovieLv> movieLvs;
    private Context context;

    public MovieLVAdapter(List<MovieLv> data, Context context) {
        super(data, context);
        this.movieLvs = data;
        this.context = context;
    }


    @Override
    public View getItemView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = getInflater().inflate(R.layout.item_reclv_movie, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = ((ViewHolder) convertView.getTag());
        }
        MovieLv movieLv = movieLvs.get(position);
        int columnID = movieLv.getColumnID();
        Glide.with(context).load(Url.Head3 + movieLv.getPicURL()).into(holder.iv);
        if (columnID == 1) {
            holder.introduction_tv.setText(movieLv.getIntroduction());
            holder.shipin_iv.setVisibility(View.VISIBLE);
        } else {
            holder.introduction_tv.setText(movieLv.getTitle());
            holder.shipin_iv.setVisibility(View.GONE);
        }
        switch (columnID) {
            case 1:
//                    holder.title_tv.setText("[" + R.string.columnName1_movie + "]");
                holder.title_tv.setText(R.string.columnName1_movie);
                break;
            case 2:
                holder.title_tv.setText("[" + R.string.columnName2_movie + "]");
                break;
            case 3:
                holder.title_tv.setText("[" + R.string.columnName3_movie + "]");
                break;
            case 4:
                holder.title_tv.setText("[" + R.string.columnName4_movie + "]");
                break;
            case 5:
                holder.title_tv.setText("[" + R.string.columnName5_movie + "]");
                break;
        }
        return convertView;
    }

    public class ViewHolder {
        private ImageView iv;
        private ImageView shipin_iv;
        private TextView title_tv;
        private TextView introduction_tv;

        public ViewHolder(View itemView) {
            iv = ((ImageView) itemView.findViewById(R.id.iv_item_reclv));
            shipin_iv = ((ImageView) itemView.findViewById(R.id.shipin_iv_item_reclv));
            title_tv = ((TextView) itemView.findViewById(R.id.title_tv_item_reclv));
            introduction_tv = ((TextView) itemView.findViewById(R.id.introduction_tv_item_reclv));
        }
    }
}
