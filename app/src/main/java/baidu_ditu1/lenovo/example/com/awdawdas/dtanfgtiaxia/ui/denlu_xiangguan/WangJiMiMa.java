package baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.denlu_xiangguan;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;

import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.Main2Activity;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.R;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.utils.RegexUtils;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 忘记密码界面
 * A simple {@link Fragment} subclass.
 */
public class WangJiMiMa extends Fragment implements View.OnFocusChangeListener {


    private View view;
    @BindView(R.id.wangji_edit_shoji)EditText shoji;
    @BindView(R.id.wangji_edit_shenfenzhen)EditText shenfenzhen;
    @BindView(R.id.wangji_edit_yenzhenma)EditText yenzhenma;
    @BindView(R.id.wangji_edit_mima)EditText mima;
    @BindView(R.id.wangji_edit_qren_mima)EditText qren_mima;
    @BindView(R.id.wangji_yanzhenma)TextView yanzhen;

//    @BindViews({R.id.})

    public static WangJiMiMa newiniter() {
        // Required empty public constructor
        WangJiMiMa wangJiMiMa=new WangJiMiMa();
        return wangJiMiMa;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_wang_ji_mi_ma, container, false);
        ButterKnife.bind(this,view);

        shoji.setOnFocusChangeListener(this);
        shenfenzhen.setOnFocusChangeListener(this);
        yenzhenma.setOnFocusChangeListener(this);
        mima.setOnFocusChangeListener(this);
        qren_mima.setOnFocusChangeListener(this);

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

    @OnClick({R.id.wangji_button_qren,R.id.wangji_yanzhenma})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.wangji_button_qren:
                Intent intent = new Intent(view.getContext(), Main2Activity.class);
                intent.putExtra("aa", 100);
                intent.putExtra("cc", "个人登录");
                startActivity(intent);
                break;

            case R.id.wangji_yanzhenma:
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
                case R.id.wangji_edit_shoji:
                    if (RegexUtils.checkMobile(shoji.getText().toString())){

                    }else {
                        if (!shoji.getText().toString().equals("")) {
                            Toast.makeText(view.getContext(), "请输入正确的手机号码", Toast.LENGTH_LONG).show();
                        }
                    }
                    break;
                case R.id.wangji_edit_shenfenzhen:
                    RegexUtils regexUtils=new RegexUtils();
                    try {
                        if (regexUtils.IDCardValidate(shenfenzhen.getText().toString())){

                        }else {
                            if (!shenfenzhen.getText().toString().equals("")) {
                                Toast.makeText(view.getContext(), "请输入正确的身份证号", Toast.LENGTH_LONG).show();
                            }
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    break;
                case R.id.wangji_edit_yenzhenma:
                    if (RegexUtils.checkYenZenMa(yenzhenma.getText().toString())){

                    }else {
                        if (!yenzhenma.getText().toString().equals("")) {
                            Toast.makeText(view.getContext(), "请输入正确的验证码", Toast.LENGTH_LONG).show();
                        }
                    }
                    break;
                case R.id.wangji_edit_mima:

                    if (RegexUtils.checkPassword(mima.getText().toString())){

                    }else {
                        if (!mima.getText().toString().equals("")) {
                            Toast.makeText(view.getContext(), "请输入正确的密码", Toast.LENGTH_LONG).show();
                        }
                    }
                    break;
                case R.id.wangji_edit_qren_mima:
                    if (RegexUtils.checkPassword(qren_mima.getText().toString())){
                        if (mima.getText().toString().equals(qren_mima.getText().toString())){

                        }else {
                            Toast.makeText(view.getContext(), "两次输入的密码不一样", Toast.LENGTH_LONG).show();
                        }
                    }else {
                        if (!qren_mima.getText().toString().equals("")) {
                            Toast.makeText(view.getContext(), "请输入正确的密码", Toast.LENGTH_LONG).show();
                        }
                    }
                    break;
            }
        }
    }


}
