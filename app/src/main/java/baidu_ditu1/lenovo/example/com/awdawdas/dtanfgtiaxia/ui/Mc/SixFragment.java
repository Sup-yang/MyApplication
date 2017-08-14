package baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.Mc;


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
 * A simple {@link Fragment} subclass.
 */
public class SixFragment extends Fragment implements View.OnFocusChangeListener {

    private View view;

    @BindView(R.id.six_edit_yuan_shojihao)EditText yuan;
    @BindView(R.id.six_edit_xing_shojihao)EditText xing;
    @BindView(R.id.six_edit_yanzhenma)EditText yanzhenma;
    @BindView(R.id.six_yanzhenma)TextView yanzhen;

    public static SixFragment newiniter() {
        SixFragment oneFragment=new SixFragment();
        return oneFragment;}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_six, container, false);
        ButterKnife.bind(this,view);

        yuan.setOnFocusChangeListener(this);
        xing.setOnFocusChangeListener(this);
        yanzhenma.setOnFocusChangeListener(this);

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

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus){

        }else {
            switch (v.getId()){
                case R.id.six_edit_yuan_shojihao:
                    if (RegexUtils.checkMobile(yuan.getText().toString())){

                    }else {
                        if (!yuan.getText().toString().equals("")) {
                            Toast.makeText(view.getContext(), "请输入正确的手机号码", Toast.LENGTH_LONG).show();
                        }
                    }
                    break;
                case R.id.six_edit_xing_shojihao:
                    if (RegexUtils.checkMobile(xing.getText().toString())){

                    }else {
                        if (!xing.getText().toString().equals("")) {
                            Toast.makeText(view.getContext(), "请输入正确的手机号码", Toast.LENGTH_LONG).show();
                        }
                    }
                    break;
                case R.id.six_edit_yanzhenma:
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

    @OnClick({R.id.six_button_quedin,R.id.six_yanzhenma})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.six_button_quedin:

                Intent intent=new Intent(getContext(), Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.six_yanzhenma:

                if (yanzhen.getText().toString().equals("获取验证码")){
                    timer.start();

                }
                break;
        }
    }

}
