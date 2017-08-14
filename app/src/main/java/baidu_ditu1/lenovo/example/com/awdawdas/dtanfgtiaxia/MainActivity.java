package baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.AroundFragment;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.CaifuFragment;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.ShengShiFragment;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.gerenshezhi.SetFragment;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.utils.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 主界面
 */

public class MainActivity extends BaseActivity {
   //butterknife绑定控件
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.btnShengshi)
    Button btnShengShi;
    @BindView(R.id.btnTreasure)
    Button btnTreasure;
    @BindView(R.id.btnSet)
    Button btnSet;
    @BindView(R.id.btnAround)
    Button btnAround;

    private Unbinder unbinder;
    @BindView(R.id.first)
    TextView textView;
    @BindView(R.id.toolBar)
    Toolbar toolbar;

    public  static boolean isdenlu;
    private View view;

    public static Activity main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main=this;
        initView();//初始化视图

    }
        //初始化视图控件
    private void initView() {
        unbinder = ButterKnife.bind(this);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(listener);


        //首次进入首页
        btnShengShi.setSelected(true);


    }

    //view的适配器：使用的是自带的fragment适配器
    private FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    //跳转到第一个界面

                    return new ShengShiFragment();
                case 1:
                    //跳转到第二个界面

                    return new AroundFragment();
                case 2:
                    //跳转到第三个界面

                    return new CaifuFragment();
                case 3:
                    //跳转到第4个界面
                    return new SetFragment();
                default:
                    throw new RuntimeException("未知错误");
            }

        }
        @Override
        public int getCount() {
            //一共4页
            return 4;
        }
    };
    //view的监听 button 的切换
    private ViewPager.OnPageChangeListener listener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

               //button ui改变
            btnShengShi.setSelected(position==0);
            btnAround.setSelected(position==1);
            btnTreasure.setSelected(position==2);
            btnSet.setSelected(position==3);

            btnShengShi.setBackgroundResource(R.drawable.syt_02);
            btnAround.setBackgroundResource(R.drawable.syt_03);
            btnTreasure.setBackgroundResource(R.drawable.syt_04);
            btnSet.setBackgroundResource(R.drawable.syt_05);

            //设置toolbar字体
            switch (position) {

                case 0:

                    btnShengShi.setBackgroundResource(R.drawable.sytb_02);
                    textView.setText("首页");
                   // btnShengShi.setSelected(true);

                    break;
                case 1:
                    btnAround.setBackgroundResource(R.drawable.sytb_05);
                    textView.setText("视频");
                    break;
                case 2:
                    btnTreasure.setBackgroundResource(R.drawable.sytb_03);
                    textView.setText("财富");
                    //btnTreasure.setSelected(position==1);
                    break;

                case 3:
                    btnSet.setBackgroundResource(R.drawable.sytb_04);
                    textView.setText("个人中心");
                    //btnSet.setSelected(true);
                    break;


            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        };

};

//设置button的监听事件
    @OnClick({R.id.btnShengshi,R.id.btnTreasure,R.id.btnSet, R.id.btnAround})
    public void chooseFragment(Button button){
        switch (button.getId()){

            case R.id.btnShengshi:
                //不要平滑效果，第二参数传false
                viewPager.setCurrentItem(0, false);
                break;
            case R.id.btnAround:

                viewPager.setCurrentItem(1, false);

                break;
            case R.id.btnTreasure:

                viewPager.setCurrentItem(2, false);

                break;
            case R.id.btnSet:

                viewPager.setCurrentItem(3, false);

                break;
        }
    }

    //解绑butterknife
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    public void show(){
        this.finish();
    }


    @Override
    protected void onResume() {
        SharedPreferences spf = getSharedPreferences("dataa", MODE_PRIVATE);
        isdenlu= spf.getBoolean("denlu",false);
        super.onResume();

    }
}