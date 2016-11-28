package com.ma.freetravel.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bartoszlipinski.recyclerviewheader.RecyclerViewHeader;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.ma.freetravel.R;
import com.ma.freetravel.fragment.MovieFragment;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.ma.freetravel.R.id.convenientBanner;

/**
 * Created by Administrator on 2016/11/25.
 */

public class setHeaderView implements OnItemClickListener {

    private void setHeadToReclv(Context context, List<String> imagesPath,Object object) {
        RecyclerViewHeader header = RecyclerViewHeader.fromXml(context, R.layout.convenitent);
        ConvenientBanner convenientBanner = (ConvenientBanner) LayoutInflater.from(context).inflate(R.layout.convenitent, null);
       convenientBanner.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 280));
//        轮播指示器
    convenientBanner.setPages(new CBViewHolderCreator<NetImageHolderView>() {
            @Override
            public NetImageHolderView createHolder() {
                return new NetImageHolderView();
            }
        }, imagesPath)//填写数据源
                // 设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
                .setPageIndicator(new int[]{R.mipmap.feature_point, R.mipmap.feature_point_cur})
                //设置指示器的方向
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT)
                .setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(int position) {

    }

    public class NetImageHolderView implements Holder<String> {
        private ImageView imageView;

        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, int position, String data) {
            Picasso.with(context).load(data).into(imageView);
        }
    }
}
