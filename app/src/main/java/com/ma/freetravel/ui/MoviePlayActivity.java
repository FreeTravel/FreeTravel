package com.ma.freetravel.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.ma.freetravel.R;

public class MoviePlayActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView title_toobar;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_play);
        initView();
    }

    private void initView() {
        String title = getIntent().getStringExtra("title");
        String linkUrl = getIntent().getStringExtra("linkUrl");
        toolbar = ((Toolbar) findViewById(R.id.toolBar_moviePlay));
        title_toobar = ((TextView) findViewById(R.id.title_toolbar));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.in_activity,R.anim.out_activity);
            }
        });
        webView = ((WebView) findViewById(R.id.webView_moviePlay));
        title_toobar.setText(title);
        webView.loadUrl(linkUrl);
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
