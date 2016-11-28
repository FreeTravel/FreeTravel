package com.ma.freetravel.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import com.handmark.pulltorefresh.library.PullToRefreshBase;


/**
 * Created by tian on 2016/11/25.
 */
public class PullToRefreshRecyclerView extends PullToRefreshBase<RecyclerView> {
    public PullToRefreshRecyclerView(Context context) {
        super(context);
    }
    public PullToRefreshRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 获取刷新滚动的方向
     * @return
     */
    @Override
    public Orientation getPullToRefreshScrollDirection() {
        return Orientation.VERTICAL;
    }

    /**
     *
     * 对那个View进行刷新
     * @param context Context to create view with
     * @param attrs AttributeSet from wrapped class. Means that anything you
     *            include in the XML layout declaration will be routed to the
     *            created View
     * @return
     */
    @Override
    protected RecyclerView createRefreshableView(Context context, AttributeSet attrs) {
        //布局中的recyclerView
        RecyclerView recyclerView = new RecyclerView(context, attrs);
        return recyclerView;
    }


    /**
     * 是否准备好下拉刷新   true准备好   false  不进入刷新状态
     * @return
     */
    @Override
    protected boolean isReadyForPullStart() {
        //获取刷新的View
        RecyclerView recyclerView = getRefreshableView();
        //获取第一个item   View
        View child = recyclerView.getChildAt(0);
        //第一个item到顶端的距离
        int top = child.getTop();
        //获取控件的内边距
        int paddingTop = recyclerView.getPaddingTop();
        //获取第一条item的外边距
        MarginLayoutParams params = (MarginLayoutParams) child.getLayoutParams();
        int topMargin = params.topMargin;

        return top == topMargin+paddingTop;
    }

    /**
     * 是否准备好上拉加载  true 准备好 false不进入刷新状态 没准备好
     * @return
     */
    @Override
    protected boolean isReadyForPullEnd() {
        //获取控件
        RecyclerView recyclerView = getRefreshableView();
        //获取item的条数
        int childCount = recyclerView.getChildCount();
        //获取最后的item
        View child = recyclerView.getChildAt(childCount-1);
        //控件的总高度
        int heigth = recyclerView.getHeight();
        //获取控件的底部内边距
        int paddingBottom = recyclerView.getPaddingBottom();
        //获取最后的item的外边距
        MarginLayoutParams params = (MarginLayoutParams) child.getLayoutParams();
        int bottomMagin= params.bottomMargin;
        //最后的item的底部距离顶部的值
        int bottom = child.getBottom();

        //获取总的item数量
        int itemCount = recyclerView.getAdapter().getItemCount();
        //获取当前item在adapter的位置
        int childAdapterPos = recyclerView.getChildAdapterPosition(child);
        //判断是否到底端
        return heigth == bottom+bottomMagin+paddingBottom&&childAdapterPos+1==itemCount;
    }

}
