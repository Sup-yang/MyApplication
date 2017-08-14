package com.example.yang.tabview;

import android.content.res.Resources;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private TabLayout mTabLogin;
    private ViewPager mVPLogin;
    private String[] mTitle;
    private List<Fragment> fragments;
    TabAdapter tabAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();

    }

    private void initView() {
        mTabLogin= (TabLayout) findViewById(R.id.tl_login);

        //为tablayout标题title设置分割线
        LinearLayout linearLayout= (LinearLayout) mTabLogin.getChildAt(0);//插入位置

        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        linearLayout.setDividerDrawable(ContextCompat.getDrawable(this,R.drawable.divider_login));

        mVPLogin= (ViewPager) findViewById(R.id.log_vp);

        tabAdapter=new TabAdapter(getSupportFragmentManager(),mTitle,fragments);

        mTabLogin.post(new Runnable() {
            @Override
            public void run() {
                setIndicator(mTabLogin,30,30);
                //int属性代表距离左右的距离，数值越小，距离左右的距离越小
            }
        });
        mVPLogin.setAdapter(tabAdapter);
        mTabLogin.setupWithViewPager(mVPLogin);//完成TabLayout导航与ViewPager同步
    }

    private void initData() {
        mTitle=getResources().getStringArray(R.array.title);
        fragments=new ArrayList<>();
        LoginFragment first=new LoginFragment();
        RegistFragment sec=new RegistFragment();
        fragments.add(first);
        fragments.add(sec);

    }

    /**
     * tablayout 设置指示器长度
     * */
    public void setIndicator(TabLayout tabLayout,int leftDip,int rightDip){
        Class<?> tabLayouts=tabLayout.getClass();
        Field tabs=null;
        try {
            tabs=tabLayouts.getDeclaredField("mTabStrip");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        tabs.setAccessible(true);
        LinearLayout lltab=null;

        try {
            lltab= (LinearLayout) tabs.get(tabLayout);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        int left= (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,leftDip, Resources.getSystem().getDisplayMetrics());
        int right=(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,rightDip,Resources.getSystem().getDisplayMetrics());


        for (int i = 0; i < lltab.getChildCount(); i++) {
            View child=lltab.getChildAt(i);
            child.setPadding(0,0,0,0);
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.MATCH_PARENT,1);

            params.leftMargin=left;
            params.rightMargin=right;

            child.setLayoutParams(params);
            child.invalidate();
        }
    }
}
