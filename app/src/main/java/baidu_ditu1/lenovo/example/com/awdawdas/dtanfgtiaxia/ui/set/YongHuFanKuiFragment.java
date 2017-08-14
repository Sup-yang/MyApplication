package baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.set;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.R;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class YongHuFanKuiFragment extends Fragment {


    private View view;

    public static YongHuFanKuiFragment newiniter() {
        YongHuFanKuiFragment yongHuFanKuiFragment=new YongHuFanKuiFragment();
        return yongHuFanKuiFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_yong_hu_fan_kui, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

}
