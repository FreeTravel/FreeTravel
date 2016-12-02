package com.ma.freetravel.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.ma.freetravel.R;
import com.ma.freetravel.bean.MovieLv;
import com.ma.freetravel.url.Url;
import com.ma.freetravel.widget.MyListView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

public class MovieMusicActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView title_tv;
    private Toolbar toolbar;
    private ImageView pic_iv;
    private WebView webView;
    private ImageView collect_iv;
    private ImageView share_iv;
    private ImageView dianzan_iv;
    private MyListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_music);
        initView();

    }

    private void initView() {
        MovieLv movieLv = (MovieLv) getIntent().getSerializableExtra("movieLv");
        toolbar = ((Toolbar) findViewById(R.id.toolBar_movieMusic));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.in2_activity, R.anim.out_activity);
            }
        });
        lv = ((MyListView) findViewById(R.id.lv_moviemusic));
        pic_iv = ((ImageView) findViewById(R.id.pic_movieMusic));
        title_tv = ((TextView) findViewById(R.id.title_movieMusic));
        webView = ((WebView) findViewById(R.id.webView_movieMusic));
        collect_iv = ((ImageView) findViewById(R.id.collect_iv));
        share_iv = ((ImageView) findViewById(R.id.share_iv));
        dianzan_iv = ((ImageView) findViewById(R.id.dianzan_iv));
        collect_iv.setOnClickListener(this);
        Picasso.with(this).load(Url.Head3+movieLv.getPicURL())
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
        title_tv.setText(movieLv.getTitle());
        String content = movieLv.getContent();
        String[] urls = content.replace("<>",",").replace("{}",",").split(",");
        StringBuffer sb = new StringBuffer("<table style='width:100%'>");
//        for(int i=0;i<urls.length;i++){
//            if(i%2==0){
//                sb.append("<tr><td>").append(urls[i]).append("</td>");
//            }else{
//                sb.append("<td>").append("<a href='").append(urls[i]).append("'><img src='http://img.zcool.cn/community/017e0657c3f07a0000012e7ec0700a.jpg' width='30px'></a>").append("</td></tr>");
//            }
//        }
//        sb.append("</table>");
//        webView.loadDataWithBaseURL(null, sb.toString(), "text/html", "utf-8",null);

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
        switch (v.getId()) {
            case R.id.collect_iv:
                break;
            case R.id.share_iv:
                break;
            case R.id.dianzan_iv:
                break;
        }
    }
}
