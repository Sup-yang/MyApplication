package baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.ui.gerenshezhi;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.DenLuActivity;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.MainActivity;
import baidu_ditu1.lenovo.example.com.awdawdas.dtanfgtiaxia.R;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by yang on 2017/3/24.
 * 设置界面的适配器
 */

public class SetListAdapter extends BaseAdapter {
    private final Context content;
    List<String> list =new ArrayList<>();
    public static final int TYPE_TITLE=0;
    public static final int TYPE_CONTENT=1;
    public static final int TYPE_BUTTON=2;
    LayoutInflater inflater;

    private static String path="/sdcard/myHead/";//sd路径

    public void add(List<String> list){
        this.list=list;
    }

    public SetListAdapter(Context context) {
        inflater=LayoutInflater.from(context);
        this.content=context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_TITLE;
        } else if (position ==9) {
            return TYPE_BUTTON;
        } else {
            return TYPE_CONTENT;
        }

    }
    @Override
    public int getViewTypeCount() {
        return list.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolders viewHolder;
        TitleHolder titleHolder;
        ButtonHolder buttonHolder;
        switch (getItemViewType(position)){
            case TYPE_TITLE://
                if (convertView==null){
                    titleHolder=new TitleHolder();
                    convertView=inflater.inflate(R.layout.set_title_item,null);
                    titleHolder.textViews= (TextView) convertView.findViewById(R.id.tv_setName);
                    titleHolder.imageViews= (ImageView) convertView.findViewById(R.id.set_title_imageViews);
                    convertView.setTag(titleHolder);
                }else {

                    titleHolder = (TitleHolder) convertView.getTag();
                }

                     SharedPreferences sp=convertView.getContext().getSharedPreferences("dataa",MODE_PRIVATE);

                    titleHolder.textViews.setText(sp.getString("kk",list.get(position).toString()));


                Bitmap bt = BitmapFactory.decodeFile(path + "heada.jpg");//从Sd中找头像，转换成Bitmap
                if(bt!=null){
                    @SuppressWarnings("deprecation")
                    Drawable drawable = new BitmapDrawable(toRoundBitmap(bt));//转换成drawable
                    titleHolder.imageViews.setImageDrawable(drawable);
                }else{
                    /**	如果SD里面没有则需要从服务器取头像，取回来的头像再保存在SD中*/
                    titleHolder.imageViews.setImageResource(R.mipmap.ic_launcher);
                }

                break;
            case TYPE_CONTENT:
                if (convertView==null){
                    viewHolder=new ViewHolders();
                    convertView=inflater.inflate(R.layout.set_list_item,null);
                    viewHolder.textView= (TextView) convertView.findViewById(R.id.tv_set_list_item);
                    viewHolder.imageView= (ImageView) convertView.findViewById(R.id.image_set_list_item);
                    convertView.setTag(viewHolder);
                }else {

                    viewHolder = (ViewHolders) convertView.getTag();
                }
                viewHolder.imageView.setVisibility(View.GONE);
                viewHolder.textView.setText(list.get(position));

                break;
            case TYPE_BUTTON:
                if (convertView==null){
                    buttonHolder=new ButtonHolder();
                    convertView=inflater.inflate(R.layout.set_button_item,null);
                    buttonHolder.button= (Button) convertView.findViewById(R.id.btn_set_out);

                    convertView.setTag(buttonHolder);
                }else {

                    buttonHolder = (ButtonHolder) convertView.getTag();
                }
                buttonHolder.button.setText("退出登录");
                buttonHolder.button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(content, DenLuActivity.class);
                        content.startActivity(intent);
                        MainActivity.main.finish();

                    }
                });


                break;

        }
        return convertView;
    }

    class TitleHolder{
        ImageView imageViews;
        TextView textViews;

    }
    class ViewHolders{
        ImageView imageView;
        TextView textView;

    }

    class ButtonHolder{
        Button button;

    }



    //裁剪图片（圆形）
    public Bitmap toRoundBitmap(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int r = 0;
        // 取最短边做边长
        if (width < height) {
            r = width;
        } else {
            r = height;
        }
        // 构建一个bitmap
        Bitmap backgroundBm = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        // new一个Canvas，在backgroundBmp上画图
        Canvas canvas = new Canvas(backgroundBm);
        Paint p = new Paint();
        // 设置边缘光滑，去掉锯齿
        p.setAntiAlias(true);
        RectF rect = new RectF(0, 0, r, r);
        // 通过制定的rect画一个圆角矩形，当圆角X轴方向的半径等于Y轴方向的半径时，
        // 且都等于r/2时，画出来的圆角矩形就是圆形
        canvas.drawRoundRect(rect, r / 2, r / 2, p);
        // 设置当两个图形相交时的模式，SRC_IN为取SRC图形相交的部分，多余的将被去掉
        p.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        // canvas将bitmap画在backgroundBmp上
        canvas.drawBitmap(bitmap, null, rect, p);
        return backgroundBm;
    }

}
