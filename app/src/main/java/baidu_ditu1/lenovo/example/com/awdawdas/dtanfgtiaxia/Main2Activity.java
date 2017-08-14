package baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.ActionMenuView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;

import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.toolbar.Toolbar_putong;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.Mc.FiveFragment;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.Mc.FourFragment;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.Mc.OneFragment;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.Mc.SevenFragment;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.Mc.SixFragment;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.Mc.ThreeFragment;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.Mc.TwoFragment;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.Shezhi_Fragment;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.Wode_Zhanghu_yueFragment;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.Yenhang_LIebiao_Fragment;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.Zhuanzhang_jiluFragment;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.caifu.JiFenFragment;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.caifu.JingBiFragment;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.caifu.TiXianFragment;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.denlu_xiangguan.DenLuFragment;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.denlu_xiangguan.WangJiMiMa;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.denlu_xiangguan.ZhuCeFragment;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.renzhen_zhongxing.GeRen_RenZhenFragment;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.set.YongHuFanKuiFragment;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.workordermanager.OrderAcceptFragment;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.zhuye.RenZhenZhongXingFragment;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.zhuye.ZiXunFragment;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.utils.BaseActivity;
import butterknife.ButterKnife;


public class Main2Activity extends BaseActivity implements View.OnClickListener {

    //设置界面
    Shezhi_Fragment fragment;
    //用户反馈界面
    YongHuFanKuiFragment yongHuFanKuiFragment=YongHuFanKuiFragment.newiniter();
    //转账记录
    Zhuanzhang_jiluFragment zhuanzhang_jilu_fragment=Zhuanzhang_jiluFragment.newInstance();
    //账户余额
    Wode_Zhanghu_yueFragment wode_zhanghu_yueFragment=Wode_Zhanghu_yueFragment.newiniter();
    //个人转企业
    OneFragment oneFragment=OneFragment.newiniter();
    //认证中心
    RenZhenZhongXingFragment renZhenZhongXingFragment=RenZhenZhongXingFragment.newiniter();
    //资讯
    ZiXunFragment ziXunFragment=new ZiXunFragment();
    //认证中心——手机
    //认证中心——个人
    GeRen_RenZhenFragment geRen_renZhenFragment=GeRen_RenZhenFragment.newiniter();
    //认证中心——行业
    //财富——积分
    JiFenFragment jiFenFragment=JiFenFragment.newiniter();
    //财富——金币
    JingBiFragment jingBiFragment= JingBiFragment.newiniter();
    //财富——购物币
    //银行列表
    Yenhang_LIebiao_Fragment yenhang_lIebiao_fragment=Yenhang_LIebiao_Fragment.newiniter();
    //修改银行卡
    ThreeFragment threeFragment=ThreeFragment.newiniter();
    //二维码的PopupWindow
    TwoFragment towTwoFragment;
    //充值
    FourFragment fourFragment=FourFragment.newiniter();
    //提现
    TiXianFragment tiXianFragment=TiXianFragment.newiniter();
    //修改真实姓名
    FiveFragment fiveFragment=FiveFragment.newiniter();
    //修改手机号
    SixFragment sixFragment=SixFragment.newiniter();
    //会员升级
    SevenFragment sevenFragment=SevenFragment.newiniter();
    //登录
    DenLuFragment denLuFragment=DenLuFragment.newiniter();
    // 注册
    ZhuCeFragment zhuCeFragment=ZhuCeFragment.newiniter();
    //忘记密码
    WangJiMiMa wangJiMiMa=WangJiMiMa.newiniter();
    //未实现
    OrderAcceptFragment orderAcceptFragment=OrderAcceptFragment.newiniter();

    Button button;
    Toolbar_putong toolbar_putong;

    private PopupWindow mPopupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ButterKnife.bind(this);
        toolbar_putong= (Toolbar_putong) findViewById(R.id.toolbar_title_chat);
        toolbar_putong.setTitle(getIntent().getStringExtra("cc"));
        toolbar_putong.hiderightView();

        toolbar_putong.setLeftButtonOnClickLinster(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //设置PopupWindow
        initpopup();

        //初始化
        initer();
        //跳转管理
        show(getIntent().getIntExtra("aa",0));

    }

    //设置PopupWindow
    private void initpopup() {
        View popupView = getLayoutInflater().inflate(R.layout.cela, null);

        mPopupWindow = new PopupWindow(popupView,  ActionMenuView.LayoutParams.MATCH_PARENT, ActionMenuView.LayoutParams.MATCH_PARENT, true);
        //设置背景,这个没什么效果，不添加会报错
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
        mPopupWindow.setTouchable(true);
        //在PopupWindow里面就加上下面代码，让键盘弹出时，不会挡住pop窗口。
        mPopupWindow.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
        //设置点击弹窗外隐藏自身
        mPopupWindow.setFocusable(true);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.getContentView().setFocusableInTouchMode(true);
        //添加pop窗口关闭事件
        mPopupWindow.setOnDismissListener(new poponDismissListener());

        fragment=Shezhi_Fragment.newinitFragm(mPopupWindow,getWindow(),popupView);


        View popupView1 = getLayoutInflater().inflate(R.layout.tow_er_weima, null);
        mPopupWindow = new PopupWindow(popupView1,  ActionMenuView.LayoutParams.MATCH_PARENT, ActionMenuView.LayoutParams.MATCH_PARENT, true);
        mPopupWindow.setBackgroundDrawable(new ColorDrawable(0xffffff));//支持点击Back虚拟键退出
        //设置背景,这个没什么效果，不添加会报错
        mPopupWindow.setTouchable(true);
        //在PopupWindow里面就加上下面代码，让键盘弹出时，不会挡住pop窗口。
        mPopupWindow.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
        //添加pop窗口关闭事件
        mPopupWindow.setOnDismissListener(new poponDismissListener());
        towTwoFragment=TwoFragment.newiniter(mPopupWindow,getWindow(),popupView1,getWindowManager());
    }

    private void show(int aa) {

        switch (aa) {
            case 100:
                //个人登录
                toolbar_putong.setVisibility(View.GONE);
                getSupportFragmentManager().beginTransaction().show(denLuFragment).commit();
                break;
            case 101:
                //个人注册
                getSupportFragmentManager().beginTransaction().show(zhuCeFragment).commit();
                break;
            case 102:
                //个人忘记密码
                getSupportFragmentManager().beginTransaction().show(wangJiMiMa).commit();
                break;
            case 1:
                //设置界面
                getSupportFragmentManager().beginTransaction().show(fragment).commit();
                break;
            case 2:
                //推荐管理界面
                break;
            case 3:
                //会员认证界面
                break;
            case 4:
                //我的收藏界面
                break;
            case 5:
                //我的推广界面
                break;
            case 6:
                //联盟商家界面
                break;
            case 7:
                //用户反馈界面
                getSupportFragmentManager().beginTransaction().show(yongHuFanKuiFragment).commit();
                break;
            case 8:
                //帮助说明界面
                break;
            case 9:
                //关于我们界面
                break;
            case 26:
                //二维码的PopupWindow
                getSupportFragmentManager().beginTransaction().show(towTwoFragment).commit();
                break;
            case 227:
                //转账明细
                getSupportFragmentManager().beginTransaction().show(zhuanzhang_jilu_fragment).commit();
                break;
            case 254:
                //财富——积分
                getSupportFragmentManager().beginTransaction().show(jiFenFragment).commit();
                break;
            case 255:
                //财富——金币
                getSupportFragmentManager().beginTransaction().show(jingBiFragment).commit();
                break;
            case 257:
                //修改银行卡
                getSupportFragmentManager().beginTransaction().show(threeFragment).commit();
                break;
            case 258:
                //银行卡列表
                getSupportFragmentManager().beginTransaction().show(yenhang_lIebiao_fragment).commit();
                break;
            case 283:
                //会员升级
                getSupportFragmentManager().beginTransaction().show(sevenFragment).commit();
                break;
            case 287:
                //账户余额
                getSupportFragmentManager().beginTransaction().show(wode_zhanghu_yueFragment).commit();
                break;
            case 347:
                //充值
                getSupportFragmentManager().beginTransaction().show(fourFragment).commit();
                break;
            case 348:
                //提现
                getSupportFragmentManager().beginTransaction().show(tiXianFragment).commit();
                break;
            case 332:
                getSupportFragmentManager().beginTransaction().show(wode_zhanghu_yueFragment).commit();
                break;
            case 333:
                getSupportFragmentManager().beginTransaction().show(fiveFragment).commit();
                break;
            case 337:
                //个人转企业
                getSupportFragmentManager().beginTransaction().show(oneFragment).commit();
                break;
            case 339:
                //认证中心
                getSupportFragmentManager().beginTransaction().show(renZhenZhongXingFragment).commit();
                break;
            case 3391:
                //认证中心——手机
                break;
            case 3392:
                //认证中心——个人
                getSupportFragmentManager().beginTransaction().show(geRen_renZhenFragment).commit();
                break;
            case 3393:
                //认证中心——行业
                break;
            case 286:
                //资讯
                getSupportFragmentManager().beginTransaction().show(ziXunFragment).commit();
                break;
            case 430:
                //修改手机号
                getSupportFragmentManager().beginTransaction().show(sixFragment).commit();
                break;
            case 432:
                //修改真实姓名
                getSupportFragmentManager().beginTransaction().show(fiveFragment).commit();
                break;
            default:
                getSupportFragmentManager().beginTransaction().show(orderAcceptFragment).commit();
                break;
        }

    }

    private void initer() {

        getSupportFragmentManager().beginTransaction().add(R.id.main2_layout_fragment,fragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.main2_layout_fragment,zhuanzhang_jilu_fragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.main2_layout_fragment,wode_zhanghu_yueFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.main2_layout_fragment,oneFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.main2_layout_fragment,fiveFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.main2_layout_fragment,towTwoFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.main2_layout_fragment,threeFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.main2_layout_fragment,fourFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.main2_layout_fragment,sixFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.main2_layout_fragment,sevenFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.main2_layout_fragment,yenhang_lIebiao_fragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.main2_layout_fragment,wangJiMiMa).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.main2_layout_fragment,denLuFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.main2_layout_fragment,zhuCeFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.main2_layout_fragment,orderAcceptFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.main2_layout_fragment,jiFenFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.main2_layout_fragment,jingBiFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.main2_layout_fragment,renZhenZhongXingFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.main2_layout_fragment,geRen_renZhenFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.main2_layout_fragment,yongHuFanKuiFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.main2_layout_fragment,tiXianFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.main2_layout_fragment,ziXunFragment).commit();

        getSupportFragmentManager().beginTransaction().hide(fragment).commit();
        getSupportFragmentManager().beginTransaction().hide(zhuanzhang_jilu_fragment).commit();
        getSupportFragmentManager().beginTransaction().hide(wode_zhanghu_yueFragment).commit();
        getSupportFragmentManager().beginTransaction().hide(oneFragment).commit();
        getSupportFragmentManager().beginTransaction().hide(fiveFragment).commit();
        getSupportFragmentManager().beginTransaction().hide(towTwoFragment).commit();
        getSupportFragmentManager().beginTransaction().hide(threeFragment).commit();
        getSupportFragmentManager().beginTransaction().hide(fourFragment).commit();
        getSupportFragmentManager().beginTransaction().hide(sixFragment).commit();
        getSupportFragmentManager().beginTransaction().hide(sevenFragment).commit();
        getSupportFragmentManager().beginTransaction().hide(yenhang_lIebiao_fragment).commit();
        getSupportFragmentManager().beginTransaction().hide(wangJiMiMa).commit();
        getSupportFragmentManager().beginTransaction().hide(denLuFragment).commit();
        getSupportFragmentManager().beginTransaction().hide(zhuCeFragment).commit();
        getSupportFragmentManager().beginTransaction().hide(orderAcceptFragment).commit();
        getSupportFragmentManager().beginTransaction().hide(jiFenFragment).commit();
        getSupportFragmentManager().beginTransaction().hide(jingBiFragment).commit();
        getSupportFragmentManager().beginTransaction().hide(renZhenZhongXingFragment).commit();
        getSupportFragmentManager().beginTransaction().hide(geRen_renZhenFragment).commit();
        getSupportFragmentManager().beginTransaction().hide(yongHuFanKuiFragment).commit();
        getSupportFragmentManager().beginTransaction().hide(tiXianFragment).commit();
        getSupportFragmentManager().beginTransaction().hide(ziXunFragment).commit();

    }

    @Override
    public void onClick(View v) {
        mPopupWindow.dismiss();
    }


    private class poponDismissListener implements PopupWindow.OnDismissListener {
        @Override
        public void onDismiss() {
            setBackgroundAlpha(1f);
        }
    }

    //设置屏幕背景透明效果
    public void setBackgroundAlpha(float alpha) {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = alpha;
        getWindow().setAttributes(lp);
    }

    //裁剪图片（圆形）
    public Bitmap toRoundBitmap(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int r = 0;
        // 取最短边做边长
        if (width < height) {
            r = width;
        } else {
            r = height;
        }
        // 构建一个bitmap
        Bitmap backgroundBm = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        // new一个Canvas，在backgroundBmp上画图
        Canvas canvas = new Canvas(backgroundBm);
        Paint p = new Paint();
        // 设置边缘光滑，去掉锯齿
        p.setAntiAlias(true);
        RectF rect = new RectF(0, 0, r, r);
        // 通过制定的rect画一个圆角矩形，当圆角X轴方向的半径等于Y轴方向的半径时，
        // 且都等于r/2时，画出来的圆角矩形就是圆形
        canvas.drawRoundRect(rect, r / 2, r / 2, p);
        // 设置当两个图形相交时的模式，SRC_IN为取SRC图形相交的部分，多余的将被去掉
        p.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        // canvas将bitmap画在backgroundBmp上
        canvas.drawBitmap(bitmap, null, rect, p);
        return backgroundBm;
    }

}
