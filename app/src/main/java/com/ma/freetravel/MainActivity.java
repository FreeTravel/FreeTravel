package com.ma.freetravel;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.ma.freetravel.fragment.BournFragment;
import com.ma.freetravel.fragment.DynamicFragment;
import com.ma.freetravel.fragment.HomeFragment;
import com.ma.freetravel.fragment.MovieFragment;
import com.ma.freetravel.ui.CountryActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private Toolbar toolbar;


    private RadioGroup rg;
    private FrameLayout container;
    private HomeFragment homeFragment;
    private BournFragment bournFragment;
    private DynamicFragment dynamicFragment;
    private MovieFragment movieFragment;
    private boolean isFirstPage = true;
    private long currentTime = 0;
    //存Fragment数据的
    private List<Fragment> fragmentList = new ArrayList<>();

    //当前展示的Fragment的位置
    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        //获取Fragment的集合内容
        initFragment();
        rg.setOnCheckedChangeListener(this);

        mDrawerLayout = ((DrawerLayout) findViewById(R.id.drawlayout));
        mNavigationView = ((NavigationView) findViewById(R.id.id_nv_menu));
        toolbar = ((Toolbar) findViewById(R.id.toolbar));
        toolbar.setTitle("AAAAAAAAAAAAAAAA");

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                MainActivity.this
                ,mDrawerLayout
                ,toolbar
                ,R.string.app_close
                ,R.string.app_open
        );

        //ActionBarDrawerToggle与drawerLayout状态同步
        toggle.syncState();
        //drawerLayout绑定toggle
        mDrawerLayout.addDrawerListener(toggle);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:
                        Intent intent=new Intent(MainActivity.this,CountryActivity.class);
                        startActivity(intent);
                }
                return false;
            }
        });

//        getSupportActionBar().hide();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_navigation_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId() == android.R.id.home)
        {
            mDrawerLayout.openDrawer(GravityCompat.START);
            return true ;
        }
        return super.onOptionsItemSelected(item);
    }
    private void initFragment() {
        homeFragment = new HomeFragment();
        bournFragment = new BournFragment();
        dynamicFragment = new DynamicFragment();
        movieFragment = new MovieFragment();
        fragmentList.add(homeFragment);
        fragmentList.add(bournFragment);
        fragmentList.add(dynamicFragment);
        fragmentList.add(movieFragment);
        //设置默认显示的Fragment
        getSupportFragmentManager().beginTransaction().add(R.id.container_main, fragmentList.get(0)).commit();

    }

    private void initview() {
        rg = ((RadioGroup) findViewById(R.id.rg));
        container = ((FrameLayout) findViewById(R.id.container_main));

    }



    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_home:
                //替换模块  fragment
                switchFragmet(0);
                break;
            case R.id.rb_search:
                switchFragmet(1);
                break;
            case R.id.rb_request:
                switchFragmet(2);
                break;
            case R.id.rb_setting:
                switchFragmet(3);
                break;
        }
    }

    private void switchFragmet(int targetIndex) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //将要显示的Fragment
        Fragment fragment = fragmentList.get(targetIndex);
        //获取当前显示的Fragment
        Fragment currentFragment = fragmentList.get(currentIndex);
        if (fragment.isAdded()) {
            transaction.show(fragment).hide(currentFragment).commit();
        } else {
            transaction.add(R.id.container_main, fragment).hide(currentFragment).commit();
        }
        //显示后将要显示的Fragment的下标给当前的下标
        currentIndex = targetIndex;
        if (targetIndex == 0) {
            isFirstPage = true;
        } else {
            isFirstPage = false;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (isFirstPage && ((HomeFragment) fragmentList.get(0)).getView().canGoBack()) {
                ((HomeFragment) fragmentList.get(0)).getView().goBack();
            } else {
                exit();
            }

            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    private void exit() {
        long millis = System.currentTimeMillis();
        if (millis - currentTime > 2000) {
            Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
            currentTime = millis;
        } else {
            finish();
        }
    }
}
