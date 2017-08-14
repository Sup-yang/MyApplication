package com.example.yang.wuxinghaoping;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {

    private ImageView imageView;
    private SensorManager manager;
    private SensorListener listener=new SensorListener();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imageView= (ImageView) findViewById(R.id.image_);
        imageView.setKeepScreenOn(true);
        manager= (SensorManager) getSystemService(Context.SENSOR_SERVICE);

    }


    @Override
    protected void onResume() {
        Sensor sensor=manager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        manager.registerListener(listener,sensor,SensorManager.SENSOR_DELAY_GAME);

        super.onResume();
    }

    @Override
    protected void onPause() {
        manager.unregisterListener(listener);
        super.onPause();
    }

    private final class SensorListener implements SensorEventListener{

        float[] valuess={0,90,180,270};
        private float predegree=0;
        @Override
        public void onSensorChanged(SensorEvent event) {
            /**
             * values[0]:
             * */
            float degree=event.values[0];
            RotateAnimation animation=new RotateAnimation(predegree,degree, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
            animation.setDuration(1000);
            imageView.startAnimation(animation);
            predegree=-degree;



        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    }
}
