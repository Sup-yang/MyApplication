package baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.Mc;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;

import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.Main2Activity;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.R;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.utils.RegexUtils;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * 修改银行卡
 * A simple {@link Fragment} subclass.
 */
public class ThreeFragment extends Fragment implements View.OnFocusChangeListener {

    private View view;

    @BindView(R.id.three_edit_xingming)EditText xingming;
    @BindView(R.id.three_edit_shujihao)EditText shujihao;
    @BindView(R.id.three_edit_yenhang_kaihuhang)EditText kaihuhang;
    @BindView(R.id.three_edit_yenhangkahao)EditText yenhangkahao;
    @BindView(R.id.three_edit_shenfenzhenhao)EditText shenfenzhenhao;

    public static ThreeFragment newiniter() {
        ThreeFragment oneFragment=new ThreeFragment();
        return oneFragment;}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_three, container, false);
        ButterKnife.bind(this,view);

        xingming.setOnFocusChangeListener(this);
        shujihao.setOnFocusChangeListener(this);
        kaihuhang.setOnFocusChangeListener(this);
        yenhangkahao.setOnFocusChangeListener(this);
        shenfenzhenhao.setOnFocusChangeListener(this);

        return view;
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus){

        }else {

            switch (v.getId()){
                case R.id.three_edit_xingming:
                    if (RegexUtils.isYenhang(xingming.getText().toString())){

                    }else{
                        if (!xingming.getText().toString().equals("")) {
                            Toast.makeText(view.getContext(), "请输入正确的名字", Toast.LENGTH_LONG).show();
                        }
                    }
                    break;
                case R.id.three_edit_shujihao:
                    if (RegexUtils.checkMobile(shujihao.getText().toString())){

                    }else{
                        if (!shujihao.getText().toString().equals("")) {
                            Toast.makeText(view.getContext(), "请输入正确的手机号", Toast.LENGTH_LONG).show();
                        }
                    }
                    break;
                case R.id.three_edit_yenhang_kaihuhang:
                    if (RegexUtils.checkChinese(kaihuhang.getText().toString())){

                    }else{
                        if (!kaihuhang.getText().toString().equals("")) {
                            Toast.makeText(view.getContext(), "请输入正确的开户行名称", Toast.LENGTH_LONG).show();
                        }
                    }
                    break;
                case R.id.three_edit_yenhangkahao:
                    if (RegexUtils.isYenhang(yenhangkahao.getText().toString())){

                    }else{
                        if (!yenhangkahao.getText().toString().equals("")) {
                            Toast.makeText(view.getContext(), "请输入正确的银行卡号", Toast.LENGTH_LONG).show();
                        }
                    }
                    break;
                case R.id.three_edit_shenfenzhenhao:
                    try {
                        RegexUtils regexUtils=new RegexUtils();
                        if (regexUtils.IDCardValidate(shenfenzhenhao.getText().toString())){

                        }else{
                            if (!shenfenzhenhao.getText().toString().equals("")) {
                                Toast.makeText(view.getContext(), "请输入正确的身份证号", Toast.LENGTH_LONG).show();
                            }
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }

    @OnClick(R.id.three_button_quedin)
    public void onClick(){
        Intent intent=new Intent(getContext(), Main2Activity.class);
        startActivity(intent);
    }
}
