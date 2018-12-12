package com.hjl.soexample.usercenter.mvp.presenter;

import com.hjl.soexample.usercenter.mvp.HttpCallBack;
import com.hjl.soexample.usercenter.mvp.model.LoginModel;
import com.hjl.soexample.usercenter.mvp.view.LoginView;

/**
 * data:2018/12/12
 * author: HJL (磊)
 * function:
 */
public class LoginPresenter {
    private LoginView loginView;
    private LoginModel loginModel;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
        loginModel = new LoginModel();
    }

    public void login(String phone, String pwd) {
        loginModel.login(phone, pwd, new HttpCallBack() {
            @Override
            public void onSuccess(String data) {
                loginView.onSuccess(data);
            }

            @Override
            public void onFaile(String msg) {
                loginView.onFaile(msg);
            }
        });
    }


}
