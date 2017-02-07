package com.sentosh1ne.firechat.login.view;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.sentosh1ne.firechat.R;
import com.sentosh1ne.firechat.chat.view.ChatActivity;
import com.sentosh1ne.firechat.login.presenter.LoginPresenterImpl;
import com.sentosh1ne.firechat.util.NetworkConstants;

import butterknife.BindView;
import butterknife.ButterKnife;
import pojos.User;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, LoginView{

    @BindView(R.id.progress_bar_login)
    @Nullable
    ProgressBar mProgressBar;
    @BindView(R.id.login_email_edit_text)
    EditText mEmailEditText;
    @BindView(R.id.login_password_edit_text)
    EditText mPasswordEditText;
    @BindView(R.id.login_button)
    Button mLoginButton;

    private LoginPresenterImpl mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        Firebase.setAndroidContext(this);
        setEvents();
        mPresenter = new LoginPresenterImpl(this);
    }

    @Override
    public void onClick(View view) {
        mPresenter.receiveUserLogin(mEmailEditText.getText().toString(),
                mPasswordEditText.getText().toString()
        );
    }

    @Override
    public void logIn(String username, String uid, String avatar) {
        User user = new User(username, uid, avatar);
        Intent i = new Intent(this,ChatActivity.class);
        String json = NetworkConstants.INSTANCE.getGson().toJson(user);
        Log.i("JSON", json);
        i.putExtra("credentials", json);
        startActivity(i);
    }

    @Override
    public void onFailure() {
        Toast.makeText(this, R.string.on_failure_message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void spinProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void stopProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

    private void setEvents(){
        mLoginButton.setOnClickListener(this);
    }
}
