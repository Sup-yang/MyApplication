package baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.workordermanager;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yang on 2017/3/26.
 * 工单记录界面的适配器
 *
 */

public class RecordAdapter extends FragmentPagerAdapter {
    private String[] names={"已受理","已完成","已撤销"};//界面名称的数组
    List<Fragment> list=new ArrayList<>();//fragment的集合，用来存储fragment
    Context context;

    //初始化数据
    public RecordAdapter(FragmentManager fm,Context context) {
        super(fm);

        this.context=context;
        list.add(new OrderAcceptFragment());
        list.add(new OrderFinishFragment());
        list.add(new OrderRepealFragment());

    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return names[position];
    }
}
