package com.example.yang.compassdemo;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

public class GraphicsActivity extends Activity {


    private static final boolean TEST_PICTURE=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void setContentView(View view) {

        if (TEST_PICTURE){
            ViewGroup vg=new PictureLayout(this);
            vg.addView(view);
            view=vg;

        }
        super.setContentView(view);
    }
}
