package com.ma.freetravel;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ma.freetravel.fragment.BournFragment;
import com.ma.freetravel.fragment.DynamicFragment;
import com.ma.freetravel.fragment.HomeFragment;
import com.ma.freetravel.fragment.MoiveFragment2;
import com.ma.freetravel.ui.LocationActivity;
import com.ma.freetravel.ui.UserImageActivity;
import com.ma.freetravel.widget.CircleImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private Toolbar toolbar;
    public static CircleImageView useriv;
    private FrameLayout container;
    private HomeFragment homeFragment;
    private BournFragment bournFragment;
    private DynamicFragment dynamicFragment;
    private MoiveFragment2 movieFragment;
    private boolean isFirstPage = true;
    private long currentTime = 0;
    //存Fragment数据的
    private List<Fragment> fragmentList = new ArrayList<>();

    //当前展示的Fragment的位置
    private int currentIndex = 0;
    private ViewPager vp_main;
    private SharedPreferences sharedPreferences;

    public static TextView tv_link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        //获取Fragment的集合内容
        initFragment();
        initDrawer();
    }

    private void initDrawer() {
        toolbar.setTitle("自由行");
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

        setUserInformation();

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:
                        //vp_main.setCurrentItem(0);
                        switchFragmet(0);
                        break;
                    case R.id.nav_messages:
                       // vp_main.setCurrentItem(1);
                        switchFragmet(1);
                        break;
                    case R.id.nav_friends:
                        //vp_main.setCurrentItem(2);
                        switchFragmet(2);
                        break;
                    case R.id.nav_discussion:
                        //vp_main.setCurrentItem(3);
                       switchFragmet(3);
                        break;
                    case R.id.collection:
                        Intent intent=new Intent(MainActivity.this, UserImageActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.clean:
                        // dilog();
                        break;
                    //用户头像设置
//                    case R.id.user_iv:
//                        Intent intent1=new Intent(MainActivity.this,UserImageActivity.class);
//                        startActivity(intent1);
//                        break;

                }
                //关上抽屉
                mDrawerLayout.closeDrawer(Gravity.LEFT);
                return false;
            }
        });
    }

    private void setUserInformation() {
        useriv= (CircleImageView) mNavigationView.getHeaderView(0).findViewById(R.id.user_iv);
        useriv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(MainActivity.this,UserImageActivity.class);
                startActivity(intent1);
            }
        });

//        sharedPreferences=getSharedPreferences("useriv",MainActivity.MODE_PRIVATE);
//        startActivityharedPreferences.edit().put
        tv_link= (TextView) mNavigationView.getHeaderView(0).findViewById(R.id.id_link);
        tv_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LocationActivity.class));
            }
        });


    }

/*    private void dilog() {
        SweetAlertDialog pDialog = new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                pDialog.setTitleText("确认删除吗")
                .setContentText("删除后将不可恢复")
                .setConfirmText("Yes")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        //执行删除工作
                        sDialog.dismissWithAnimation();
                    }
                })
                .show();
    }*/

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
        movieFragment = new MoiveFragment2();
        fragmentList.add(homeFragment);
        fragmentList.add(bournFragment);
        fragmentList.add(dynamicFragment);
        fragmentList.add(movieFragment);
        //设置默认显示的Fragment
        getSupportFragmentManager().beginTransaction().add(R.id.container_main, fragmentList.get(0)).commit();

    }

    private void initview() {
        container = ((FrameLayout) findViewById(R.id.container_main));
       //vp_main = ((ViewPager) findViewById(R.id.vp_main));
        mDrawerLayout = ((DrawerLayout) findViewById(R.id.drawlayout));
        mNavigationView = ((NavigationView) findViewById(R.id.id_nv_menu));
        toolbar = ((Toolbar) findViewById(R.id.toolbar));
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

    class MyAdapter extends FragmentStatePagerAdapter {


        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int arg0) {
            // TODO Auto-generated method stub
            return fragmentList.get(arg0);
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return fragmentList!= null?fragmentList.size():0;
        }


    }
}
