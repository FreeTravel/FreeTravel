package com.ma.freetravel.ui;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import com.ma.freetravel.MainActivity;
import com.ma.freetravel.R;

import java.util.Timer;
import java.util.TimerTask;

public class IntroduceActivity extends AppCompatActivity {

    private SurfaceView mSurfaceView;
    private MediaPlayer mPlayer;
    private SurfaceHolder mHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduce);
        ActionBar bar = getSupportActionBar();
        if (bar != null) {
            bar.hide();
        }
        initView();

    }

    private void initView() {
        mSurfaceView = (SurfaceView) findViewById(R.id.surfaceView);
        mHolder = mSurfaceView.getHolder();
        mPlayer = MediaPlayer.create(this, R.raw.welcome);
        //设置播放时打开屏幕
        mHolder.setKeepScreenOn(true);
        mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        mHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                play();
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });
    }

    private void play() {
        mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mPlayer.setDisplay(mHolder);
        int duration = mPlayer.getDuration();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(IntroduceActivity.this, MainActivity.class));
                finish();
            }
        }, duration+500);
        mPlayer.start();
    }

    public void btnClick(View view) {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    protected void onDestroy() {
        if (mPlayer.isPlaying())
            mPlayer.stop();
        mPlayer.release();
        super.onDestroy();
    }
}
