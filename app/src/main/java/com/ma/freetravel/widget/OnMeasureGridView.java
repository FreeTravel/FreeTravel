package com.ma.freetravel.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * @author :ZJF
 * @version : 2016-10-10 下午 9:11
 */
public class OnMeasureGridView extends GridView{
    public OnMeasureGridView(Context context) {
        super(context);
    }

    public OnMeasureGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public OnMeasureGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int h = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>2,MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, h);
    }
}
