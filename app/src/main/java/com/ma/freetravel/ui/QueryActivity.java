package com.ma.freetravel.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.ma.freetravel.R;
import com.ma.freetravel.adapter.QueryAdapter;
import com.ma.freetravel.bean.QueryBean;
import com.ma.freetravel.url.Url;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class QueryActivity extends AppCompatActivity {

    String path="http://www.qiugonglue.com/api/v3/search/%E6%B5%8E%E5%8D%97?client_name=QGLMain&client_version=6.0.1&os_version=17&platform=android&screen_size=720x1280&tm=1479969021228&uuid=133524654038404&sign=af67b548d963949f798f481962d675f8";
    private RecyclerView recyclerView;

    private List<Integer> list;
    private List<QueryBean> queryBeen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);
        initView();
        initData();


    }

    private void initManger() {
        //线性布局管理器   ListView 效果  获取横向的ListVIew
        LinearLayoutManager linearlayoutManager = new LinearLayoutManager(QueryActivity.this);
        //设置布局的方向
        linearlayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearlayoutManager);
    }

    private void initData() {
        String city = getIntent().getStringExtra("city");
        list=new ArrayList<>();
        queryBeen=new ArrayList<>();
        RequestParams params=new RequestParams(Url.queryPath(city));
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson=new Gson();
                QueryBean queryBeans = gson.fromJson(result, QueryBean.class);
                //queryBeen.add(queryBeans);
                for (int i = 0; i < 4; i++) {
                    list.add(i);
                }
                recyclerView.setAdapter(new QueryAdapter(queryBeans,QueryActivity.this,list));
                initManger();

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

    private void initView() {
        recyclerView = ((RecyclerView) findViewById(R.id.query_recycleview));
    }
}
