package com.example.yang.mymvpdemo.presenter;

import com.example.yang.mymvpdemo.bean.UserBean;
import com.example.yang.mymvpdemo.model.IUserModel;
import com.example.yang.mymvpdemo.model.UserModel;
import com.example.yang.mymvpdemo.view.IUserView;

/**
 * Created by yang on 2017/4/13.
 */

public class UserPresenter {
    private IUserView mUserView;
    private IUserModel mUserModel;

    public UserPresenter(IUserView view){
        mUserView =view;
        mUserModel=new UserModel();

    }

    public void saveUser(int id,String firstName,String lastName){
        mUserModel.setID(id);
        mUserModel.setFirstName(firstName);
        mUserModel.setLastName(lastName);
    }

    public void loadUser(int id){
        UserBean userBean=mUserModel.load(id);
        mUserView.setFirstName(userBean.getmFirstName());
        mUserView.setLastName(userBean.getmLastName());
    }

}
