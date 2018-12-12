package com.hjl.soexample.usercenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hjl.soexample.usercenter.mvp.presenter.LoginPresenter;
import com.hjl.soexample.usercenter.mvp.view.LoginView;

public class MainActivity extends AppCompatActivity implements LoginView {

    private EditText mLoginMobile;
    private EditText mLoginPassword;
    private Button mLogin;
    private Button mRegister;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        loginPresenter = new LoginPresenter(this);
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = mLoginMobile.getText().toString().trim();
                String pwd = mLoginPassword.getText().toString().trim();
                loginPresenter.login(phone, pwd);
            }
        });
    }

    private void initView() {
        mLoginMobile = findViewById(R.id.login_mobile);
        mLoginPassword = findViewById(R.id.login_password);
        mLogin = findViewById(R.id.login);
        mRegister = findViewById(R.id.register);
    }

    @Override
    public void onSuccess(String data) {
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onFaile(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
