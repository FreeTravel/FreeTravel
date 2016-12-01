package com.ma.freetravel.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ma.freetravel.R;
import com.ma.freetravel.bean.AlumDetail;
import com.ma.freetravel.bean.MovieLv;
import com.ma.freetravel.url.Url;
import com.ma.freetravel.utils.FlagData;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.util.List;

/**
 * Created by tian on 2016/11/25.
 */

public class MovieLVAdapter<T> extends BaseListViewAdapter{
    private List<T> objects;
    private Context context;
    private String type;

    public MovieLVAdapter(List<T> data, Context context,String type) {
        super(data, context);
        this.objects = data;
        this.context = context;
        this.type=type;
    }


    @Override
    public View getItemView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = getInflater().inflate(R.layout.item_reclv_movie, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = ((ViewHolder) convertView.getTag());
        }
        if (type.equals(FlagData.FLAG_MOVIELV)){
            MovieLv movieLv = ((MovieLv) objects.get(position));
            int columnID = movieLv.getColumnID();
            Glide.with(context).load(Url.Head3 + movieLv.getPicURL()).into(holder.iv);
            if (columnID == 1) {
                holder.introduction_tv.setText(movieLv.getIntroduction());
                holder.shipin_iv.setVisibility(View.VISIBLE);
            } else {
                holder.introduction_tv.setText(movieLv.getTitle());
                holder.shipin_iv.setVisibility(View.GONE);
            }
            switch (columnID) {
                case 1:
                    holder.title_tv.setText(R.string.columnName1_movie);
                    break;
//                case 2:
//                    holder.title_tv.setText("[" + R.string.columnName2_movie + "]");
//                    break;
//                case 3:
//                    holder.title_tv.setText("[" + R.string.columnName3_movie + "]");
//                    break;
                case 4:
                    holder.title_tv.setText("[" + R.string.columnName4_movie + "]");
                    break;
                case 5:
                    holder.title_tv.setText("[" + R.string.columnName5_movie + "]");
                    break;
            }
        }else if (type.equals(FlagData.FLAG_MOVIEALBUMDETAIL)){
            AlumDetail alumDetail = (AlumDetail) objects.get(position);
            Picasso.with(context).load(Url.Head3+alumDetail.getPicURL())
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
                    .into(holder.iv);
            holder.title_tv.setText(alumDetail.getIntroduction());
            if (!TextUtils.isEmpty(alumDetail.getLinkUrl()))
                holder.shipin_iv.setVisibility(View.VISIBLE);
        }
        return convertView;
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
    public class ViewHolder {
        private ImageView iv;
        private ImageView shipin_iv;
        private TextView title_tv;
        private TextView introduction_tv;

        public ViewHolder(View itemView) {
            iv = ((ImageView) itemView.findViewById(R.id.iv_item_reclv));
            shipin_iv = ((ImageView) itemView.findViewById(R.id.shipin_iv_item_reclv));
            title_tv = ((TextView) itemView.findViewById(R.id.title_tv_item_reclv));
            introduction_tv = ((TextView) itemView.findViewById(R.id.introduction_tv_item_reclv));
        }
    }
}
