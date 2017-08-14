package cn.wuxiaocheng.drawerlayout;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    private Toolbar toolbar;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mdrawerlayout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.id_toolbar);
        mdrawerlayout = (DrawerLayout) findViewById(R.id.id_drawer);

        toolbar.setTitle("DrawerLayout");       //设置标题
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));    //设置标题颜色
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //创建返回，实现打开和关闭菜单的监听
        mDrawerToggle = new ActionBarDrawerToggle(this, mdrawerlayout, toolbar, R.string.tv_open, R.string.tv_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawerToggle.syncState();
        mdrawerlayout.setDrawerListener(mDrawerToggle);
    }

}
