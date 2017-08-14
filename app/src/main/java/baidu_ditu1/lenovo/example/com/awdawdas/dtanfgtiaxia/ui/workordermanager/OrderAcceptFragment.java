package baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.workordermanager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.R;
import butterknife.ButterKnife;


/**
 * 已受理界面
 *
 * */
public class OrderAcceptFragment extends Fragment {

    private View view;

    public static OrderAcceptFragment newiniter() {
        OrderAcceptFragment orderAcceptFragment=new OrderAcceptFragment();
        return orderAcceptFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_order_accept, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

}
