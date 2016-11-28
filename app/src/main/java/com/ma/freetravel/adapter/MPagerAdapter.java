package com.ma.freetravel.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by tian on 2016/11/28.
 */

public class MPagerAdapter extends PagerAdapter {
    private List<ImageView> imageViews;

    public MPagerAdapter(List<ImageView> imageViews) {
        this.imageViews = imageViews;
    }

    @Override
    public int getCount() {
        return imageViews!=null?imageViews.size():0;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View ret=null;
        ret=imageViews.get(position);
        container.addView(ret);
        return ret;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        if (object instanceof View){
            View view = (View) object;
            container.removeView(view);
        }
    }
}
