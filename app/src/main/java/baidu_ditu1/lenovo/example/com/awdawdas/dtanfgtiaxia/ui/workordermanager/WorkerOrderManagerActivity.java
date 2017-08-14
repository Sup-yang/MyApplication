package baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.workordermanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.Main2Activity;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.R;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.base.Baseclass;

/**
 * 工单管理界面
 */

public class WorkerOrderManagerActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{


   private WorkerAdapter adapter;
    private List<Baseclass> list;
    private ListView listView;
    private TextView textView;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_order_manager);

        final Intent intent=getIntent();//跳转带值
        String name=intent.getStringExtra("name");
        textView= (TextView) findViewById(R.id.tv_toolbar);//给toolbar设置名称
        textView.setText(name);

        //给toolbar的箭头设置监听事件
        imageView= (ImageView) findViewById(R.id.iv_toolbar);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });


        list=new ArrayList<>();//添加集合
      //  String [] names={"修改手机号","修改邮箱","修改真实姓名","修改企业名称","工单管理"};

        //
        list.add(new Baseclass(R.drawable.gd_01,"修改手机号"));
        list.add(new Baseclass(R.drawable.gd_02,"修改邮箱"));
        list.add(new Baseclass(R.drawable.gd_03,"修改真实姓名"));
        list.add(new Baseclass(R.drawable.gd_04,"修改企业名称"));
        list.add(new Baseclass(R.drawable.gd_05,"工单管理"));

        adapter=new WorkerAdapter(this);
        listView= (ListView) findViewById(R.id.workerorderListview);

        adapter.addData(list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent;
        switch (position){
            case 0:
                //修改手机号
                intent=new Intent(view.getContext(), Main2Activity.class);
                intent.putExtra("aa",430);
                intent.putExtra("cc","修改手机号");
                startActivity(intent);
                break;
            case 1:
                //修改邮箱
                 intent=new Intent(view.getContext(), Main2Activity.class);
                intent.putExtra("cc","修改邮箱");
                startActivity(intent);
                break;
            case 2:
                //修改真实姓名
                intent=new Intent(view.getContext(), Main2Activity.class);
                intent.putExtra("aa",432);
                intent.putExtra("cc","修改真实姓名");
                startActivity(intent);
                break;
            case 3:
                //修改企业名称
                intent=new Intent(view.getContext(), Main2Activity.class);
                intent.putExtra("cc","修改企业名称");
                startActivity(intent);
                break;
            case 4:
                //工单记录
                intent=new Intent(WorkerOrderManagerActivity.this,OrderRecordActivity.class);
                intent.putExtra("record","工单记录");
                startActivity(intent);
                break;

        }


    }
}
