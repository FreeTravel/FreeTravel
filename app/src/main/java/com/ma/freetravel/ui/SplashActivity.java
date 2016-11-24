package com.ma.freetravel.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.ma.freetravel.MainActivity;
import com.ma.freetravel.R;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    private SharedPreferences mPreferences;
    private boolean isFirst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initData();

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if (isFirst) {
                    //进入引导页
                    startActivity(new Intent(SplashActivity.this, IntroduceActivity.class));
                    mPreferences.edit().putBoolean("isFirst",false).apply();
                    finish();
                } else {
                    //进入主页面
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                }
            }
        }, 2000);

    }

    private void initData() {
        ActionBar bar = getSupportActionBar();
        if (bar != null) {
            bar.hide();
        }
        mPreferences = getSharedPreferences("config", Context.MODE_PRIVATE);
        isFirst = mPreferences.getBoolean("isFirst", true);//是否是第一次使用本应用
    }
}
