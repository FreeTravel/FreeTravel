package com.ma.freetravel.widget;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 *
 * Created by Administrator on 2016/11/7.
 */

public class WebViewClientUtils extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }
}
