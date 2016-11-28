package com.ma.freetravel.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.convenientbanner.holder.Holder;
import com.ma.freetravel.R;
import com.ma.freetravel.bean.ImageBean;
import com.squareup.picasso.Picasso;


public class NetworkImageHolderView implements Holder<ImageBean.DataBean.ItemRecommendBean> {


    private TextView name;
    private ImageView image;


    @Override
    public View createView(Context context) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        RelativeLayout relativeLayout = (RelativeLayout) inflater.inflate(R.layout.head_item, null);
        image = (ImageView) relativeLayout.findViewById(R.id.iv);
        name = ((TextView) relativeLayout.findViewById(R.id.tv));

        return relativeLayout;
    }

    @Override
    public void UpdateUI(Context context, int position, ImageBean.DataBean.ItemRecommendBean data) {
        name.setText(data.getTitle());
        Picasso.with(context).load(data.getMainImage()).into(image);
    }


}
