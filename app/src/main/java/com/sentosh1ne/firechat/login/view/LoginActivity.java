package com.sentosh1ne.firechat.login.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.sentosh1ne.firechat.R;
import com.sentosh1ne.firechat.chat.ChatActivity;
import com.sentosh1ne.firechat.login.presenter.LoginPresenterImpl;
import com.sentosh1ne.firechat.util.NetworkConstants;

import butterknife.BindView;
import butterknife.ButterKnife;
import pojos.User;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener,LoginView{

    @BindView(R.id.progress_bar)
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
        ButterKnife.bind(this);
        setContentView(R.layout.activity_login);
        setEvents();
    }

    @Override
    public void onClick(View view) {
        mPresenter.receiveUserLogin(mEmailEditText.getText().toString(),
                mPasswordEditText.getText().toString()
        );
    }

    @Override
    public void logIn(String username, String uid, String emoji) {
        User user = new User(username,uid,emoji);
        Intent i = new Intent(this,ChatActivity.class);
        i.putExtra("credentials",NetworkConstants.INSTANCE.getGson().toJson(user));
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
