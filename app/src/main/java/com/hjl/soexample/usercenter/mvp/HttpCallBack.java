package com.hjl.soexample.usercenter.mvp;

import java.util.List;

/**
 * data:2018/12/12
 * author: HJL (磊)
 * function:
 */
public interface HttpCallBack {
    void onSuccess(String data);

    void onFaile(String msg);
}
