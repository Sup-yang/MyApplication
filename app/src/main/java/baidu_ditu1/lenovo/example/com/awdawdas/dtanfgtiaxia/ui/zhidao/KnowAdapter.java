package baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.zhidao;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yang on 2017/3/25.
 * 知道界面的适配器
 *
 */

public class KnowAdapter extends FragmentPagerAdapter {
//继承自Fragmentpageradapter
    //public final int COUNT=4;

    List<Fragment> fragmentList=new ArrayList<>();//fragment的集合

    private  String [] titles=new String[]{"官方公告","平台规则","处罚通知","系统更新"};
    private Context context;

    //构造方法用来初始化
    public KnowAdapter(FragmentManager fm,Context context) {
        super(fm);
        this.context=context;
        fragmentList.add(new GuanFangFragment());
        fragmentList.add(new PingTaFragment());
        fragmentList.add(new ChuFaFragment());
        fragmentList.add(new UpdateFragment());

    }

    //fragment的位置
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    //数量
    @Override
    public int getCount() {
        return fragmentList.size();
    }

    //名称
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
