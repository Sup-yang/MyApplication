package baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.caifu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.R;
import butterknife.ButterKnife;

/**
 */
public class GoWuBiFragment extends Fragment {

    private View view;

    public static GoWuBiFragment newiniter() {
       GoWuBiFragment goWuBiFragment=new GoWuBiFragment();
        return goWuBiFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_go_wu_bi, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

}
