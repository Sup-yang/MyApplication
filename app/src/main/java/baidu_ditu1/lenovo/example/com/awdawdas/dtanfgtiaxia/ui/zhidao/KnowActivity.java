package baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.zhidao;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class KnowActivity extends AppCompatActivity {
    @BindView(R.id.tv_toolbar)TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_know);
        ButterKnife.bind(this);
        textView.setText("知道");

        initDAta();//初始化数据

    }


    //初始化数据
    private void initDAta(){

        findViewById(R.id.iv_toolbar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ViewPager viewPager= (ViewPager) findViewById(R.id.viewPager_know);
        KnowAdapter adapter=new KnowAdapter(getSupportFragmentManager(),this);

        viewPager.setAdapter(adapter);

        TabLayout tabLayout= (TabLayout) findViewById(R.id.tabLayout_know);
        tabLayout.setupWithViewPager(viewPager);
    }
}
