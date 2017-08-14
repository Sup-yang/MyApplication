package baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.denlu_xiangguan;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.Main2Activity;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.MainActivity;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.R;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.utils.RegexUtils;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.content.Context.MODE_PRIVATE;

/**
 * 登录
 * A simple {@link Fragment} subclass.
 */
public class DenLuFragment extends Fragment implements View.OnFocusChangeListener {

    public static String YONGHUMING,MIMA;

    private View view;
    @BindView(R.id.geren_denlu_edittext_denluming)EditText denlu;
    @BindView(R.id.geren_denlu_edittext_mima)EditText mima;



    public static DenLuFragment newiniter() {
        // Required empty public constructor
        DenLuFragment denLuFragment=new DenLuFragment();
        return denLuFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_den_lu, container, false);
        ButterKnife.bind(this,view);

        denlu.setOnFocusChangeListener(this);
        mima.setOnFocusChangeListener(this);
        return view;
    }

    @OnClick({R.id.geren_denlu_button,R.id.geren_denlu_text_zhuce,R.id.geren_denlu_text_wangjimima})
    public void onClick(View v){
        Intent intent;
        switch ( v.getId()){
            case R.id.geren_denlu_button:
                if (!denlu.getText().toString().equals("")&&denlu.getText().toString()!=null&&!denlu.getText().toString().equals("")&&denlu.getText().toString()!=null) {
                    SharedPreferences sp = view.getContext().getSharedPreferences("dataa", MODE_PRIVATE);
                    //获取编辑器；
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putBoolean("denlu", true);
                    editor.putString("kk", denlu.getText().toString());

                    mima.setText("");
                    intent = new Intent(view.getContext(), MainActivity.class);
                    startActivity(intent);
                    editor.commit();

                }
                break;
            case R.id.geren_denlu_text_zhuce:
                intent=new Intent(view.getContext(), Main2Activity.class);
                intent.putExtra("aa",101);
                intent.putExtra("cc","注册");
                startActivity(intent);
                break;
            case R.id.geren_denlu_text_wangjimima:
                intent=new Intent(view.getContext(), Main2Activity.class);
                intent.putExtra("aa",102);
                intent.putExtra("cc","忘记密码");
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus){

        }else{
            switch (v.getId()){
                case R.id.geren_denlu_edittext_denluming:
                    if (RegexUtils.checkChinese(denlu.getText().toString())){
                       YONGHUMING=denlu.getText().toString();
                        Toast.makeText(view.getContext(),  YONGHUMING, Toast.LENGTH_LONG).show();
                    }else {
                        YONGHUMING="";
                        if (!denlu.getText().toString().equals("")) {
                            Toast.makeText(view.getContext(), "请输入正确的用户名", Toast.LENGTH_LONG).show();
                        }
                    }
                    break;
                case R.id.geren_denlu_edittext_mima:
                    if (RegexUtils.checkPassword(mima.getText().toString())){
                        MIMA=mima.getText().toString();
                        Toast.makeText(view.getContext(),   MIMA, Toast.LENGTH_LONG).show();
                    }else {
                        MIMA="";
                        if (!mima.getText().toString().equals("")) {
                            Toast.makeText(view.getContext(), "请输入正确的密码", Toast.LENGTH_LONG).show();
                        }
                    }
                    break;
            }
        }

    }
}
