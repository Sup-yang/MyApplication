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

import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.Main2Activity;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.R;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.utils.RegexUtils;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 注册界面
 * A simple {@link Fragment} subclass.
 */
public class ZhuCeFragment extends Fragment implements View.OnFocusChangeListener {


    private View view;

    @BindView(R.id.grren_chuce_btn_yonghuming)EditText yonghuming;
    @BindView(R.id.grren_chuce_btn_mima)EditText mima;
    @BindView(R.id.grren_chuce_btn_querenmima)EditText querenmima;
    @BindView(R.id.grren_chuce_btn_tuijianren)EditText tuijianren;
    @BindView(R.id.grren_chuce_btn_shoujihao)EditText shoujihao;
    @BindView(R.id.grren_chuce_btn_yanzhengma)EditText yanzhengma;
    @BindView(R.id.zhuce_geren_yanzhenma)TextView yanzhen;

    public static ZhuCeFragment newiniter() {
        ZhuCeFragment zhuCeFragment=new ZhuCeFragment();
        return zhuCeFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_zhu_ce, container, false);
        ButterKnife.bind(this,view);

        yonghuming.setOnFocusChangeListener(this);
        mima.setOnFocusChangeListener(this);
        querenmima.setOnFocusChangeListener(this);
        tuijianren.setOnFocusChangeListener(this);
        shoujihao.setOnFocusChangeListener(this);
        yanzhengma.setOnFocusChangeListener(this);

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

    @OnClick({R.id.grren_chuce_btn_zhuce,R.id.zhuce_geren_yanzhenma})
    public void  onClick(View v){
        switch (v.getId()) {
            case R.id.grren_chuce_btn_zhuce:
                Intent intent = new Intent(view.getContext(), Main2Activity.class);
                intent.putExtra("aa", 100);
                intent.putExtra("cc", "个人登录");
                startActivity(intent);
                break;
            case R.id.zhuce_geren_yanzhenma:
                if (yanzhen.getText().toString().equals("获取验证码")){
                    timer.start();
                }
                break;
        }
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus){

        }else{
            switch (v.getId()){
                case R.id.grren_chuce_btn_yonghuming:
                    if (RegexUtils.checkChinese(yonghuming.getText().toString())){

                    }else {
                        if (!yonghuming.getText().toString().equals("")) {
                            Toast.makeText(view.getContext(), "请输入之前的用户名", Toast.LENGTH_LONG).show();
                        }
                    }
                    break;
                case R.id.grren_chuce_btn_mima:
                    if (RegexUtils.checkPassword(mima.getText().toString())){

                    }else {
                        if (!mima.getText().toString().equals("")) {
                            Toast.makeText(view.getContext(), "请输入正确的密码", Toast.LENGTH_LONG).show();
                        }
                    }
                    break;
                case R.id.grren_chuce_btn_querenmima:
                    if (RegexUtils.checkPassword(querenmima.getText().toString())){
                        if (mima.getText().toString().equals(querenmima.getText().toString())){

                        }else {
                            Toast.makeText(view.getContext(), "两次输入的密码不同", Toast.LENGTH_LONG).show();
                        }

                    }else {
                        if (!querenmima.getText().toString().equals("")) {
                            Toast.makeText(view.getContext(), "请输入正确的密码", Toast.LENGTH_LONG).show();
                        }
                    }
                    break;
                case R.id.grren_chuce_btn_tuijianren:
                    if (RegexUtils.checkChinese(tuijianren.getText().toString())){

                    }else {
                        if (!tuijianren.getText().toString().equals("")) {
                            Toast.makeText(view.getContext(), "请输入正确的姓名", Toast.LENGTH_LONG).show();
                        }
                    }
                    break;
                case R.id.grren_chuce_btn_shoujihao:
                    if (RegexUtils.checkMobile(shoujihao.getText().toString())){

                    }else {
                        if (!shoujihao.getText().toString().equals("")) {
                            Toast.makeText(view.getContext(), "请输入正确的手机号", Toast.LENGTH_LONG).show();
                        }
                    }
                    break;
                case R.id.grren_chuce_btn_yanzhengma:
                    if (RegexUtils.checkChinese(yanzhengma.getText().toString())){

                    }else {
                        if (!yanzhengma.getText().toString().equals("")) {
                            Toast.makeText(view.getContext(), "请输入正确的验证码", Toast.LENGTH_LONG).show();
                        }
                    }
                    break;
            }
        }
    }
}
