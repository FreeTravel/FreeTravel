package com.ma.freetravel.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by tian on 2016/11/28.
 */

public class ViewPagerFlow extends ViewPager{

    public ViewPagerFlow(Context context) {
        this(context,null);
    }

    public ViewPagerFlow(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int height=0;
        for (int i = 0; i < getChildCount(); i++) {
            View viewChild = getChildAt(i);
            viewChild.measure(widthMeasureSpec,MeasureSpec.makeMeasureSpec(0,MeasureSpec.UNSPECIFIED));
            int height1 = viewChild.getHeight();
            if (height1>height)
                height=height1;
        }
        heightMeasureSpec=MeasureSpec.makeMeasureSpec(height,MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
