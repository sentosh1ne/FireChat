package com.sentosh1ne.firechat.register.presenter;


import com.sentosh1ne.firechat.register.interactor.UniqueUserInteractor;
import com.sentosh1ne.firechat.register.interactor.UniqueUserInteractorImpl;
import com.sentosh1ne.firechat.register.view.UserFragmentView;
import com.sentosh1ne.firechat.util.NetworkConstants;

/**
 * Created by sentosh1ne on 06.01.2017.
 */

public class UniqueUserPresenterImpl implements UniqueUserPresenter {
    private UserFragmentView mUsernameFragmentView;
    private  UniqueUserInteractor mInteractor;

    public UniqueUserPresenterImpl(UserFragmentView view) {
        this.mUsernameFragmentView = view;
        this.mInteractor = new UniqueUserInteractorImpl(this);
    }

    @Override
    public void nameExists(String username) {
        mInteractor.nameExists(username);
    }

    @Override
    public void onExists() {
        mUsernameFragmentView.onFailure();
    }

    @Override
    public void onAbscent() {
        mUsernameFragmentView.onSuccess();
    }
}
