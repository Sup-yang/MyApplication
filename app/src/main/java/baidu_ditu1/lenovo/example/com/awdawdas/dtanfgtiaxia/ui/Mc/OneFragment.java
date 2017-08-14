package baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.Mc;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.Main2Activity;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.R;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.utils.RegexUtils;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class OneFragment extends Fragment implements View.OnFocusChangeListener {


    private View view;
    @BindView(R.id.spinner) Spinner spinner;
    @BindView(R.id.one_editText_gongsi_mingchen)EditText gongsi;
    @BindView(R.id.one_editText_yenye_zhizhang)EditText yenye_zhzao;
    @BindView(R.id.one_editText_shojihang)EditText shojihang;
    @BindView(R.id.one_editText_yanzhenma)EditText yanzhenma;
    @BindView(R.id.one_text_yanzhenma)TextView yanzhen;
    List<String> data_list=new ArrayList<>();
     ArrayAdapter<String> arr_adapter;

    public static OneFragment newiniter() {
        OneFragment oneFragment=new OneFragment();
        return oneFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_one, container, false);
        ButterKnife.bind(this,view);

        gongsi.setOnFocusChangeListener(this);
        yenye_zhzao.setOnFocusChangeListener(this);
        shojihang.setOnFocusChangeListener(this);
        yanzhenma.setOnFocusChangeListener(this);

        data_list.add("aa");
        data_list.add("aa");
        data_list.add("aa");

        //        适配器
        arr_adapter= new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_spinner_item,data_list );
        //设置样式
        arr_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //        加载适配器
        spinner.setAdapter(arr_adapter);


        return view;
    }

    public CountDownTimer timer = new CountDownTimer(60000, 1000) {

        @Override
        public void onTick(long millisUntilFinished) {

            yanzhen.setTextColor(Color.GREEN);
            yanzhen.setText((millisUntilFinished / 1000) + "秒后可重发");

        }

        @Override
        public void onFinish() {

            yanzhen.setTextColor(Color.GRAY);
            yanzhen.setEnabled(true);
            yanzhen.setText("获取验证码");
        }
    };

    @OnClick({R.id.one_button_puedin,R.id.one_text_yanzhenma})
    public void onclick(View v){
        switch (v.getId()){
            case R.id.one_button_puedin:

        Intent intent=new Intent(getContext(), Main2Activity.class);
        startActivity(intent);
                break;
            case R.id.one_text_yanzhenma:
                if (yanzhen.getText().toString().equals("获取验证码")){
                    timer.start();
                }
                break;
        }
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus){

        }else {
            switch (v.getId()){
                case R.id.one_editText_gongsi_mingchen:
                    if (RegexUtils.checkZhongwenMingChen(gongsi.getText().toString())){

                    }else {
                        if (!gongsi.getText().toString().equals("")) {
                            Toast.makeText(view.getContext(), "请输入正确的公司名称", Toast.LENGTH_LONG).show();
                        }
                    }
                    break;
                case R.id.one_editText_yenye_zhizhang:
                    if (RegexUtils.checkYenYeZhiZHao(yenye_zhzao.getText().toString())){

                    }else {
                        if (!yenye_zhzao.getText().toString().equals("")) {
                            Toast.makeText(view.getContext(), "请输入正确的营业执照", Toast.LENGTH_LONG).show();
                        }
                    }
                    break;
                case R.id.one_editText_shojihang:
                    if (RegexUtils.checkMobile(shojihang.getText().toString())){

                    }else {
                        if (!shojihang.getText().toString().equals("")) {
                        Toast.makeText(view.getContext(), "请输入正确的手机号码", Toast.LENGTH_LONG).show();
                        }
                    }
                    break;
                case R.id.one_editText_yanzhenma:
                    if (RegexUtils.checkYenZenMa(yanzhenma.getText().toString())){

                    }else {
                        if (!yanzhenma.getText().toString().equals("")) {
                            Toast.makeText(view.getContext(), "请输入正确的验证码", Toast.LENGTH_LONG).show();
                        }
                    }
                    break;
            }
        }

    }
}
