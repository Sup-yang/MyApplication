package com.example.yang.photodemo;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {
private final String IMAGE_TYPE="image/*";
    private  final int IMAGE_CONE=0;
    private Button chosse;
    private ImageView imageshow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        chosse= (Button) findViewById(R.id.button);
        imageshow= (ImageView) findViewById(R.id.image_show);
        chosse.setOnClickListener(listener);

    }

    private View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
           // setImage();
//            Intent intent=new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            //跳转到本地相册

            Intent intent=new Intent(Intent.ACTION_PICK,MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
//            intent.putExtra(MediaStore.)
            startActivityForResult(intent,IMAGE_CONE);
            //带请求结果的启动跳转方式
            //在返回结果的onActivityResult方法中接受请求码 IMAGE_GONE

        }
    };

    private void setImage() {
        Intent getAlbum=new Intent(Intent.ACTION_GET_CONTENT);
        getAlbum.setType(IMAGE_TYPE);
        startActivityForResult(getAlbum,IMAGE_CONE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Bitmap bm;
        ContentResolver resolver=getContentResolver();

        if (requestCode==IMAGE_CONE){


            try {
                Uri uri=data.getData();


                Glide.with(MainActivity.this).load(uri).into(imageshow);
//                Glide.with(MainActivity.this).load(uri).diskCacheStrategy(DiskCacheStrategy.NONE).transform(new ConnerTransform(MainActivity.this)).override(100,100).into(imageshow);
                //加载普通图片

//                Glide.with(MainActivity.this).load(uri).asGif().diskCacheStrategy(DiskCacheStrategy.NONE).into(imageshow);
                //加载Gif格式图片
                bm= MediaStore.Images.Media.getBitmap(resolver,uri);
//                imageshow.setImageBitmap(bm);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
