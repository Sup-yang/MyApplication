package baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui;


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
 * 账户余额
 * （充值，提现）
 * A simple {@link Fragment} subclass.
 */
public class Wode_Zhanghu_yueFragment extends Fragment {


    private View view;

    public static Wode_Zhanghu_yueFragment newiniter() {
        Wode_Zhanghu_yueFragment f=new Wode_Zhanghu_yueFragment();
        return f ;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_wode__zhanghu_yue, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @OnClick({R.id.zhanghu_yue_button_chongzhi,R.id.zhanghu_yue_button_tixian})
    public void onClick(View v){
        Intent intent;
        switch (v.getId()){
            case R.id.zhanghu_yue_button_chongzhi:
                intent=new Intent(view.getContext(), Main2Activity.class);
                intent.putExtra("aa",347);
                intent.putExtra("cc","充值");
                startActivity(intent);
            break;
            case R.id.zhanghu_yue_button_tixian:
                intent=new Intent(view.getContext(), Main2Activity.class);
                intent.putExtra("aa",348);
                intent.putExtra("cc","提现");
                startActivity(intent);
            break;
        }
    }

}
