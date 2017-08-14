package baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.zhifu;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.Main2Activity;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.R;

import static baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.zhifu.ChatActivity.JINE;

public class ZhiFuActivity extends AppCompatActivity implements View.OnClickListener {
    PopupWindow popupWindow_top;
    PopupWindow popupWindow_buttom;

    Button button;
    EditText editText;

    ImageView imageView_hidepopupwindow;
    ImageView imageView_delectnumber;
    TextView textView_tuichutwopopupwindow;
    TextView textView_wangjimima;

    WindowManager wm;
    int width=0;
    int height = 0;

    private  int count=0; //记录当前画多少个圆
    private String number_mima="";  //记录密码

    TextView textviews[]=new TextView[10];
    ImageView images[] = new ImageView[6];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhi_fu);
        editText= (EditText) findViewById(R.id.edt_dialogTransfer);
        button = (Button) findViewById(R.id.button_main_tan);
        button.setOnClickListener(this);
        wm=this.getWindowManager();
        width = wm.getDefaultDisplay().getWidth();
        height= wm.getDefaultDisplay().getHeight();

    }

    private boolean popupwindow_isopen=false;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_main_tan:
                showpopupwindowone();
                showpopupwindowtwo();
                popupwindow_isopen = true;
                JINE= Integer.parseInt(editText.getText().toString());
                break;
            /**
             * 上方6个按钮显示上方的popupwindow
             */
            case R.id.image_one:
            case R.id.image_two:
            case R.id.image_three:
            case R.id.image_four:
            case R.id.image_five:
            case R.id.image_six:
                if(popupwindow_isopen==false){
                    showpopupwindowtwo();
                    popupwindow_isopen = true;
                }
                break;
            /**
             * 隐藏下面的popupwindow
             */
            case R.id.hide_popupwindow:
                popupWindow_buttom.dismiss();
                popupwindow_isopen = false;
                break;
            /**
             * 点击数字0到9
             */
            case R.id.number_zero:
                handler.sendEmptyMessage(0);
                break;
            case R.id.number_one:
                handler.sendEmptyMessage(1);
                break;
            case R.id.number_two:
                handler.sendEmptyMessage(2);
                break;
            case R.id.number_three:
                handler.sendEmptyMessage(3);
                break;
            case R.id.number_four:
                handler.sendEmptyMessage(4);
                break;
            case R.id.number_five:
                handler.sendEmptyMessage(5);
                break;
            case R.id.number_six:
                handler.sendEmptyMessage(6);
                break;
            case R.id.number_seven:
                handler.sendEmptyMessage(7);
                break;
            case R.id.number_eight:
                handler.sendEmptyMessage(8);
                break;
            case R.id.number_nine:
                handler.sendEmptyMessage(9);
                break;
            /**
             * 退出2个popupwindow
             */
            case R.id.tuichu_twopopupwindow:
                count = 0;
                number_mima = "";
                popupWindow_top.dismiss();
                popupWindow_buttom.dismiss();
                popupwindow_isopen = false;
                backgroundAlpha(1f);
                break;

            /**
             * 删除数字
             */
            case R.id.number_delect:
                handler.sendEmptyMessage(10);
                break;
            case R.id.textview_wangjimima:
                Intent intent=new Intent(ZhiFuActivity.this, Main2Activity.class);

                startActivity(intent);
                break;
            default:
                break;
        }
    }
    /**
     * 画圆的方法
     */
    protected void huayuan(String str){
        if (count<6) {
            count++;
            for (int i = 0; i < count; i++) {
                images[i].setImageResource(R.drawable.ic_brightness_1_black_24dp);
            }
            number_mima = number_mima + str;
            if(count==6){
                Toast.makeText(ZhiFuActivity.this,number_mima , Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    huayuan(0 + "");
                    break;
                case 1:
                    huayuan(1 + "");
                    break;
                case 2:
                    huayuan(2 + "");
                    break;
                case 3:
                    huayuan(3 + "");
                    break;
                case 4:
                    huayuan(4 + "");
                    break;
                case 5:
                    huayuan(5 + "");
                    break;
                case 6:
                    huayuan(6 + "");
                    break;
                case 7:
                    huayuan(7 + "");
                    break;
                case 8:
                    huayuan(8 + "");
                    break;
                case 9:
                    huayuan(9 + "");
                    break;
                case 10:
                    if (count>0){
                        count--;
                        for (int i = 0; i <=count ; i++) {
                            images[i].setImageResource(R.drawable.image_white);
                        }
                        for (int i = 0; i <count ; i++) {
                            images[i].setImageResource(R.drawable.ic_brightness_1_black_24dp);
                        }
                        number_mima = number_mima.substring(0,count);
                        Toast.makeText(ZhiFuActivity.this, number_mima, Toast.LENGTH_SHORT).show();
                    }
                    break;
                default:
                    break;
            }
        }
    };

    private void showpopupwindowone() {
        View view_top = LayoutInflater.from(this).inflate(R.layout.alertdialog,null);
        int imagesid[] = {R.id.image_one,R.id.image_two,R.id.image_three,R.id.image_four,R.id.image_five,R.id.image_six};
        for (int i = 0; i <images.length ; i++) {
            images[i] = (ImageView) view_top.findViewById(imagesid[i]);
            images[i].setOnClickListener(this);
        }
        textView_wangjimima = (TextView) view_top.findViewById(R.id.textview_wangjimima);
        textView_wangjimima.setOnClickListener(this);
        textView_tuichutwopopupwindow = (TextView) view_top.findViewById(R.id.tuichu_twopopupwindow);
        textView_tuichutwopopupwindow.setOnClickListener(this);

        popupWindow_top = new PopupWindow(view_top, width*8/10, height*7/20);  //宽高height*3/10
        popupWindow_top.setContentView(view_top);
        View rootview = LayoutInflater.from(this).inflate(R.layout.alertdialog, null);
        popupWindow_top.showAtLocation(rootview, Gravity.TOP, 0, height*4/25);  //设置在中间

    }

    public void showpopupwindowtwo(){
        View view_buttom = LayoutInflater.from(this).inflate(R.layout.popupwindow,null);
        int textviewsid[] = {R.id.number_zero,R.id.number_one,R.id.number_two,R.id.number_three,R.id.number_four,R.id.number_five,R.id.number_six,R.id.number_seven,R.id.number_eight,R.id.number_nine,};
        for (int i = 0; i <textviews.length ; i++) {
            textviews[i] = (TextView) view_buttom.findViewById(textviewsid[i]);
            textviews[i].setOnClickListener(this);
        }
        imageView_delectnumber = (ImageView) view_buttom.findViewById(R.id.number_delect);
        imageView_delectnumber.setOnClickListener(this);
        imageView_hidepopupwindow = (ImageView) view_buttom.findViewById(R.id.hide_popupwindow);
        imageView_hidepopupwindow.setOnClickListener(this);

        popupWindow_buttom = new PopupWindow(view_buttom, width, height*37/100);  //宽高
        popupWindow_buttom.setContentView(view_buttom);
        View rootview = LayoutInflater.from(this).inflate(R.layout.popupwindow, null);

        popupWindow_buttom.showAtLocation(rootview, Gravity.BOTTOM, 0, 0);  //设置在中间
        backgroundAlpha(0.2f);
    }

    /**
     * 设置添加屏幕的背景透明度
     * @param bgAlpha
     */
    public void backgroundAlpha(float bgAlpha)
    {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = bgAlpha;     //0.0-1.0
        getWindow().setAttributes(lp);
    }

}
