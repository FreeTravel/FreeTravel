package com.ma.freetravel.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bartoszlipinski.recyclerviewheader.RecyclerViewHeader;
import com.google.gson.Gson;
import com.ma.freetravel.R;
import com.ma.freetravel.adapter.BaseRecyclerAdapter;
import com.ma.freetravel.adapter.PlaceAdapter;
import com.ma.freetravel.bean.CountryBean;
import com.squareup.picasso.Picasso;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

public class CountryActivity extends AppCompatActivity {

    private ImageView iv_show;
    private TextView tvcn;
    private TextView tven;
    private RecyclerView recyclerView;
    private PlaceAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);

        initView();
        initData();
        initManger();
        initListener();
    }

    private void initListener() {
        adapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, Object data) {

                Intent intent=new Intent(CountryActivity.this,CityActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initData() {
        adapter=new PlaceAdapter(CountryActivity.this);
        RequestParams params=new RequestParams("http://www.qiugonglue.com/api/v3/place/country_index?client_name=QGLMain&client_version=6.0.1&country_id=4003&os_version=17&platform=android&screen_size=720x1280&tm=1479731903164&uuid=133524328529283&sign=b0434bae85c76bebb565cd082f9262a3" );
        x.http().get(params, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {
                Gson gson=new Gson();
                CountryBean countrybean=gson.fromJson(result,CountryBean.class);
                List<CountryBean.DataBean.CityListBean> city_list = countrybean.getData().getCity_list();
                adapter.addDatas(city_list);

                CountryBean.DataBean.CountryInfoBean country_info = countrybean.getData().getCountry_info();

                Picasso.with(CountryActivity.this).load(country_info.getCover_image()).into(iv_show);
                tvcn.setText(country_info.getPlace_name());
                tven.setText(country_info.getPlace_name_en());


            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

                Log.e("ssss","++++"+"error");
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    private void initManger() {
        recyclerView.setAdapter(adapter);
        GridLayoutManager gridlayoutManager = new GridLayoutManager(this, 3);
        gridlayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridlayoutManager);
        initHead();
    }

    private void initHead() {
        RecyclerViewHeader header=RecyclerViewHeader.fromXml(CountryActivity.this,R.layout.country_head_item);
        iv_show = ((ImageView) header.findViewById(R.id.country_iv));
        tvcn = ((TextView)header.findViewById(R.id.tvcn_country));
        tven = ((TextView)header.findViewById(R.id.tven_country));
        header.attachTo(recyclerView);
    }

    private void initView() {
        recyclerView = ((RecyclerView) findViewById(R.id.recyclev_country));
    }
}
