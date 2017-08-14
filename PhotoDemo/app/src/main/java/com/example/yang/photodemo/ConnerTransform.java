package com.example.yang.photodemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

/**
 * Created by yang on 2017/4/17.
 */

public class ConnerTransform extends BitmapTransformation {

    private float radius;

    public ConnerTransform(Context context) {
        super(context);
//        radius=100;//固定圆角的视图
    }
    public ConnerTransform(Context context,float radius){

        super(context);
        this.radius=radius;//可以自定义圆角大小的视图
    }

    @Override
    protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
        return conersCrop(pool,toTransform);
    }

    private Bitmap conersCrop(BitmapPool pool,Bitmap source){
        if (source==null){
            return null;

        }
//        Bitmap result=pool.get(source.getWidth(),source.getHeight(),Bitmap.Config.ARGB_8888);
//        if (result==null){
//            result=Bitmap.createBitmap(source.getWidth(),source.getHeight(), Bitmap.Config.ARGB_8888);
//        }
//        Canvas canvas=new Canvas(result);
//        Paint paint=new Paint();
//        paint.setShader(new BitmapShader(source,BitmapShader.TileMode.CLAMP,BitmapShader.TileMode.CLAMP));
//        paint.setAntiAlias(true);
//        RectF rectF=new RectF(0f,0f,source.getWidth(),source.getHeight());
//        canvas.drawRoundRect(rectF,radius,radius,paint);
        int size=Math.min(source.getWidth(),source.getHeight());
        int x,y;
        Bitmap squared;
        if (source.getWidth()<source.getHeight()){
        x=(source.getWidth()-size)/2;
        y=(source.getHeight()-size)/2;

        squared=Bitmap.createBitmap(source,x,y,size,size);
        }
        else {
            x=(source.getHeight()-size)/2;
            y=(source.getWidth()-size)/2;
            squared=Bitmap.createBitmap(source,x,y,size,size);

        }
        Bitmap result=pool.get(size,size, Bitmap.Config.ARGB_8888);
        if (result==null){
            result=Bitmap.createBitmap(size,size, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas=new Canvas(result);
        Paint paint=new Paint();

        paint.setShader(new BitmapShader(squared,BitmapShader.TileMode.CLAMP,BitmapShader.TileMode.CLAMP));
        paint.setAntiAlias(true);
        float r=size/2f;
        canvas.drawCircle(r,r,r,paint);
        return result;

    }

    @Override
    public String getId() {
        return getClass().getName();
    }
}
