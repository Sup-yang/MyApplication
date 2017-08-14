package com.example.yang.dengludemo;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.jude.utils.JUtils;

import net.anumbrella.customedittext.FloatLabelView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    private ProgressDialog mDialog;
    private String phone;
    private String password;
    private boolean prompt=false;
    private boolean checkUpResult=true;
    private String startUp;

    @BindView(R.id.btn_login)Button btn_login;
    @BindView(R.id.btn_register) Button btn_register;
    @BindView(R.id.forget_password)TextView forget_password;
    @BindView(R.id.btn_back)Button btn_back;
    @BindView(R.id.login_phone)FloatLabelView login_phone;
    @BindView(R.id.login_password)FloatLabelView login_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

    }


}
