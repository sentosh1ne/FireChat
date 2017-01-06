package com.sentosh1ne.firechat.main.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.sentosh1ne.firechat.R;
import com.sentosh1ne.firechat.login.view.LoginActivity;
import com.sentosh1ne.firechat.main.presenter.MainActivityPresenterImpl;
import com.sentosh1ne.firechat.register.view.RegisterActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainView{

    @BindView(R.id.current_number_of_users_text_view)
    TextView mUsersOnlineText;
    @BindView(R.id.login_button)
    Button mLoginButton;
    @BindView(R.id.register_button)
    Button mRegisterButton;

    private MainActivityPresenterImpl mPresenter;

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter = new MainActivityPresenterImpl(this);
        mPresenter.receiveRequest();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);
        setUI();
    }


    @OnClick(R.id.login_button)
    void loginUser(){
        startActivity(new Intent(this, LoginActivity.class));
    }

    @OnClick(R.id.register_button)
    void startRegistration(){
        startActivity(new Intent(this, RegisterActivity.class));
    }


    @Override
    public void setNumberOfUsers(String numberOfUsers) {
        mUsersOnlineText.setText(numberOfUsers);
    }

    private void setUI() {
        mLoginButton.setOnClickListener(this);
        mRegisterButton.setOnClickListener(this);
    }
}
