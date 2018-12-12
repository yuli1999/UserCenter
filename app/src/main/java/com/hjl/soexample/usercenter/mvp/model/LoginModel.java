package com.hjl.soexample.usercenter.mvp.model;

import android.annotation.SuppressLint;

import com.hjl.soexample.usercenter.bean.LoginBean;
import com.hjl.soexample.usercenter.inter.Util;
import com.hjl.soexample.usercenter.mvp.HttpCallBack;
import com.hjl.soexample.usercenter.net.HttpUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * data:2018/12/12
 * author: HJL (磊)
 * function:
 */
public class LoginModel {


    //登录
    @SuppressLint("CheckResult")
    public void login(String phone, String pwd, final HttpCallBack callBack) {
        Util create = HttpUtil.getInstance().Create(Util.class);

        create.getLogin(phone, pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginBean>() {
                    @Override
                    public void accept(LoginBean loginBean) throws Exception {
                        if (loginBean != null) {
                            if (loginBean.getStatus().equals("0000")) {
                                callBack.onSuccess(loginBean.getMessage());
                            } else {
                                callBack.onFaile(loginBean.getMessage());
                            }
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        callBack.onFaile("失败");
                    }
                });


    }

}
