package com.ma.freetravel.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bartoszlipinski.recyclerviewheader.RecyclerViewHeader;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.ma.freetravel.R;
import com.ma.freetravel.adapter.MovieRcLvAdapter;
import com.ma.freetravel.bean.MovieBanner;
import com.ma.freetravel.bean.MovieLv;
import com.ma.freetravel.utils.FlagData;
import com.ma.freetravel.jiekou.ICustom;
import com.ma.freetravel.url.Url;
import com.ma.freetravel.utils.OkHttpUtils;
import com.ma.freetravel.utils.PareUtils;
import com.ma.freetravel.widget.PullToRefreshRecyclerView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment implements OnItemClickListener, ICustom {

    public static final String TAG = "MovieFragment";

    private PullToRefreshRecyclerView prcLv;
    private ConvenientBanner convenientBanner;
    private MovieRcLvAdapter reclAdapter;
    private List<String> imagesPath = new ArrayList<>();
    private List<MovieBanner> movieBanners = new ArrayList<>();
    private List<MovieLv> movieLvs = new ArrayList<>();
    private RecyclerView rcLv;

    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadData();
    }

    private void loadData() {
        new OkHttpUtils(FlagData.FLAG_MOVIEBANNER, this).loadData(Url.Vp_Path(0));
        new OkHttpUtils(FlagData.FLAG_MOVIELV, this).loadData(Url.lvPath);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        prcLv = (PullToRefreshRecyclerView) view.findViewById(R.id.rclv_movie);
        ProgressBar empty = (ProgressBar) view.findViewById(R.id.empty);
        //布局管理器
        LinearLayoutManager llManager = new LinearLayoutManager(getContext());
        llManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcLv = prcLv.getRefreshableView();
        rcLv.setLayoutManager(llManager);

        reclAdapter = new MovieRcLvAdapter(getContext(), movieLvs);
        setHeadToReclv();
        reclAdapter.setEmptyView(empty);
        rcLv.setAdapter(reclAdapter);
    }

    private void setHeadToReclv() {
        RecyclerViewHeader header = RecyclerViewHeader.fromXml(getContext(), R.layout.convenitent);
        convenientBanner = (ConvenientBanner) LayoutInflater.from(getContext()).inflate(R.layout.convenitent, null);
        convenientBanner.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 280));
//        轮播指示器
        convenientBanner.setPages(new CBViewHolderCreator<NetImageHolderView>() {
            @Override
            public NetImageHolderView createHolder() {
                return new NetImageHolderView();
            }
        }, imagesPath)//填写数据源
                // 设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
                .setPageIndicator(new int[]{R.mipmap.feature_point, R.mipmap.feature_point_cur})
                //设置指示器的方向
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT)
                .setOnItemClickListener(this);
        header.attachTo(rcLv);
    }

    //轮播的点击事件
    @Override
    public void onItemClick(int position) {
        MovieBanner movieBanner = movieBanners.get(position);
        Intent intent=new Intent();

    }

    @Override
    public void handleActionError(String result, Object object) {
        Log.e(TAG, result);
    }

    @Override
    public void handleActionSuccess(String result, Object object) {
        Log.e(TAG, "handleActionSuccess: " + Thread.currentThread().getName());
        if (result != null) {
            if (object.equals(FlagData.FLAG_MOVIEBANNER)) {
                List list = PareUtils.getData1(result, FlagData.FLAG_MOVIEBANNER);
                movieBanners.addAll(list);
                for (int i = 0; i < movieBanners.size(); i++) {
                    MovieBanner movieBanner = movieBanners.get(i);
                    imagesPath.add(movieBanner.getThePhoto());
                }
                reclAdapter.setHeaderView(convenientBanner);
            } else if (object.equals(FlagData.FLAG_MOVIELV)) {
                movieLvs = PareUtils.getData1(result, FlagData.FLAG_MOVIELV);
                reclAdapter.addDatas(movieLvs);
            }
        }

    }

    public class NetImageHolderView implements Holder<String> {
        private ImageView imageView;

        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, int position, String data) {
            Picasso.with(context).load(data).into(imageView);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        //开始自动翻页
        convenientBanner.startTurning(5000);
    }

    @Override
    public void onPause() {
        super.onPause();
        //停止翻页
        convenientBanner.stopTurning();
    }

}
