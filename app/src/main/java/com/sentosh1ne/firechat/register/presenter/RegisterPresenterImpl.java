package com.sentosh1ne.firechat.register.presenter;

import com.sentosh1ne.firechat.register.interactor.RegistartionInteractorImpl;
import com.sentosh1ne.firechat.register.interactor.RegistrationInteractor;
import com.sentosh1ne.firechat.register.view.RegisterView;

/**
 * Created by sentosh1ne on 05.01.2017.
 */

public class RegisterPresenterImpl implements RegisterPresenter{
    private  RegisterView mRegisterView;
    private  RegistrationInteractor mInteractor;

    public RegisterPresenterImpl(RegisterView registerView) {
        this.mRegisterView = registerView;
        this.mInteractor = new RegistartionInteractorImpl(this);
    }

    @Override
    public void onSuccess() {
        mRegisterView.onSuccess();
        mRegisterView.stopProgressBar();
    }

    @Override
    public void onFailed() {
        mRegisterView.onFailure();
        mRegisterView.stopProgressBar();
    }

    @Override
    public void onRequest(String userName, String email, String password, String avatar) {
        mInteractor.register(userName,email,password,avatar);
        mRegisterView.activateProgressBar();
    }
}
