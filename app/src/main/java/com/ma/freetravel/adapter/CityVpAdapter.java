package com.ma.freetravel.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by 哈士奇爱吃苹果 on 2016/11/28.
 */
public class CityVpAdapter extends PagerAdapter {
    private Context context;
    private List<ImageView> data;

    public CityVpAdapter(Context context, List<ImageView> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data!=null?data.size():0;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView=data.get(position);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        if (object instanceof View){
            View view= (View) object;
            container.removeView(view);//移除
        }
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
}
