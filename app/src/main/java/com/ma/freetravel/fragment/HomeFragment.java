package com.ma.freetravel.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.ma.freetravel.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    private WebView mView;

    @Nullable
    @Override
    public WebView getView() {
        return mView;
    }

    private String path = "http://www.qiugonglue.com/api/v3/main/home_android_v3?client_version=6.0.1";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mView = (WebView) view.findViewById(R.id.webView);
        WebSettings settings = mView.getSettings();
        settings.setJavaScriptEnabled(true);

        mView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                String s = url.toString();
                if (!s.startsWith("board:")) {
                    view.loadUrl(url);
                    return super.shouldOverrideUrlLoading(view, url);
                }
                return true;
            }
        });
        mView.loadUrl(path);
        return view;
    }

}
