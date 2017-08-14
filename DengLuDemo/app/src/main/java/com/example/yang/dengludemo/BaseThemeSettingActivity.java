package com.example.yang.dengludemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.jude.utils.JUtils;
import net.anumbrella.customedittext.R;
/**
 * Created by yang on 2017/4/14.
 */

public class BaseThemeSettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCustomTheme();
    }

    private void setCustomTheme(){
        int theme = JUtils.getSharedPreference().getInt("THEME",0);
        switch (theme){
            case 1:
                setTheme(R.style.AppTheme1);
        }

    }
}
