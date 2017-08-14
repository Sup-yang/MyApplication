package baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.R;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.adapter.Zhuanzhang_Recycler_Adaper;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.base.Baseclass;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 转账记录
 * A simple {@link Fragment} subclass.
 */
public class Zhuanzhang_jiluFragment extends Fragment {

@BindView(R.id.zhuanzhang_jilu2_recycler) RecyclerView recyclerView;
    private View view;
    private Zhuanzhang_Recycler_Adaper adaper;
    private List<Baseclass> list=new ArrayList<>();

    public static Zhuanzhang_jiluFragment newInstance() {
        Zhuanzhang_jiluFragment f = new Zhuanzhang_jiluFragment();
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_zhuanzhang_jilu2,container,false);
        ButterKnife.bind(this,view);
        initdeve();
        initer();
        return view;
    }



    //添加数据
    private void initdeve() {
        for (int i = 0; i <20 ; i++) {
            list.add(new Baseclass(R.drawable.ic_launcher,"顶顶顶","2017-03-26"));
        }
    }

    private void initer() {
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adaper=new Zhuanzhang_Recycler_Adaper(list);
        recyclerView.setAdapter(adaper);

    }

}
