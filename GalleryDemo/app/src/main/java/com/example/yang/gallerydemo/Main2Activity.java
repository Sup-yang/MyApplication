package com.example.yang.gallerydemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.gjiazhe.panoramaimageview.GyroscopeObserver;
import com.gjiazhe.panoramaimageview.PanoramaImageView;

public class Main2Activity extends AppCompatActivity {

    GyroscopeObserver gyroscopeObserver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        gyroscopeObserver=new GyroscopeObserver();

        PanoramaImageView panoramaImageView= (PanoramaImageView) findViewById(R.id.pan2);
        panoramaImageView.setGyroscopeObserver(gyroscopeObserver);



    }

    @Override
    protected void onResume() {
        super.onResume();
        gyroscopeObserver.register(this);

    }

    @Override
    protected void onPause() {
        super.onPause();
        gyroscopeObserver.unregister();
    }
}
