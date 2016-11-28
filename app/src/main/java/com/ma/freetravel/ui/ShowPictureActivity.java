package com.ma.freetravel.ui;

import android.animation.Animator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

import com.ma.freetravel.R;
import com.ma.freetravel.bean.Picture;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class ShowPictureActivity extends Activity {

    private Picture mPicture;
    private ImageView mView;
    private float mScaleX;
    private float mScaleY;
    private float mDeltaX;
    private float mDeltaY;
    private float src_width,src_height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_picture);
        mView = (ImageView) findViewById(R.id.img_show);
        src_height = getResources().getDisplayMetrics().heightPixels;
        src_width = getResources().getDisplayMetrics().widthPixels;
        Intent intent = getIntent();
        if (intent != null) {
            mPicture = (Picture) intent.getSerializableExtra("params");
            if (mPicture != null) {
                float scale = getSale(mPicture.getRealWidth(),mPicture.getRealHeight());
                Log.e("ShowPictureActivity", "scale:" + scale);
                Picasso.with(this)
                        .load(mPicture.getUrl())
                        .resize((int) (mPicture.getRealWidth()*scale), (int) (mPicture.getRealHeight()*scale))
                        .into(mView, new Callback() {
                            @Override
                            public void onSuccess() {
                                onUIReady();
                            }

                            @Override
                            public void onError() {

                            }
                        });
                mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        runExitAnimation();
                    }
                });
            }
        }


    }

    private float getSale(int width, int height) {
        float scaleW = src_width/width;
        float scaleH = src_height/height;

        return scaleH>scaleW?scaleW:scaleH;
    }

    private void onUIReady() {
        mView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                // remove previous listener
                mView.getViewTreeObserver().removeOnPreDrawListener(this);
                // prep the scene
                prepareScene();
                // run the animation
                runEnterAnimation();
                return true;
            }
        });
    }

    private void prepareScene() {
        int[] screenLocation = new int[2];
        //缩放到起始view大小
        mScaleX = mPicture.getOriWidth() / mView.getWidth();
        mScaleY = mPicture.getOriHeight() / mView.getHeight();
        mView.setScaleX(mScaleX);
        mView.setScaleY(mScaleY);

        mView.getLocationOnScreen(screenLocation);
        //移动到起始view位置
        mDeltaX = mPicture.getX() - screenLocation[0];
        mDeltaY = mPicture.getY() - screenLocation[1];
        mView.setTranslationX(mDeltaX);
        mView.setTranslationY(mDeltaY);
    }

    private void runEnterAnimation() {
        mView.setVisibility(View.VISIBLE);
        //获取图片的颜色，设置背景色
        //执行动画
        mView.animate()
                .setDuration(500)
                .setInterpolator(new DecelerateInterpolator())
                .scaleX(1f)
                .scaleY(1f)
                .translationX(0)
                .translationY(0)
                .start();
    }

    private void runExitAnimation() {
        ViewPropertyAnimator animator = mView.animate()
                .setDuration(300)
                .setInterpolator(new AccelerateInterpolator())
                .scaleX(mScaleX)
                .scaleY(mScaleY)
                .translationX(mDeltaX)
                .translationY(mDeltaY);
        animator.start();
        animator.setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                ShowPictureActivity.this.finish();
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            runExitAnimation();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}
