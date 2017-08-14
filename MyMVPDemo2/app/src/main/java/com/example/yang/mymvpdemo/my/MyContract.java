package com.example.yang.mymvpdemo.my;

import android.content.Context;

import com.example.yang.mymvpdemo.mvp.BasePresenter;
import com.example.yang.mymvpdemo.mvp.BaseView;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class MyContract {
    interface View extends BaseView {
        
    }

    interface  Presenter extends BasePresenter<View> {
        
    }
}
