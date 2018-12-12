package com.hjl.soexample.usercenter.net;

import android.graphics.Paint;

import com.hjl.soexample.usercenter.inter.Path;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * data:2018/12/12
 * author: HJL (磊)
 * function:
 */
public class HttpUtil {

    private static HttpUtil instance;
    private final Retrofit retrofit;

    private HttpUtil() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(3000, TimeUnit.MILLISECONDS)
                .writeTimeout(3000, TimeUnit.MILLISECONDS)
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(Path.PATH_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

    }

    public static HttpUtil getInstance() {
        if (instance == null) {
            synchronized (HttpUtil.class) {
                if (instance == null) {
                    instance = new HttpUtil();
                }
            }
        }
        return instance;
    }

    public <T> T Create(Class<T> clazz) {
        return retrofit.create(clazz);
    }


}
