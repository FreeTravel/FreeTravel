package com.ma.freetravel.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
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
 * Created by Administrator on 2016/11/25.
 */

public class MovieRcLvAdapter extends RecyclerView.Adapter<MovieRcLvAdapter.MyViewHolder,> {
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_NORMAL = 1;
    private View mHeaderView;
    private View mEmptyView;
    private Context context;
    private List<MovieLv> movieLvs;

    public MovieRcLvAdapter(Context context, List<MovieLv> movieLvs) {
        this.context = context;
        this.movieLvs = movieLvs;
    }

    public void addDatas(List<MovieLv> movieLvList) {
        movieLvs.addAll(movieLvList);
        //刷新所有丶数据
//        notifyDataSetChanged();
        //只刷新新的数据
        notifyItemRangeInserted(getItemCount(), movieLvList.size());
        /*
        新加了一行，这行的目的就是告诉adapter，原来的那些item它们的position发生了变化.
这样再点击每个item。位置正确了。
         */
//        notifyItemRangeChanged(getItemCount() + movieLvList.size(), getItemCount() - movieLvList.size());
    }

    public void setHeaderView(View headerView) {
        mHeaderView = headerView;
        notifyItemInserted(0);
    }

    public void setEmptyView(View emptyView) {
        mEmptyView = emptyView;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if (mHeaderView == null) return TYPE_NORMAL;
        if (position == 0) return TYPE_HEADER;
        return TYPE_NORMAL;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType==TYPE_HEADER){
        }
        View view = LayoutInflater.from(context).inflate(R.layout.item_reclv_movie, parent, false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        if (getItemViewType(position) == TYPE_HEADER) {//头视图

        }else if (getItemViewType(position)==TYPE_NORMAL){
            MovieLv movieLv = movieLvs.get(position);
            String linkUrl = movieLv.getLinkUrl();
            int columnID = movieLv.getColumnID();
            if (!TextUtils.isEmpty(linkUrl)) {
                holder.shipin_iv.setVisibility(View.VISIBLE);
            }
            Glide.with(context).load(Url.Head3 + movieLv.getPicURL()).into(holder.iv);
            holder.introduction_tv.setText(movieLv.getIntroduction());
            switch (columnID) {
                case 1:
//                    holder.title_tv.setText("[" + R.string.columnName1_movie + "]");
                    holder.title_tv.setText( R.string.columnName1_movie );
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
        }
    }

    @Override
    public int getItemCount() {
        return movieLvs!=null?movieLvs.size():0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private ImageView shipin_iv;
        private TextView title_tv;
        private TextView introduction_tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv = ((ImageView) itemView.findViewById(R.id.iv_item_reclv));
            shipin_iv = ((ImageView) itemView.findViewById(R.id.shipin_iv_item_reclv));
            title_tv = ((TextView) itemView.findViewById(R.id.title_tv_item_reclv));
            introduction_tv = ((TextView) itemView.findViewById(R.id.introduction_tv_item_reclv));
        }
    }
    public class HeaderHolder extends RecyclerView.ViewHolder{

        public HeaderHolder(View itemView) {
            super(itemView);
        }
    }

    public class EmptyHolder extends RecyclerView.ViewHolder {
        public EmptyHolder(View itemView) {
            super(itemView);
        }
    }
}
