package baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.zhuye;


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
public class RenZhenZhongXingFragment extends Fragment {


    private View view;

    public static RenZhenZhongXingFragment newiniter() {
        RenZhenZhongXingFragment renZhenZhongXingFragment=new RenZhenZhongXingFragment();
        return renZhenZhongXingFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_ren_zhen_zhong_xing, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @OnClick({R.id.renzhen_shoji,R.id.renzhen_hangye,R.id.renzhen_geren})
    public void onClick(View v){
        Intent intent;
        switch (v.getId()){
            case R.id.renzhen_shoji:
                //手机认证
                intent = new Intent(getContext(), Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.renzhen_geren:
                //个人认证
                intent = new Intent(getContext(), Main2Activity.class);
                intent.putExtra("aa", 3392);
                intent.putExtra("cc", "个人会员认证");
                startActivity(intent);
                break;
            case R.id.renzhen_hangye:
                //行业认证
                intent = new Intent(getContext(), Main2Activity.class);
                startActivity(intent);
                break;
        }
    }
}
