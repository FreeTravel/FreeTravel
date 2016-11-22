package com.ma.freetravel.fragment;


import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

/**
 * 动态fragment
 */
public class DynamicFragment extends Fragment {


    private Callback.Cancelable mXHttp;

    public DynamicFragment() {
        // Required empty public constructor
    }

    private TextView mEmptyView;
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
        getData();


        return view;
    }

    private void initData() {
        mParams = getPathParams(true);
        mData = new ArrayList<>();
        mAdapter = new DynamicAdapter(mData, getContext());
    }

    private RequestParams getPathParams(boolean isFlush) {
        if (!isFlush)
            currentPage++;
        else
            currentPage = 0;
        return new RequestParams(Url.getSpace(currentPage));
    }

    private void initView(View view) {
        mEmptyView = (TextView) view.findViewById(R.id.emptyView);
        mListView = (ListView) view.findViewById(R.id.listView);
        mRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeView);
        mListView.setEmptyView(mEmptyView);
        AnimationDrawable anim = (AnimationDrawable) mEmptyView.getBackground();
        anim.start();
        mListView.setAdapter(mAdapter);
    }

    private void initListener() {
    }

    public void getData() {
        mXHttp = x.http().get(mParams, new Callback.CacheCallback<String>() {

            @Override
            public void onSuccess(String result) {
                Log.e("DynamicFragment", result);
                Gson gson = new Gson();
                Dynamic dynamic = gson.fromJson(result, Dynamic.class);
                if (dynamic.getMessage().equals("success")) {
                    mAdapter.addData(dynamic.getData().getTrends_list());
                } else {
                    Toast.makeText(getContext(), "网络似乎有些问题", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Toast.makeText(getContext(), "网络似乎有些问题", Toast.LENGTH_SHORT).show();
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

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mXHttp != null) mXHttp.cancel();
    }
}
