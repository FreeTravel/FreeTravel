package com.ma.freetravel.fragment;


import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.ma.freetravel.R;
import com.ma.freetravel.adapter.MPagerAdapter;
import com.ma.freetravel.adapter.MovieLVAdapter;
import com.ma.freetravel.bean.MovieBanner;
import com.ma.freetravel.bean.MovieLv;
import com.ma.freetravel.jiekou.ICustom;
import com.ma.freetravel.ui.AlbumActivity;
import com.ma.freetravel.ui.MovieMusicActivity;
import com.ma.freetravel.ui.MovieRecommendActivity;
import com.ma.freetravel.ui.MovieRelaxActivity;
import com.ma.freetravel.url.Url;
import com.ma.freetravel.utils.FlagData;
import com.ma.freetravel.utils.OkHttpUtils;
import com.ma.freetravel.utils.PareUtils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class MoiveFragment2 extends Fragment implements ICustom, AdapterView.OnItemClickListener {

    private int pageNum = 0;
    private List<MovieBanner> movieBanners = new ArrayList<>();
    private List<MovieLv> movieLvs = new ArrayList<>();
    private PullToRefreshListView pulv;
    private MovieLVAdapter movieListAdapter;
    private List<ImageView> imageViews = new ArrayList<>();
    private MPagerAdapter mPagerAdapter;
    private ViewPager viewPager;
    private RadioGroup rg;
    private TextView rg_text;
    private Timer mTimer;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
            }
        }
    };

    public MoiveFragment2() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadData();
    }

    //下载数据
    private void loadData() {
        new OkHttpUtils(FlagData.FLAG_MOVIEBANNER, this).loadData(Url.Vp_Path(pageNum));
        new OkHttpUtils(FlagData.FLAG_MOVIELV, this).loadData(Url.lvPath);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_moive_fragment2, container, false);
        initView(view);
        setVpListener();//viewPager的监听事件
        return view;
    }

    private void setVpListener() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (positionOffset == 0 && imageViews.size() > 1) {
                    if (position == 0) {
                        viewPager.setCurrentItem(imageViews.size() - 2, false);
                    } else if (position == imageViews.size() - 1) {
                        viewPager.setCurrentItem(1, false);
                    }
                }
            }

            @Override
            public void onPageSelected(int position) {
                if (position > 0 && position <= movieBanners.size()) {
                    rg_text.setText("合辑：" + movieBanners.get(position - 1).getTitle());
                    setRG(position);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void setRG(int position) {
        int count = rg.getChildCount();
        for (int i = 0; i < count; i++) {
            rg.getChildAt(i).setEnabled(false);
        }
        rg.getChildAt(position).setEnabled(true);
    }

    private void initView(View view) {
        pulv = ((PullToRefreshListView) view.findViewById(R.id.pulv_movie));
        TextView empty = (TextView) view.findViewById(R.id.emptyView);
        AnimationDrawable anim = (AnimationDrawable) empty.getBackground();
        anim.start();
        View hearView = LayoutInflater.from(getContext()).inflate(R.layout.header_lv, null);//头视图
        viewPager = ((ViewPager) hearView.findViewById(R.id.viewpager_hear_lv));
        rg = (RadioGroup) hearView.findViewById(R.id.radiogroup);
        rg_text = (TextView) hearView.findViewById(R.id.rg_txt);
        mPagerAdapter = new MPagerAdapter(imageViews);
        viewPager.setAdapter(mPagerAdapter);

        ListView listView = pulv.getRefreshableView();
        listView.setEmptyView(empty);//添加空视图
        listView.addHeaderView(hearView);//添加头视图
        movieListAdapter = new MovieLVAdapter(movieLvs, getContext(), FlagData.FLAG_MOVIELV);
        pulv.setAdapter(movieListAdapter);
        //下拉刷新 上拉加载
        pulv.setMode(PullToRefreshBase.Mode.BOTH);
        pulv.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
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
        pulv.setOnItemClickListener(this);
    }

    @Override
    public void handleActionError(String result, Object object) {

    }

    @Override
    public void handleActionSuccess(String result, Object object) {
        if (result != null) {
            if (object.equals(FlagData.FLAG_MOVIEBANNER)) {
                List list = PareUtils.getData1(result, FlagData.FLAG_MOVIEBANNER);
                movieBanners.clear();
                movieBanners.addAll(list);
                for (int i = 0; i < movieBanners.size(); i++) {
                    MovieBanner movieBanner = movieBanners.get(i);
                    String thePhoto = movieBanner.getThePhoto();
                    boolean b = thePhoto.startsWith("/ueditor");
                    if (b) {
                        makeImage(Url.Head3 + movieBanner.getThePhoto());
                    }
                    makeImage(Url.Head_VpPath + movieBanner.getThePhoto());//获取轮播图片
                    makeRadioButton();//小图标
                }
                makeCopyImage();//复制前后两张图片
                viewPager.setCurrentItem(0);
                setTimer();
                mPagerAdapter.notifyDataSetChanged();
            } else if (object.equals(FlagData.FLAG_MOVIELV)) {
                List data1 = PareUtils.getData1(result, FlagData.FLAG_MOVIELV);
                movieLvs.addAll(0, data1);
                movieListAdapter.notifyDataSetChanged();
            }
            if (pulv.isRefreshing()) {
                pulv.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pulv.onRefreshComplete();
                    }
                }, 2000);
            }
        }

    }

    private void setTimer() {
        mTimer = new Timer();
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(1);
            }
        }, 0, 2000);
    }

    private void makeCopyImage() {
        String photoPath = Url.Head_VpPath + movieBanners.get(0).getThePhoto();
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new ViewPager.LayoutParams());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Picasso.with(getContext()).load(photoPath).into(imageView);
        imageViews.add(imageView);

        String photoPath1 = Url.Head_VpPath + movieBanners.get(movieBanners.size() - 1).getThePhoto();
        ImageView imageView_1 = new ImageView(getContext());
        imageView_1.setLayoutParams(new ViewPager.LayoutParams());
        imageView_1.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Picasso.with(getContext()).load(photoPath1).into(imageView_1);
        imageViews.add(0, imageView_1);
    }

    private void makeImage(String path) {
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Picasso.with(getContext()).load(path).into(imageView);
        imageViews.add(imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AlbumActivity.class);
                startActivity(intent);
            }
        });
    }

    private void makeRadioButton() {
        RadioButton rb = new RadioButton(getContext());
        rb.setLayoutParams(new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT));
        rb.setButtonDrawable(null);
        rb.setBackgroundResource(R.drawable.bg_point);
        rb.setEnabled(false);
        rg.addView(rb);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mTimer.cancel();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        MovieLv movieLv = movieLvs.get(position-2);
        int columnID = movieLv.getColumnID();
        Intent intent = new Intent();
        intent.putExtra("movieLv", movieLv);
        switch (columnID) {
            case 1:
                intent.setClass(getContext(), MovieRecommendActivity.class);
                break;
            case 4:
                intent.setClass(getContext(), MovieMusicActivity.class);
                break;
            case 5:
                intent.setClass(getContext(), MovieRelaxActivity.class);
                break;
        }
        startActivity(intent);
    }
}
