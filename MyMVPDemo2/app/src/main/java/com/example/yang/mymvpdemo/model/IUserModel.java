package com.example.yang.mymvpdemo.model;

import com.example.yang.mymvpdemo.bean.UserBean;

/**
 * Created by yang on 2017/4/13.
 */

public interface IUserModel {
    void setID(int id);
    void setFirstName(String firstName);
    void setLastName(String lastName);
    UserBean load(int id);//接口中的方法没有具体实现，只是声明

}
