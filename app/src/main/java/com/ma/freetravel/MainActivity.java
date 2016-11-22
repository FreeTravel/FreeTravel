package com.ma.freetravel;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.ma.freetravel.fragment.BournFragment;
import com.ma.freetravel.fragment.DynamicFragment;
import com.ma.freetravel.fragment.HomeFragment;
import com.ma.freetravel.fragment.MovieFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{

    private RadioGroup rg;
    private FrameLayout container;
    private HomeFragment homeFragment;
    private BournFragment bournFragment;
    private DynamicFragment dynamicFragment;
    private MovieFragment movieFragment;
    //存Fragment数据的
    private List<Fragment> fragmentList =  new ArrayList<>();

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
    }

    private void initFragment() {
        homeFragment=new HomeFragment();
        bournFragment=new BournFragment();
        dynamicFragment=new DynamicFragment();
        movieFragment=new MovieFragment();
        fragmentList.add(homeFragment);
        fragmentList.add(bournFragment);
        fragmentList.add(dynamicFragment);
        fragmentList.add(movieFragment);
        //设置默认显示的Fragment
        getSupportFragmentManager().beginTransaction().add(R.id.container_main,fragmentList.get(0)).commit();

    }

    private void initview() {
        rg = ((RadioGroup) findViewById(R.id.rg));
        container = ((FrameLayout) findViewById(R.id.container_main));

    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
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
        if (fragment.isAdded()){
            transaction.show(fragment).hide(currentFragment).commit();
        }else {
            transaction.add(R.id.container_main,fragment).hide(currentFragment).commit();
        }
        //显示后将要显示的Fragment的下标给当前的下标
        currentIndex=targetIndex;
    }

}
