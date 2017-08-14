package baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.adapter.Zhuanzhang_Recycler_Adaper;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.base.Baseclass;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.toolbar.Toolbar_zhuanzhang;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.zhifu.ChatActivity;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.zidingyi_soso.BaseActivity;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.zidingyi_soso.IconCenterEditText;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 转账界面
 */
public class Zhuanzhang_Activity extends BaseActivity {



    @BindView(R.id.icet_search)
     IconCenterEditText icet_search;

    @BindView(R.id.zhuanzhang_jilu1_recycler)
    RecyclerView recyclerView;
    private Zhuanzhang_Recycler_Adaper adaper;
    private List<Baseclass> list=new ArrayList<>();



    @Override
    public void iniView() {
        setContentView(R.layout.activity_zhuanzhang_);
        ButterKnife.bind(this);

        Toolbar_zhuanzhang toolbara= (Toolbar_zhuanzhang) findViewById(R.id.toolbar_title_zhuanzhuang);
        toolbara.setTitle("好友转账");

        toolbara.setLeftButtonOnClickLinster(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        toolbara.setrightButtonOnClickLinster(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Zhuanzhang_Activity.this,Main2Activity.class);
                intent.putExtra("aa", 227);
                intent.putExtra("cc", "转账明细");
                startActivity(intent);
            }
        });

        initdeve();
        initer();

        final List<Baseclass> dave=new ArrayList<>();
        // 实现TextWatcher监听即可
        icet_search.setOnSearchClickListener(new IconCenterEditText.OnSearchClickListener() {
            @Override
            public void onSearchClick(View view) {
                Toast.makeText(Zhuanzhang_Activity.this, "i'm going to seach", Toast.LENGTH_SHORT).show();
                if (icet_search.getText().toString()!=""&&icet_search.getText().toString()!=null){
                    for (int i = 0; i <list.size() ; i++) {
                        if (icet_search.getText().toString().contains(list.get(i).getName().toString())){
                            dave.add(list.get(i));
                        }
                    }
                    adaper.addlistDeve(dave);
                    adaper.notifyDataSetChanged();
                }
            }
        });



        adaper.setOnItemClickListener(new Zhuanzhang_Recycler_Adaper.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent=new Intent(Zhuanzhang_Activity.this,ChatActivity.class);
                startActivity(intent);
            }
        });

    }



    //添加数据
    private void initdeve() {
        for (int i = 0; i <20 ; i++) {
            list.add(new Baseclass(R.drawable.ic_launcher,"啾啾啾啾斤","2017-03-26"));
        }
    }

    private void initer() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adaper=new Zhuanzhang_Recycler_Adaper(list);
        recyclerView.setAdapter(adaper);

    }

}
