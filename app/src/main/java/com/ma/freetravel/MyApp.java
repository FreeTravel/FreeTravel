package com.ma.freetravel;

import android.app.Application;

import org.xutils.x;

/**
 * Created by 哈士奇爱吃苹果 on 2016/11/22.
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //全局初始化
        x.Ext.init(this);

    }
}
