package com.ma.freetravel.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bartoszlipinski.recyclerviewheader.RecyclerViewHeader;
import com.google.gson.Gson;
import com.ma.freetravel.R;
import com.ma.freetravel.adapter.CityRvAdapter;
import com.ma.freetravel.adapter.CityVpAdapter;
import com.ma.freetravel.bean.CityBeans;
import com.ma.freetravel.bean.ImageBean;
import com.squareup.picasso.Picasso;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class CityActivity extends AppCompatActivity {

    private String path1 = "http://m.shijieyou.com/mobileJson/recommendByClientName?client_name=Paris";

    private String path2 = "http://www.qiugonglue.com/api/v3/board/board_index?client_name=QGLMain&client_version=6.0.1&os_version=17&place_id=4003001&platform=android&screen_size=720x1280&tm=1479891111076&uuid=133524654038404&sign=269705da5428381676b38dcd6eb93458";

    private List<ImageBean.DataBean.ItemRecommendBean> imagedata;
    private RecyclerView recyclerView;
    private List<Integer> listtype;
    private CityRvAdapter adapter;
    private ViewPager vp_city;
    private List<ImageView> data;
    private CityVpAdapter vp_adapter;
    private TextView tv_vp;

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

        listtype = new ArrayList<>();
        RequestParams params = new RequestParams("http://www.qiugonglue.com/api/v3/board/board_index?client_name=QGLMain&client_version=6.0.1&os_version=17&place_id=4003001&platform=android&screen_size=720x1280&tm=1479891111076&uuid=133524654038404&sign=269705da5428381676b38dcd6eb93458");

        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                CityBeans cityBeans = gson.fromJson(result, CityBeans.class);
                for (int i = 0; i < 3; i++) {
                    listtype.add(i);
                }
                Log.e("saaa", cityBeans.getData().getPlace_id().toString());
                adapter = new CityRvAdapter(cityBeans, CityActivity.this, listtype);
                recyclerView.setAdapter(adapter);
                initManger();
                initHeadView();
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("aaaaa", "aaaaaa+++++++++");
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
        vp_city = ((ViewPager) header.findViewById(R.id.vp_city));
        tv_vp = ((TextView) header.findViewById(R.id.text_vp));
        loadImageData();
        header.attachTo(recyclerView);
    }

    private Timer timer;

    private void setTimer(){
        if (timer==null){
            timer=new Timer();
        }
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                vp_city.post(new Runnable() {
                    @Override
                    public void run() {
                        vp_city.setCurrentItem(vp_city.getCurrentItem()+1);
                    }
                });
            }
        },3000,3000);

        //触摸监听
        vp_city.setOnTouchListener(new View.OnTouchListener() {
            /**
             * 参数1： ViewPager 调用者
             * 参数2： 记录触摸的事件  包含： 触摸的xy 触摸的动作： down move up
             */
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                // 获取触摸动作
                int action  = event.getAction();

                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        //按下
                        //停止定时器
                        timer.cancel(); //关闭
                        break;
                    case MotionEvent.ACTION_UP:
                        //抬起
                        //开启定时器
                        timer = new Timer(); //新创建一个对象
                        timer.schedule(new TimerTask() {

                            @Override
                            public void run() {
                                // TODO Auto-generated method stub

                                runOnUiThread(new Runnable() {
                                    // 主线程
                                    @Override
                                    public void run() {
                                        // TODO Auto-generated method stub
                                        int currentItem = vp_city.getCurrentItem(); // 得到ViewPager当前显示第几页
                                        int count = vp_adapter.getCount(); // 总共有多少条
                                        // 0123 4
                                        if (currentItem == (count - 1)) {
                                            // 如果使用第二个参数，单条显示Fragment数据可能无法加载！
                                            vp_city.setCurrentItem(0);
                                        } else {
                                            currentItem++;
                                            vp_city.setCurrentItem(currentItem);
                                        }
                                    }
                                });
                            }
                        }, 3000, 3000);

                        break;
                }

                return false;
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (timer!=null){
            timer.cancel();
            timer=null;
        }
    }

    private void loadImageData() {
        data = new ArrayList<>();
        imagedata = new ArrayList<>();
        RequestParams rp = new RequestParams(path1);
        final int width = getResources().getDisplayMetrics().widthPixels;
        x.http().get(rp, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                ImageBean imageBean = gson.fromJson(result, ImageBean.class);
                imagedata.addAll(imageBean.getData().getItem_recommend());
                for (int i = 0; i < imagedata.size(); i++) {
                    ImageView imageView = new ImageView(CityActivity.this);
                    data.add(imageView);
                }
                for (int i = 0; i < data.size(); i++) {
                    tv_vp.setText(imagedata.get(i).getTitle());
                    Picasso.with(CityActivity.this).load(imagedata.get(i).getMainImage()).resize(width, 450).into(data.get(i));

                    final int finalI = i;
                    data.get(i).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent=new Intent(CityActivity.this,WebViewActivity.class);
                            intent.putExtra("path",imagedata.get(finalI).getUrl());
                            startActivity(intent);
                        }
                    });
                }

                vp_adapter = new CityVpAdapter(CityActivity.this, data);
                vp_city.setAdapter(vp_adapter);
                setTimer();
                vp_city.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                      @Override
                      public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                      }

                      @Override
                      public void onPageSelected(int position) {
                          tv_vp.setText(imagedata.get(position).getTitle());
                      }

                      @Override
                      public void onPageScrollStateChanged(int state) {

                      }
                  });
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
