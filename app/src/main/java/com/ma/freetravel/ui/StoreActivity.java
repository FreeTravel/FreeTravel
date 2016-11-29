package com.ma.freetravel.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ma.freetravel.R;

public class StoreActivity extends AppCompatActivity {

    String path="http://www.qiugonglue.com/api/v3/pin/detail?board_id=525&client_name=QGLMain&client_version=6.0.1&current_client_name=Paris&os_version=17&pin_id=7081&platform=android&screen_size=720x1280&tm=1480385661505&uuid=133524230269622&sign=4b13e08a320f96da1cd6f7113e312e1a";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
    }
}
