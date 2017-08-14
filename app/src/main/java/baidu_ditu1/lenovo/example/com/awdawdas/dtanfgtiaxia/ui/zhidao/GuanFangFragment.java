package baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.zhidao;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 知道界面
 */

public class GuanFangFragment extends Fragment {
    @BindView(R.id.guanfanglistview)ListView listView;

    GuanFangListAdapter adapter;
    List<String> list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=LayoutInflater.from(getContext()).inflate(R.layout.fragment_guan_fang,container,false);
        ButterKnife.bind(this,view);

        list=new ArrayList<>();

        list.add("xxxxxxxxxx");
        list.add("xxxxxxxxxx");
        list.add("xxxxxxxxxx");
        list.add("xxxxxxxxxx");
        list.add("xxxxxxxxxx");
        list.add("xxxxxxxxxx");
        list.add("xxxxxxxxxx");
        list.add("xxxxxxxxxx");



        adapter=new GuanFangListAdapter(view.getContext());

        adapter.addList(list);

        listView.setAdapter(adapter);
        return view;
    }


}
