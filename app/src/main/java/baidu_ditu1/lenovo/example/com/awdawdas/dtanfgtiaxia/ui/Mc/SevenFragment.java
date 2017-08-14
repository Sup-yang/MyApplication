package baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.Mc;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.Main2Activity;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.R;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class SevenFragment extends Fragment {

    private View view;

    public static SevenFragment newiniter() {
        SevenFragment oneFragment=new SevenFragment();
        return oneFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_seven, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @OnClick({R.id.seven_text_chuangke,R.id.seven_text_chuangto})
    public void onClick(View v){
        Intent intent;
        switch (v.getId()){
            case R.id.seven_text_chuangke:
                 intent=new Intent(getContext(), Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.seven_text_chuangto:
                 intent=new Intent(getContext(), Main2Activity.class);
                startActivity(intent);
                break;
        }
    }

}
