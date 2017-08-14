package baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.caifu;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.R;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class TiXianFragment extends Fragment {


    private View view;

    public static TiXianFragment newiniter() {
        TiXianFragment tiXianFragment=new TiXianFragment();
        return tiXianFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_ti_xian, container, false);
        ButterKnife.bind(this,view);
        return view;
    }
    @OnClick({R.id.tixian_edit_yenhang,R.id.tixian_edit_huming,R.id.tixian_edit_kahao,R.id.tixian_edit_jine,R.id.tixian_button_quedin})
    public void onClick(View v){
        Intent intent;
        switch (v.getId()){
            case R.id.tixian_edit_yenhang:
            break;
            case R.id.tixian_edit_huming:
            break;
            case R.id.tixian_edit_kahao:
            break;
            case R.id.tixian_edit_jine:
            break;
            case R.id.tixian_button_quedin:

                break;
        }
    }

}
