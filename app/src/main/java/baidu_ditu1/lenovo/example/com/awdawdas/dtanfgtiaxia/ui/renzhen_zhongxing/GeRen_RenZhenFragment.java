package baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.renzhen_zhongxing;


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
public class GeRen_RenZhenFragment extends Fragment {


    private View view;

    public static GeRen_RenZhenFragment newiniter() {
        GeRen_RenZhenFragment eGeRen_renZhenFragment=new GeRen_RenZhenFragment();
        return eGeRen_renZhenFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_ge_ren__ren_zhen, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @OnClick({R.id.gerenyonghu_edittext_xingming,R.id.gerenyonghu_edittext_zhengjianhao,R.id.gerenyonghu_edittext_qishiri,R.id.gerenyonghu_edittext_daoqiri,R.id.gerenyonghu_edittext_hangyefenlei,R.id.gerenyonghu_button_xiayibu,R.id.gerenyonghu_edittext_suozaiquyu})
public void onClick(View v){
        Intent intent;
        switch (v.getId()){
            case R.id.gerenyonghu_edittext_xingming:
                break;
            case R.id.gerenyonghu_edittext_zhengjianhao:
                break;
            case R.id.gerenyonghu_edittext_qishiri:
                break;
            case R.id.gerenyonghu_edittext_daoqiri:
                break;
            case R.id.gerenyonghu_edittext_hangyefenlei:
                break;
            case R.id.gerenyonghu_edittext_suozaiquyu:
                break;
            case R.id.gerenyonghu_button_xiayibu:
                intent = new Intent(getContext(), Main2Activity.class);
                intent.putExtra("cc", "下一步");
                startActivity(intent);
                break;
        }
    }
}
