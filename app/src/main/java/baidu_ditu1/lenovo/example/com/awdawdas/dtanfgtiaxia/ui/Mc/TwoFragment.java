package baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.Mc;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class TwoFragment extends Fragment {


    private View view,view1;
    private PopupWindow popupWindow;
    Window window;
    @BindView(R.id.tow_button_shenchen) Button button;

    Bitmap bitmap;
    @BindView(R.id.tow_btn_pay_receive)Button btn_receive;
    @BindView(R.id.tow_btn_pay_send)Button btn_send;
    @BindView(R.id.tow_edt_payment)EditText edt_payment;
     ImageView iage;

    private TwoFragment(PopupWindow mPopupWindow, Window window, View popupView1, WindowManager windowManager) {
        this.popupWindow= mPopupWindow;
        this.window=window;
        view1=popupView1;
    }


    public static TwoFragment newiniter(PopupWindow mPopupWindow, Window window, View popupView1, WindowManager windowManager) {
        TwoFragment oneFragment=new TwoFragment( mPopupWindow,  window,popupView1,windowManager);
        return oneFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_two, container, false);
        ButterKnife.bind(this,view);

        iage= (ImageView) view1.findViewById(R.id.shofukuan_er_weima);

        return view;
    }

    @OnClick(R.id.tow_button_shenchen)
    public void OnClick(){
        if (edt_payment.getText().toString()!=null&&!edt_payment.getText().toString().equals("")){
            try {

                if(popupWindow!=null&&popupWindow.isShowing()){
                    popupWindow.dismiss();
                }else if(popupWindow!=null){
                    popupWindow.showAsDropDown(button,0,0);
                    setBackgroundAlpha(0.5f);
                    iage.setImageBitmap(Create2DCode(edt_payment.getText().toString()));
                }
            } catch (WriterException e) {
                e.printStackTrace();
            }

        }else {
            Toast.makeText(view.getContext(),"金额不能为空",Toast.LENGTH_LONG).show();
        }
    }

    /**
     * android生成二维码的核心代码
     * 将一段字符变成二维码，通过调用第三方包zxing来实现，
     * @param str
     * @return
     * @throws WriterException
     */
    public Bitmap Create2DCode(String str) throws WriterException {
        //生成二维矩阵,编码时要指定大小,不要生成了图片以后再进行缩放,以防模糊导致识别失败
        BitMatrix matrix = new MultiFormatWriter().encode(str,BarcodeFormat.QR_CODE,400,400);
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        // 二维矩阵转为一维像素数组（一直横着排）
        int[] pixels = new int[width * height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if(matrix.get(x, y)){
                    pixels[y * width + x] = 0xff000000;
                }
            }
        }
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        // 通过像素数组生成bitmap,具体参考api
        bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
        return bitmap;
    }

    //设置屏幕背景透明效果
    public void setBackgroundAlpha(float alpha) {
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.alpha = alpha;
        window.setAttributes(lp);
    }


}
