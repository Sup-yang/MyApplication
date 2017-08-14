package com.example.yang.tabview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by yang on 2017/4/27.
 *
 * TabLayout的数据适配器
 */

public class TabAdapter extends FragmentPagerAdapter {

    String[] mTitle;//为显示的Fragment添加title
    List<Fragment> mFragments;//fragment 的集合，存储想要显示的Fragment

    //初始化数据
    public TabAdapter(FragmentManager fm,String[] title,List<Fragment> fragments) {
        super(fm);

        this.mTitle=title;
        this.mFragments=fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mTitle.length;
    }
    /**
     * 设置Tab导航条的标题
     * @param position 当前的Tab角标索引
     * @return  Tab导航条的标题
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle[position];
    }
}
