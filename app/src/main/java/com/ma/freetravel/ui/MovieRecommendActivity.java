package com.ma.freetravel.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.ma.freetravel.R;
import com.ma.freetravel.bean.AlumDetail;
import com.ma.freetravel.url.Url;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.io.Serializable;

public class MovieRecommendActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private ImageView pic_iv;
    private ImageView play_in;
    private ImageView collect_iv;
    private TextView title_content;
    private TextView title_toolbar;
    private ImageView image1_iv;
    private ImageView image2_iv;
    private ImageView imag3_iv;
    private TextView content_tv;
    private ImageView dianzan_iv;
    private ImageView share_iv;
    private AlumDetail alumDetail;
    private TextView type_tv;
    private WebView webView;
    private TextView introduction_tv;
    private ImageView back_iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_recommend);
        init();
        setData();
    }

    private void setData() {
        Picasso.with(this).load(Url.Head3+alumDetail.getPicURL())
                .transform(new Transformation() {
                    @Override
                    public Bitmap transform(Bitmap source) {
                        Bitmap bitmap = toRoundBitmap(source);
                        if (source!=bitmap){
                            source.recycle();
                        }
                        return bitmap;
                    }

                    @Override
                    public String key() {
                        return "aa";
                    }
                })
                .into(pic_iv);
        title_content.setText(alumDetail.getTitle());
        type_tv.setText("类型："+alumDetail.getLabelIDS());
        introduction_tv.setText(alumDetail.getIntroduction());
        String content = alumDetail.getContent();
        content = content.replace("<img src=\"/","<img src=\""+Url.Head3).replace("<p>","<p style='font-size:18px'>");
        webView.loadDataWithBaseURL(null, content, "text/html", "utf-8",
                null);    }

    private void init() {
        Serializable serializable = getIntent().getSerializableExtra("movieLv");
        alumDetail = (AlumDetail) getIntent().getSerializableExtra("alumDetail");
        toolbar = ((Toolbar) findViewById(R.id.toolBar_movieRecommend));
        title_toolbar = ((TextView) findViewById(R.id.title_toolbar));
        back_iv = ((ImageView) findViewById(R.id.back));
        toolbar.setNavigationIcon(R.mipmap.icon_back);
        title_toolbar.setText("电影推荐");
        toolbar.dismissPopupMenus();
        setSupportActionBar(toolbar);
        back_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.in2_activity,R.anim.out2_activity);
            }
        });
        pic_iv = ((ImageView) findViewById(R.id.pic_movieRecommend));
        title_content = ((TextView) findViewById(R.id.title_movieRecommend));
        type_tv = ((TextView) findViewById(R.id.labelIDS_movieRecommend));
        play_in = ((ImageView) findViewById(R.id.play_iv));
        collect_iv = ((ImageView) findViewById(R.id.collect_iv));
        introduction_tv = ((TextView) findViewById(R.id.title_tv));
        webView = ((WebView) findViewById(R.id.webView_movieRecommend));
//        image1_iv = ((ImageView) findViewById(R.id.image1_iv));
//        image2_iv = ((ImageView) findViewById(R.id.image2_iv));
//        imag3_iv = ((ImageView) findViewById(R.id.image3_iv));
//        content_tv = ((TextView) findViewById(R.id.content_tv));
        dianzan_iv = ((ImageView) findViewById(R.id.dianzan_iv));
        share_iv = ((ImageView) findViewById(R.id.share_iv));
        play_in.setOnClickListener(this);
    }
    public Bitmap toRoundBitmap(Bitmap bitmap) {
        //圆形图片宽高
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        //正方形的边长
        int r = 0;
        //取最短边做边长
        if(width > height) {
            r = height;
        } else {
            r = width;
        }
        //构建一个bitmap
        Bitmap backgroundBmp = Bitmap.createBitmap(width,
                height, Bitmap.Config.ARGB_8888);
        //new一个Canvas，在backgroundBmp上画图
        Canvas canvas = new Canvas(backgroundBmp);
        Paint paint = new Paint();
        //设置边缘光滑，去掉锯齿
        paint.setAntiAlias(true);
        //宽高相等，即正方形
        RectF rect = new RectF(0, 0, r, r);
        //通过制定的rect画一个圆角矩形，当圆角X轴方向的半径等于Y轴方向的半径时，
        //且都等于r/2时，画出来的圆角矩形就是圆形
        canvas.drawRoundRect(rect, r/2, r/2, paint);
        //设置当两个图形相交时的模式，SRC_IN为取SRC图形相交的部分，多余的将被去掉
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        //canvas将bitmap画在backgroundBmp上
        canvas.drawBitmap(bitmap, null, rect, paint);
        //返回已经绘画好的backgroundBmp
        return backgroundBmp;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.play_iv:
                Intent intent=new Intent(this,MoviePlayActivity.class);
                String linkUrl = alumDetail.getLinkUrl();
                String title = alumDetail.getTitle();
                intent.putExtra("title",title);
                intent.putExtra("linkUrl",linkUrl);
                startActivity(intent);
                break;
            case R.id.collect_iv:
                break;
            case R.id.dianzan_iv:
                break;
            case R.id.share_iv:
                break;
        }
    }
}
