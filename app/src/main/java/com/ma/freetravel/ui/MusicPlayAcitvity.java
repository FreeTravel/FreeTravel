package com.ma.freetravel.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.ma.freetravel.R;

public class MusicPlayAcitvity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView title_toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_play_acitvity);
        toolbar = ((Toolbar) findViewById(R.id.toolBar_movieMusic));
        title_toolbar = ((TextView) findViewById(R.id.title_activity));
        toolbar.dismissPopupMenus();
        toolbar.setNavigationIcon(R.mipmap.icon_back);
        title_toolbar.setText("电影原声");
        toolbar.dismissPopupMenus();
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        WebView webView = (WebView) findViewById(R.id.webView_musicPLay);
        String musicPath = getIntent().getStringExtra("musicPath");
        webView.loadUrl(musicPath);
        //覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }
        });

    }
}
