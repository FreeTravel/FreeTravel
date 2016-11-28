package com.ma.freetravel.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.model.CameraPosition;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.Marker;
import com.amap.api.maps2d.model.MarkerOptions;
import com.ma.freetravel.R;

public class MapActivity extends AppCompatActivity {

    private AMap aMap;//定义一个地图对象
    private MapView mMapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        //定义了一个地图view
        mMapView = (MapView) findViewById(R.id.map);

        mMapView.onCreate(savedInstanceState);// 此方法必须重写
        //初始化地图变量
        if (aMap == null) {
            aMap = mMapView.getMap();
            aMap.setMapType(AMap.MAP_TYPE_NORMAL);

            Intent intent = getIntent();
            float lat = 116.397972f;
            float lon = 39.906901f;
            String title = "北京";
            if (intent != null) {
                lon = Float.parseFloat(intent.getStringExtra("lon"));
                lat = Float.parseFloat(intent.getStringExtra("lat"));
                title = intent.getStringExtra("title");
            }
            LatLng latLng = new LatLng(lat, lon);
            aMap.moveCamera(CameraUpdateFactory
                    .newCameraPosition(new CameraPosition(
                            latLng,
                            9,
                            0, 0
                    )));
            final Marker marker = aMap.addMarker(new MarkerOptions().
                    position(latLng).
                    title(title));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView.onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView.onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //在activity执行onSaveInstanceState时执行mMapView.onSaveInstanceState (outState)，实现地图生命周期管理
        mMapView.onSaveInstanceState(outState);
    }
}
