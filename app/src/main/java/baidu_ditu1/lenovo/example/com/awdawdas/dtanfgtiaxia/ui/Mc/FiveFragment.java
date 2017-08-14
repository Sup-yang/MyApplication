package baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.Mc;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.Main2Activity;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.R;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.utils.RegexUtils;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * 修改姓名
 * A simple {@link Fragment} subclass.
 */
public class FiveFragment extends Fragment implements View.OnFocusChangeListener {


    private View view;
    @BindView(R.id.five_edit_yuan_xianmin)
    EditText yuan;
    @BindView(R.id.five_edit_xin_xianmin)
    EditText xin;
    @BindView(R.id.five_button_queren)
    Button pueren;

    public static FiveFragment newiniter() {
        FiveFragment oneFragment=new FiveFragment();
        return oneFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_five, container, false);
        ButterKnife.bind(this,view);

        yuan.setOnFocusChangeListener(this);
        xin.setOnFocusChangeListener(this);

        return view;

    }

    /**
     * 当EditText失去焦点时要做的操作
     * @param v
     * @param hasFocus
     */
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus){

        }else {
            switch (v.getId()){
                case R.id.five_edit_yuan_xianmin:
                    if (RegexUtils.checkChinese(yuan.getText().toString())){

                    }else {
                        if (!yuan.getText().toString().equals("")) {
                            Toast.makeText(view.getContext(), "请输正确的名字", Toast.LENGTH_LONG).show();
                            yuan.setText("");
                        }
                    }
                    break;
                case R.id.five_edit_xin_xianmin:
                    if (RegexUtils.checkChinese(xin.getText().toString())){

                    }else {
                        if (!xin.getText().toString().equals("")) {
                            Toast.makeText(view.getContext(), "请输入之前的名字", Toast.LENGTH_LONG).show();
                            xin.setText("");
                        }
                    }
                    break;
            }
        }
    }


    @OnClick(R.id.five_button_queren)
    public void onclick(){
        Intent intent=new Intent(view.getContext(), Main2Activity.class);
        startActivity(intent);
    }

}
