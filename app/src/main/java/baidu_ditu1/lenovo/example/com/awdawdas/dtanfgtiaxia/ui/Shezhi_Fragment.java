package baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui;


import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.Main2Activity;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.app.Activity.RESULT_OK;

/**
 * 个人设置
 * A simple {@link Fragment} subclass.
 */
public class Shezhi_Fragment extends Fragment {

    private View view,view1;
    @BindView(R.id.shezhi_text1_toxiang)
    TextView tx;
    private PopupWindow popupWindow;
    Window window;
    Button butt,butt1,butt2;




    private Bitmap head;//头像Bitmap
    private static String path="/sdcard/myHead/";//sd路径

    private Shezhi_Fragment(PopupWindow popupWindow, Window window,View popupView1) {
        this.popupWindow= popupWindow;
        this.window=window;
        view1=popupView1;
    }

    public static Shezhi_Fragment newinitFragm(PopupWindow popupWindow, Window window,View popupView1) {
        Shezhi_Fragment fragment=new Shezhi_Fragment(  popupWindow,window,popupView1);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_shezhi_, container, false);
        ButterKnife.bind(this,view);

        butt= (Button) view1.findViewById(R.id.cela_button_puxiao);
        butt1= (Button) view1.findViewById(R.id.cela_button_zhaoxiang);
        butt2= (Button) view1.findViewById(R.id.cela_button_xiangce);
        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        butt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String state = Environment.getExternalStorageState(); //拿到sdcard是否可用的状态码
                if (state.equals(Environment.MEDIA_MOUNTED)){   //如果可用

                    Intent intent2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    intent2.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(Environment.getExternalStorageDirectory(), "heada.jpg")));
                    startActivityForResult(intent2, 2);//采用ForResult打开
                }else {
                    Toast.makeText(getContext(),"sdcard不可用",Toast.LENGTH_SHORT).show();
                }
            }
        });
        butt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Intent.ACTION_PICK, null);
                intent1.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(intent1, 1);
            }
        });


        return view;

    }

    @OnClick({R.id.shezhi_text1_toxiang, R.id.shezhi_text2_zhanghao, R.id.shezhi_text3_xingmin, R.id.shezhi_text4_xingbie,
            R.id.shezhi_text5_shener, R.id.shezhi_text6_youxiang, R.id.shezhi_text7_shuji})
    public void onClick(View v){

        Intent intent;
        switch (v.getId()){
            case R.id.shezhi_text1_toxiang:
                //头像
                if(popupWindow!=null&&popupWindow.isShowing()){
                    popupWindow.dismiss();
                    setBackgroundAlpha(0.5f);
                }else if(popupWindow!=null){
                    //指定显示的位置
                    popupWindow.showAsDropDown(tx,0,480);
                    setBackgroundAlpha(0.5f);
                }

                break;
            case R.id.shezhi_text2_zhanghao:
                //账号
                intent=new Intent(view.getContext(), Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.shezhi_text3_xingmin:
                intent=new Intent(view.getContext(), Main2Activity.class);
                intent.putExtra("aa",333);
                intent.putExtra("cc","姓名");
                startActivity(intent);
                break;
            case R.id.shezhi_text4_xingbie:
                //性别
                intent=new Intent(view.getContext(), Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.shezhi_text5_shener:
                //生日
                intent=new Intent(view.getContext(), Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.shezhi_text6_youxiang:
                //邮箱
                intent=new Intent(view.getContext(), Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.shezhi_text7_shuji:
                //手机号
                intent=new Intent(view.getContext(), Main2Activity.class);
                intent.putExtra("aa",430);
                intent.putExtra("cc","手机号");
                startActivity(intent);
                break;

        }

    }



    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    cropPhoto(data.getData());//裁剪图片
                }

                break;
            case 2:
                if (resultCode == RESULT_OK) {
                    File temp = new File(Environment.getExternalStorageDirectory() + "/heada.jpg");
                    cropPhoto(Uri.fromFile(temp));//裁剪图片
                }
                break;
            case 3:
                if (data != null) {
                    Bundle extras = data.getExtras();
                    head = extras.getParcelable("data");
                    if(head!=null){
                        /**上传服务器代码*/
                        setPicToView(head);//保存在SD卡中
                    }
                }
                break;
            default:
                break;

        }
        super.onActivityResult(requestCode, resultCode, data);
    };

    /**
     * 调用系统的裁剪
     * @param uri
     */
    public void cropPhoto(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 150);
        intent.putExtra("outputY", 150);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, 3);
    }

    private void setPicToView(Bitmap mBitmap) {
        String sdStatus = Environment.getExternalStorageState();
        if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) { // 检测sd是否可用
            return;
        }
        FileOutputStream b = null;
        File file = new File(path);
        file.mkdirs();// 创建文件夹
        String fileName =path + "heada.jpg";//图片名字
        try {
            b = new FileOutputStream(fileName);
            mBitmap.compress(Bitmap.CompressFormat.JPEG, 100, b);// 把数据写入文件

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭流
                b.flush();
                b.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    //设置屏幕背景透明效果
    public void setBackgroundAlpha(float alpha) {
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.alpha = alpha;
        window.setAttributes(lp);
    }
}
