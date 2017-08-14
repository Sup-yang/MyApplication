package baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.adapter.Main3_recycler_adaper;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.base.Baseclass;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.toolbar.Toolbar_putong;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.utils.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 银行卡界面
 */
public class Main3Activity extends BaseActivity {

    @BindView(R.id.main3_recycler)
    RecyclerView recyclerView;
    private Main3_recycler_adaper madaper;
    private List<Baseclass> list =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        ButterKnife.bind(this);
        Toolbar_putong toolbar_putong= (Toolbar_putong) findViewById(R.id.toolbar_title_main3);
        toolbar_putong.setTitle("银行卡");
        toolbar_putong.setLeftButtonOnClickLinster(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        toolbar_putong.setrightButtonOnClickLinster(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main3Activity.this, Main2Activity.class);
                intent.putExtra("aa",258);
                intent.putExtra("cc","银行列表");
                startActivity(intent);
            }
        });

        initer();
        initdeve();

        madaper.setOnItemClickListener(new Main3_recycler_adaper.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent=new Intent(Main3Activity.this,Main2Activity.class);
                intent.putExtra("aa",257);
                intent.putExtra("cc","修改银行卡");
                startActivity(intent);
            }
        });

    }

    private void initdeve() {
        list.add(new Baseclass("中国农业银行","8779","审核中"));
        list.add(new Baseclass("中国银行","9653","审核中"));
        list.add(new Baseclass("中国建设银行","4784",""));
        madaper.notifyDataSetChanged();
    }

    private void initer() {


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        madaper=new Main3_recycler_adaper(list);
        recyclerView.setAdapter(madaper);

    }


}
