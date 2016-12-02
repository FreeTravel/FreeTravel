package com.ma.freetravel.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.ma.freetravel.R;
import com.ma.freetravel.adapter.AlbumLVAdapter;
import com.ma.freetravel.bean.MovieAlbum;
import com.ma.freetravel.jiekou.ICustom;
import com.ma.freetravel.url.Url;
import com.ma.freetravel.utils.FlagData;
import com.ma.freetravel.utils.OkHttpUtils;
import com.ma.freetravel.utils.PareUtils;

import java.util.ArrayList;
import java.util.List;

public class AlbumActivity extends MovieBaseActivity implements ICustom, AdapterView.OnItemClickListener {

    private ListView lv;
    private SwipeRefreshLayout swipeRefresh;
    private List<MovieAlbum> movieAlba;
    private AlbumLVAdapter adapter;
    private int pageNum = 0;
    private Toolbar toolbar;
    private TextView title_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
        initView();
        loadData();
    }

    private void loadData() {
        new OkHttpUtils(FlagData.FLAG_MOVIEALBUM, this).loadData(Url.Vp_second_Path(pageNum));
    }

    private void initView() {
        toolbar = ((Toolbar) findViewById(R.id.toolbar_movieBase));
        title_tv = ((TextView) findViewById(R.id.title_activity));
        toolbar.dismissPopupMenus();
        toolbar.setNavigationIcon(R.mipmap.icon_back);
        title_tv.setText("电影合辑");
        toolbar.dismissPopupMenus();
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        movieAlba = new ArrayList<>();
        lv = ((ListView) findViewById(R.id.lv_album));
        swipeRefresh = ((SwipeRefreshLayout) findViewById(R.id.swipefre_album));
        adapter = new AlbumLVAdapter(movieAlba, this, FlagData.FLAG_MOVIEALBUM);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                pageNum++;
                loadData();
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void handleActionError(String result, Object object) {

    }

    @Override
    public void handleActionSuccess(String result, Object object) {
        List movieAlbum = PareUtils.getData1(result, object);
//        movieAlba.clear();
//        movieAlba.addAll(movieAlbum);
//        adapter.notifyDataSetChanged();
        adapter.addData(movieAlbum);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, MovieAlbumDetailActivity.class);
        Bundle bundle=new Bundle();
        bundle.putString("title",movieAlba.get(position).getTitle());
        bundle.putString("description",movieAlba.get(position).getDescription());
        int filmAlbumID = movieAlba.get(position).getFilmAlbumID();
        bundle.putInt("filmAlbumID", filmAlbumID);
        intent.putExtra("bundle",bundle);
        startActivity(intent);
    }
}
