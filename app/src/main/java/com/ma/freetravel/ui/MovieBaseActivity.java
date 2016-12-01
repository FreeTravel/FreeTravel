package com.ma.freetravel.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.ma.freetravel.R;

public  abstract class MovieBaseActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView title_tv;
    private int id;
    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_base);
        initView();

    }

    private void initView() {
        toolbar = ((Toolbar) findViewById(R.id.toolbar_movieBase));
        title_tv = ((TextView) findViewById(R.id.title_activity));
        toolbar.dismissPopupMenus();
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public  void setData(int id,String title){
        toolbar.setNavigationIcon(id);
        title_tv.setText(title);
    }
}
