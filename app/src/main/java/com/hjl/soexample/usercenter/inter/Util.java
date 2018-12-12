package com.hjl.soexample.usercenter.inter;

import com.hjl.soexample.usercenter.bean.LoginBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * data:2018/12/12
 * author: HJL (磊)
 * function:
 */
public interface Util {
//    @GET("login/")
//    Observable<LoginBean> getListener(@Query("mobile") String mobile, @Query("password") String password);

    @POST("login")
    @FormUrlEncoded
    Observable<LoginBean> getLogin(@Field("phone") String phone, @Field("pwd") String pwd);


}
