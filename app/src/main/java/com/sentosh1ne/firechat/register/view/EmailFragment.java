package com.sentosh1ne.firechat.register.view;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.sentosh1ne.firechat.R;
import com.sentosh1ne.firechat.register.presenter.RegisterPresenterImpl;


import butterknife.BindView;
import butterknife.OnClick;

public class EmailFragment extends Fragment implements RegisterView {

    @BindView(R.id.progress_bar)
    private ProgressBar mProgressBar;
    @BindView(R.id.login_email_edit_text)
    private EditText mEmailEditText;
    @BindView(R.id.login_password_edit_text)
    private EditText mPasswordEditText;
    @BindView(R.id.register_button)
    private Button mRegisterButton;

    private RegisterPresenterImpl mPresenter;

    @Override
    public void onStart() {
        super.onStart();
        mPresenter = new RegisterPresenterImpl(this);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_email, container, false);
    }

    @Override
    public void onSuccess() {
        Toast.makeText(getActivity(), R.string.register_success, Toast.LENGTH_SHORT).show();
        getActivity().finish();
    }

    @Override
    public void onFailure() {
        Toast.makeText(getActivity(), R.string.register_failure, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void activateProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void stopProgressBar() {

    }

    @OnClick(R.id.register_button)
    public void onRegisterClick(){
        Bundle data = this.getArguments();
        mPresenter.onRequest(
                data.getString("username"),
                mEmailEditText.getText().toString(),
                mPasswordEditText.getText().toString(),
                data.getString("avatar")
        );
    }


    public static Fragment newInstance(Bundle data) {
        EmailFragment fragment = new EmailFragment();
        fragment.setArguments(data);
        return fragment;
    }
}
