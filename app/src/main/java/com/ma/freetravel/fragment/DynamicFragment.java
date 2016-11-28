package com.ma.freetravel.fragment;


import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ma.freetravel.R;
import com.ma.freetravel.adapter.DynamicAdapter;
import com.ma.freetravel.bean.Dynamic;
import com.ma.freetravel.url.Url;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import static com.ma.freetravel.R.id.listView;

/**
 * 动态fragment
 */
public class DynamicFragment extends Fragment {


    private Callback.Cancelable mXHttp;

    public DynamicFragment() {
        // Required empty public constructor
    }

    private TextView mEmptyView, footView;
    private ListView mListView;
    private SwipeRefreshLayout mRefreshLayout;
    private RequestParams mParams;
    private int currentPage;
    private List<Dynamic.DataBean.TrendsListBean> mData;
    private DynamicAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dynamic, container, false);
        initData();
        initView(view);
        initListener();
        getData(true);
        return view;
    }

    private void initData() {
        mData = new ArrayList<>();
        mAdapter = new DynamicAdapter(mData, getContext());
    }

    private RequestParams getPathParams(boolean isFlush) {
        if (!isFlush)
            currentPage++;
        else
            currentPage = 1;
        return new RequestParams(Url.getSpace(currentPage, getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels));
    }

    private void initView(View view) {
        mEmptyView = (TextView) view.findViewById(R.id.emptyView);
        mListView = (ListView) view.findViewById(listView);
        mRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeView);
        mListView.setEmptyView(mEmptyView);
        AnimationDrawable anim = (AnimationDrawable) mEmptyView.getBackground();
        anim.start();
        footView = new TextView(getContext());
        footView.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT
                , AbsListView.LayoutParams.MATCH_PARENT));
        footView.setText("加载更多");
        footView.setGravity(Gravity.CENTER);
        footView.setTextSize(20);
        mListView.addFooterView(new View(getContext()));
        mListView.setAdapter(mAdapter);
        mRefreshLayout.setColorSchemeColors(Color.parseColor("#B0E0E6"),
                Color.parseColor("#AEEEEE"),
                Color.parseColor("#97FFFF"),
                Color.parseColor("#96CDCD"));


    }

    private void initListener() {
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData(true);
            }
        });
        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            boolean isBottom = false;

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState == SCROLL_STATE_IDLE && isBottom) {
                    mListView.addFooterView(footView);
                    mRefreshLayout.setRefreshing(true);
                    getData(false);
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                isBottom = firstVisibleItem + visibleItemCount == totalItemCount;
            }
        });

    }

    public void getData(final boolean isFlush) {
        mParams = getPathParams(isFlush);
        mXHttp = x.http().get(mParams, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                Dynamic dynamic = gson.fromJson(result, Dynamic.class);
                if (dynamic.getMessage().equals("success")) {
                    if (isFlush) {
                        mAdapter.refulshData(dynamic.getData().getTrends_list());
                    } else {
                        mAdapter.addData(dynamic.getData().getTrends_list());
                    }
                } else {
                    Toast.makeText(getContext(), "网络似乎有些问题", Toast.LENGTH_SHORT).show();
                }
                hideRefreshView();
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Toast.makeText(getContext(), "网络似乎有些问题", Toast.LENGTH_SHORT).show();
                hideRefreshView();
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }

            @Override
            public boolean onCache(String result) {
                return false;
            }
        });
    }

    private void hideRefreshView() {
        if (mRefreshLayout.isRefreshing()) {
            mRefreshLayout.setRefreshing(false);
        }
        if (mListView != null) {
            mListView.removeFooterView(footView);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mXHttp != null) mXHttp.cancel();
    }
}
