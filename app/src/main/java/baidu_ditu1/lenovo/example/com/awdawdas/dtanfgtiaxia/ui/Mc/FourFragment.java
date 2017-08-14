package baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.Mc;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
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
public class FourFragment extends Fragment implements View.OnFocusChangeListener {

    private View view;

    public static FourFragment newiniter() {
        FourFragment fourFragment=new FourFragment();
        return fourFragment;
    }

    List<String> list_spinner = new ArrayList<>();
    @BindView(R.id.four_edit_zhuanzhuang_yenhang)
    EditText zhuanzhuang;
    @BindView(R.id.four_edit_yenhang_kahao)
    EditText yenhang;
    @BindView(R.id.four_edit_chongzhi_jinge)
    EditText chongzhi;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

         view = inflater.inflate(R.layout.fragment_four, container, false);
        ButterKnife.bind(this,view);
        initdatas(view);
        zhuanzhuang.setOnFocusChangeListener(this);
        yenhang.setOnFocusChangeListener(this);
        chongzhi.setOnFocusChangeListener(this);
        return view;
    }

    //选择银行户口的Spinner（下拉列表）
    private void initdatas(View view) {
        list_spinner.add("中国建设银行");
        list_spinner.add("中国工商银行");
        list_spinner.add("中国银行");
        list_spinner.add("交通银行");

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_spinner_item,list_spinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        final Spinner spinner=(Spinner) view.findViewById(R.id.spinner_fragmentgour);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(view.getContext(), list_spinner.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    //EditText的失去焦点的监听
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus){

        }else {
            switch (v.getId()){
                case R.id.four_edit_zhuanzhuang_yenhang:
                    if (zhuanzhuang.getText().toString().equals("中国农业银行")||zhuanzhuang.getText().toString().equals("交通银行")||zhuanzhuang.getText().toString().equals("中国银行")||zhuanzhuang.getText().toString().equals("中国工商银行")||zhuanzhuang.getText().toString().equals("中国建设银行")){

                    }else{
                        if (!zhuanzhuang.getText().toString().equals("")){
                            Toast.makeText(view.getContext(),"请输入正确的银行名称",Toast.LENGTH_LONG).show();
                            zhuanzhuang.setText("");
                        }

                    }
                    break;
                case R.id.four_edit_yenhang_kahao:
                    if (RegexUtils.isYenhang(yenhang.getText().toString())){

                    }else{
                        if (!yenhang.getText().toString().equals("")) {
                            Toast.makeText(view.getContext(), "请输入正确的名字", Toast.LENGTH_LONG).show();
                        }
                    }
                    break;
                case R.id.four_edit_chongzhi_jinge:
                    if (RegexUtils.checkDecimals(chongzhi.getText().toString())){

                    }else{
                        if (!chongzhi.getText().toString().equals("")) {
                            Toast.makeText(view.getContext(), "请输入数字", Toast.LENGTH_LONG).show();
                            chongzhi.setText("");
                        }
                    }
                    break;
            }
        }
    }

    @OnClick(R.id.four_button_pueren)
    public void onclick(){
        Intent intent=new Intent(getContext(), Main2Activity.class);
        startActivity(intent);
    }
}
