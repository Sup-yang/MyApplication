package com.example.yang.mydemodrawer;

import android.graphics.Color;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ActionBarDrawerToggle drawerToggle;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        toolbar= (Toolbar) findViewById(R.id.id_toolbar);
        drawerLayout= (DrawerLayout) findViewById(R.id.id_drawer);
        toolbar.setTitle("DrawerLayout");
        toolbar.setTitleTextColor(Color.RED);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);//设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //创建返回，实现打开和关闭菜单的监听

        drawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.tv_open,R.string.tv_close){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };

        drawerToggle.syncState();
        drawerLayout.setDrawerListener(drawerToggle);
    }
}
