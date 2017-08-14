package baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.utils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * 创建一个BaseActivity.java基类,项目中的所有activity都继承此类.
 * Created by lenovo on 2017/4/8.
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
        StatusBarCompat.compat(this);
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }



}
