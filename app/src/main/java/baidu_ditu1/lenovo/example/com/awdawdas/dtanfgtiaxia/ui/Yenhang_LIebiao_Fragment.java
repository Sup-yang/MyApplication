package baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.R;
import butterknife.ButterKnife;

/**
 * 银行列表
 * A simple {@link Fragment} subclass.
 */
public class Yenhang_LIebiao_Fragment extends Fragment {


    private View view;

    public static Yenhang_LIebiao_Fragment newiniter() {
        Yenhang_LIebiao_Fragment fragment=new Yenhang_LIebiao_Fragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_yenhang__liebiao_, container, false);
        ButterKnife.bind(this,view);

        return view;
    }

}
