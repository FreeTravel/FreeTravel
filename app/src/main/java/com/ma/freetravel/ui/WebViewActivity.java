package com.ma.freetravel.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebView;

import com.ma.freetravel.R;
import com.ma.freetravel.widget.WebViewClientUtils;

public class WebViewActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        webView = ((WebView) findViewById(R.id.webView_activity));
        Intent intent = getIntent();
        String source=intent.getStringExtra("path");
        //设置WebView属性，能够执行Javascript脚本
        webView.getSettings().setJavaScriptEnabled(true);
        //设置Web视图
        webView.setWebViewClient(new WebViewClientUtils());
        //加载需要显示的网页
        webView.loadUrl(source);
    }

    //覆盖Activity类的onKeyDown(int keyCoder,KeyEvent event)方法
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);

    }
}
