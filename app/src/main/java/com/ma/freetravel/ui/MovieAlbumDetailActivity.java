package com.ma.freetravel.ui;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.ma.freetravel.R;
import com.ma.freetravel.adapter.MovieLVAdapter;
import com.ma.freetravel.bean.MovieLv;
import com.ma.freetravel.jiekou.ICustom;
import com.ma.freetravel.url.Url;
import com.ma.freetravel.utils.FlagData;
import com.ma.freetravel.utils.OkHttpUtils;
import com.ma.freetravel.utils.PareUtils;

import java.util.ArrayList;
import java.util.List;

public class MovieAlbumDetailActivity extends MovieBaseActivity implements ICustom, AdapterView.OnItemClickListener {
    private int pageNum = 0;
    private PullToRefreshListView ptrLv;
    private List<MovieLv> movieLvs;
    private Toolbar toolbar;
    private MovieLVAdapter<MovieLv> adapter;
    private TextView title_tv;
    private TextView content_tv;
    private String title;
    private String description;
    private int filmAlbumID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moviealbumdetail);
        init();
        loadData();
    }

    private void loadData() {
        new OkHttpUtils(FlagData.FLAG_MOVIEALBUMDETAIL, this).loadData(Url.Vp_three_Path(pageNum,filmAlbumID));
    }

    private void init() {
        Bundle bundle = getIntent().getBundleExtra("bundle");
        title = bundle.getString("title");
        description = bundle.getString("description");
        filmAlbumID = bundle.getInt("filmAlbumID");
        movieLvs=new ArrayList<>();

        ptrLv = ((PullToRefreshListView) findViewById(R.id.lv_albumDetail));

        toolbar = ((Toolbar) findViewById(R.id.toolbar_movieBase));
        title_tv = ((TextView) findViewById(R.id.title_activity));
        toolbar.setNavigationIcon(R.mipmap.icon_back);
        title_tv.setText("电影合辑");
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        setEmptyView();
        setHeaderView();
        setFooterView();
//        adapter = new MovieLVAdapter<>(alumDetails, this, FlagData.FLAG_MOVIEALBUMDETAIL);
        adapter = new MovieLVAdapter<>(movieLvs, this, FlagData.FLAG_MOVIEALBUMDETAIL);
        ptrLv.setAdapter(adapter);
        ptrLv.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                pageNum++;
                loadData();
            }
            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                pageNum++;
                loadData();
            }
        });
        ptrLv.setOnItemClickListener(this);
    }

    private void setEmptyView() {
        TextView empty = (TextView) findViewById(R.id.emptyView);
        AnimationDrawable anim = (AnimationDrawable) empty.getBackground();
        anim.start();
        ptrLv.setEmptyView(empty);
    }

    private void setHeaderView() {
        View headView = LayoutInflater.from(this).inflate(R.layout.head_lv_aldetail, null);
        title_tv = (TextView) headView.findViewById(R.id.title_head_lv);
        title_tv.setTextSize(18);
        content_tv = (TextView) headView.findViewById(R.id.content_head_lv);
        content_tv.setTextSize(16);
        title_tv.setText(title);
        content_tv.setText(description);
        ptrLv.getRefreshableView().addHeaderView(headView);
    }

    private void setFooterView() {
        final TextView textView = new TextView(this);
        textView.setGravity(Gravity.CENTER);
        textView.setText("查看所有电影合辑");
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setBackgroundColor(Color.GREEN);
                finish();
                overridePendingTransition(R.anim.in2_activity, R.anim.out_activity);
            }
        });
        ptrLv.getRefreshableView().addFooterView(textView);
    }

    @Override
    public void handleActionError(String result, Object object) {

    }

    @Override
    public void handleActionSuccess(String result, Object object) {
        List data1 = PareUtils.getData1(result, FlagData.FLAG_MOVIEALBUMDETAIL);
        movieLvs.clear();
//        movieLvs.addAll(data1);
//        adapter.notifyDataSetChanged();
        adapter.addData(data1);
        if (ptrLv.isRefreshing()){
            ptrLv.postDelayed(new Runnable() {
                @Override
                public void run() {
                    ptrLv.onRefreshComplete();
                }
            },2000);
        }
    }
//listView的点击事件
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position==1 || position==parent.getCount()){
            return;
        }
        Intent intent=new Intent(this,MovieRecommendActivity.class);
        MovieLv movieLv = movieLvs.get(position-2);
        intent.putExtra("movieLv",movieLv);
        startActivity(intent);
    }
}
