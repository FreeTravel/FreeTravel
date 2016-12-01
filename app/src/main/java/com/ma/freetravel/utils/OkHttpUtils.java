package com.ma.freetravel.utils;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.ma.freetravel.jiekou.ICustom;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by tian on 2016/11/24.
 */

public class OkHttpUtils {
    public static final String TAG = "OkHttpUtils";
    private Handler handler = new Handler();

    private ICustom iCustom;
    private Object object;

    public OkHttpUtils(Object object, ICustom iCustom) {
        this.object = object;
        this.iCustom = iCustom;
    }

    public void loadData(final String path) {
        final OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(path)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                iCustom.handleActionError("网络有异常" + e.toString(), "");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String str = response.body().string();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (str != null) {
                            if (object.equals(FlagData.FLAG_MOVIEBANNER)) {
                                iCustom.handleActionSuccess(str, object);
                            } else if (object.equals(FlagData.FLAG_MOVIELV)) {
                                iCustom.handleActionSuccess(str, object);
                            }else if (object.equals(FlagData.FLAG_MOVIEALBUM)){
                                iCustom.handleActionSuccess(str,object);
                            }else if (object.equals(FlagData.FLAG_MOVIEALBUMDETAIL)){
                                iCustom.handleActionSuccess(str,object);
                            }
                        } else {
                            Log.e(TAG, "未请求到数据 ");
                        }
                    }
                });


            }
        });
    }
}
