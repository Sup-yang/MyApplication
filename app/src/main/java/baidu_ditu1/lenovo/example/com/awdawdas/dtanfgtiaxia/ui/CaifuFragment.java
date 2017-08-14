package baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.DenLuActivity;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.Main2Activity;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.Main3Activity;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.MainActivity;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.R;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.Zhuanzhang_Activity;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.erweima.ErWeiMaActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.content.Context.MODE_PRIVATE;
import static baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.R.id.caifu_text_zhuanzhuang;

/**
 * 财富
 */

public class CaifuFragment extends Fragment {

    private View view;
    private String ZhiFuMiMa="";    //支付密码

    EditText editText_zhifumima;    //弹出框中的2个密码框
    private EditText editText_zhifumima_pueren;


    public static CaifuFragment newInstance() {
        CaifuFragment f = new CaifuFragment();
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_caifu, container, false);
        ButterKnife.bind(this,view);

        return view;
    }

    @OnClick({R.id.caifu_text_yenhangka,R.id.caifu_zhanghuyue,R.id.caifu_text_shofukuan,R.id.caifu_text_saoyisao,R.id.caifu_text_zhuanzhuang,R.id.caifu_text_jifen,R.id.caifu_text_jingbi,R.id.caifu_text_gowu,R.id.caifu_set_zhifumima})
    public void OnClick(View v){
        Intent intent;
        if (MainActivity.isdenlu) {
            switch (v.getId()) {
                case R.id.caifu_set_zhifumima:
                    //支付密码
                    intent = new Intent(view.getContext(), Main2Activity.class);
                    intent.putExtra("cc", "修改支付密码");
                    startActivity(intent);
                    break;
                case R.id.caifu_text_yenhangka:
                    //银行卡
                    intent = new Intent(view.getContext(), Main3Activity.class);
                    startActivity(intent);
                    break;
                case R.id.caifu_zhanghuyue:
                    //账户余额
                    intent = new Intent(view.getContext(), Main2Activity.class);
                    intent.putExtra("aa", 287);
                    intent.putExtra("cc", "账户余额");
                    startActivity(intent);
                    break;
                case R.id.caifu_text_shofukuan:
                    //收付款
                    intent = new Intent(view.getContext(), Main2Activity.class);
                    intent.putExtra("aa", 26);
                    intent.putExtra("cc", "收付款");
                    startActivity(intent);
                    break;
                case R.id.caifu_text_saoyisao:
                    //扫一扫
                    intent = new Intent(view.getContext(), ErWeiMaActivity.class);
                    startActivity(intent);
                    break;
                case R.id.caifu_text_jifen:
                    //积分
                    intent = new Intent(view.getContext(), Main2Activity.class);
                    intent.putExtra("aa", 254);
                    intent.putExtra("cc", "积分");
                    startActivity(intent);
                    break;
                case R.id.caifu_text_jingbi:
                    //金币
                    intent = new Intent(view.getContext(), Main2Activity.class);
                    intent.putExtra("aa", 255);
                    intent.putExtra("cc", "金币");
                    startActivity(intent);
                    break;
                case R.id.caifu_text_gowu:
                    //购物
                    intent = new Intent(view.getContext(), Main2Activity.class);
                    intent.putExtra("cc", "购物");
                    startActivity(intent);
                    break;
                case caifu_text_zhuanzhuang:
                    //转账
                    SharedPreferences spf = view.getContext().getSharedPreferences("data", MODE_PRIVATE);
                    ZhiFuMiMa = spf.getString("mima", "");

                    if (ZhiFuMiMa.equals("")) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                        View viewq = LayoutInflater.from(getContext()).inflate(R.layout.inflate_caifu_shezhimima, null);
                        editText_zhifumima = (EditText) viewq.findViewById(R.id.editText_item_zhifumima);
                        editText_zhifumima_pueren = (EditText) viewq.findViewById(R.id.editText_item_queren_zhifumima);
                        builder.setTitle("请设置支付密码");
                        builder.setView(viewq);
                        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String str_top = editText_zhifumima.getText().toString();
                                String str_buttom = editText_zhifumima_pueren.getText().toString();

                                if (str_top.length() == 6 && str_buttom.length() == 6) {
                                    if (str_top.equals(str_buttom)) {
                                        SharedPreferences sp = view.getContext().getSharedPreferences("data", MODE_PRIVATE);
                                        //获取编辑器；
                                        SharedPreferences.Editor editor = sp.edit();
                                        editor.putString("mima", str_top);
                                        Toast.makeText(getContext(), str_top, Toast.LENGTH_SHORT).show();
                                        // 启动；
                                        editor.commit();
                                    } else {
                                        Toast.makeText(getContext(), "两次密码不同", Toast.LENGTH_SHORT).show();
                                    }
                                } else {
                                    Toast.makeText(getContext(), "密码必须为6位", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
                        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                        builder.show();

                    } else {
                        //转账
                        intent = new Intent(view.getContext(), Zhuanzhang_Activity.class);
                        intent.putExtra("aa", 27);
                        intent.putExtra("cc", "好友转账");
                        startActivity(intent);
                    }
                    break;
            }
        }else {

            //登录界面
            intent = new Intent(getContext(), DenLuActivity.class);
            startActivity(intent);
        }
    }










}
