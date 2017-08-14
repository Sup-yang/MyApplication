package com.example.yang.compassdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends GraphicsActivity {

    private static final String TAG="Compass";
    private SensorManager sensorManager;
    private Sensor sensor;
    private SamplView view;
    private float [] values;

    private final SensorEventListener listener=new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            if (false) Log.d(TAG,
                    "sensorChanged (" + event.values[0] + ", " + event.values[1] + ", " + event.values[2] + ")");

            values=event.values;
            if (view!=null){
                view.invalidate();
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sensorManager= (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor=sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        view=new SamplView(this);


        setContentView(view);
    }

    @Override
    protected void onResume() {

        if (false) Log.d(TAG,
                "onresume");
        super.onResume();

        sensorManager.registerListener(listener,sensor,SensorManager.SENSOR_DELAY_GAME);

    }

    @Override
    protected void onStop() {

        sensorManager.unregisterListener(listener);
        super.onStop();
    }

    private class SamplView extends View{
        private Paint paint=new Paint();
        private Path path=new Path();
        private  boolean animate;

        //绘制箭头效果
        public SamplView(Context context) {
            super(context);
            path.moveTo(0,-50);
            path.lineTo(-50,80);
            path.lineTo(0,30);
            path.lineTo(50,80);
            path.close();


        }

        @Override
        protected void onDraw(Canvas canvas) {
            Paint paints=paint;
            canvas.drawColor(Color.WHITE);
            paints.setAntiAlias(true);
            paints.setColor(Color.BLACK);
            paints.setStyle(Paint.Style.FILL);
            int w=canvas.getWidth();
            int h=canvas.getHeight();
            int cx=w/2;
            int cy=h/2;

            canvas.translate(cx,cy);
            if (values!=null){
                canvas.rotate((-values[0]));
            }

            canvas.drawPath(path,paint);
        }

        @Override
        protected void onAttachedToWindow() {

            animate=true;
            super.onAttachedToWindow();
        }

        @Override
        protected void onDetachedFromWindow() {
            animate=false;
            super.onDetachedFromWindow();
        }
    }
}
