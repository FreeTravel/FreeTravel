package com.ma.freetravel.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.bartoszlipinski.recyclerviewheader.RecyclerViewHeader;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.google.gson.Gson;
import com.ma.freetravel.R;
import com.ma.freetravel.adapter.CityRvAdapter;
import com.ma.freetravel.bean.CityBeans;
import com.ma.freetravel.bean.ImageBean;
import com.ma.freetravel.widget.NetworkImageHolderView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class CityActivity extends AppCompatActivity {

    private String path1="http://m.shijieyou.com/mobileJson/recommendByClientName?client_name=Paris";

    private String path2="http://www.qiugonglue.com/api/v3/board/board_index?client_name=QGLMain&client_version=6.0.1&os_version=17&place_id=4003001&platform=android&screen_size=720x1280&tm=1479891111076&uuid=133524654038404&sign=269705da5428381676b38dcd6eb93458";



    private ConvenientBanner convenientBanner;
   // private List<ImageBean.DataBean.ItemRecommendBean> imagedata;
   private List<ImageBean.DataBean.ItemRecommendBean> imagedata;

    private RecyclerView recyclerView;
    private List<Integer> listtype;
    private CityRvAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        recyclerView = ((RecyclerView) findViewById(R.id.recyclerView_city));
        initDatas();

    }
    private void initManger() {
        //线性布局管理器   ListView 效果  获取横向的ListVIew
        LinearLayoutManager linearlayoutManager = new LinearLayoutManager(CityActivity.this);
        //设置布局的方向
        linearlayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearlayoutManager);
    }
    private void initDatas() {
        listtype=new ArrayList<>();
        RequestParams params=new RequestParams("http://www.qiugonglue.com/api/v3/board/board_index?client_name=QGLMain&client_version=6.0.1&os_version=17&place_id=4003001&platform=android&screen_size=720x1280&tm=1479891111076&uuid=133524654038404&sign=269705da5428381676b38dcd6eb93458");

        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                    Gson gson = new Gson();
                        CityBeans cityBeans = gson.fromJson(result, CityBeans.class);
                        for (int i = 0; i < 3; i++) {
                            listtype.add(i);
                        }
                        Log.e("saaa",cityBeans.getData().getPlace_id().toString());
                        adapter = new CityRvAdapter(cityBeans, CityActivity.this, listtype);
                        recyclerView.setAdapter(adapter);
                        initManger();
                        initHeadView();
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("aaaaa","aaaaaa+++++++++");
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }

    //添加viewpager做透视图
    private void initHeadView() {

        RecyclerViewHeader header = RecyclerViewHeader.fromXml(CityActivity.this, R.layout.dynamic_lv_head);
        convenientBanner = ((ConvenientBanner)header.findViewById(R.id.cb));
        //下载图片
        loadImageData();
        convenientBanner.setPages(new CBViewHolderCreator() {
            @Override
            public NetworkImageHolderView createHolder() {
                return new NetworkImageHolderView();
            }
        },imagedata)
                .setPageIndicator(new int[]{R.drawable.ic_page_indicator, R.drawable.ic_page_indicator_focused})
                //设置指示器的位置  默认底部居中
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT)
                //设置指示器是否可见 默认可见
                .setPointViewVisible(true)
//        .setPageTransformer()
                //设置点击事件
                .setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {

                        //跳转
                    }
                });
        header.attachTo(recyclerView);
    }

    private void loadImageData() {
        imagedata=new ArrayList<>();
        RequestParams rp=new RequestParams(path1);
        x.http().get(rp, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson=new Gson();
                ImageBean imageBean = gson.fromJson(result, ImageBean.class);
                //List<ImageBean.DataBean.ItemRecommendBean> item_recommend = imageBean.getData().getItem_recommend();
                imagedata.addAll(imageBean.getData().getItem_recommend());
                Log.e("xxxx",imageBean.getData().getItem_recommend().get(0).getTitle().toString());
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

}
