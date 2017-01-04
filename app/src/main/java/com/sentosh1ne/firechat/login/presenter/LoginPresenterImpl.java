package com.sentosh1ne.firechat.login.presenter;

import com.sentosh1ne.firechat.login.interactor.LoginInteractor;
import com.sentosh1ne.firechat.login.interactor.LoginInteractorImpl;
import com.sentosh1ne.firechat.login.view.LoginView;

/**
 * Created by sentosh1ne on 03.01.2017.
 */

public class LoginPresenterImpl implements LoginPresenter {
    private final LoginView loginView;
    private final LoginInteractor interactor;

    public LoginPresenterImpl(LoginView view) {
        this.loginView = view;
        interactor = new LoginInteractorImpl(this);
    }

    @Override
    public void receiveUserLogin(String email, String password) {

    }

    @Override
    public void onFailed() {

    }

    @Override
    public void onSuccess(String userId, String user, String avatar) {

    }
}
