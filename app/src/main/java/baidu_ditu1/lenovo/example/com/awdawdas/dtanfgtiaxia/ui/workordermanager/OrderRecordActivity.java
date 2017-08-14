package baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.workordermanager;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.R;


public class OrderRecordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_record);
        initData();
    }

    private void initData() {
        String name=getIntent().getStringExtra("record");
        TextView textView= (TextView) findViewById(R.id.tv_toolbar);
        textView.setText(name);
        ImageView imageView= (ImageView) findViewById(R.id.iv_toolbar);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(OrderRecordActivity.this,WorkerOrderManagerActivity.class);
//                startActivity(intent);
                finish();
            }
        });

        ViewPager viewPager= (ViewPager) findViewById(R.id.viewPager_orderrecord);
        //绑定viewpager控件

        //获取适配器对象
        RecordAdapter adapter=new RecordAdapter(getSupportFragmentManager(),this);

        //给ViewPager添加适配器，适配数据
        viewPager.setAdapter(adapter);

        //拿到tablayout控件
        TabLayout layout= (TabLayout) findViewById(R.id.tablayout_orderrecord);

        //把tablayput与viewpager绑定
        layout.setupWithViewPager(viewPager);

    }
}
