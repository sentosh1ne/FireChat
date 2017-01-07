package com.sentosh1ne.firechat.chat.presenter;

import com.sentosh1ne.firechat.chat.interactor.UserLogoutInteractor;
import com.sentosh1ne.firechat.chat.interactor.UserLogoutInteractorImpl;

/**
 * Created by sentosh1ne on 07.01.2017.
 */

public class UserLogoutPresenterImpl implements UserLogoutPresenter {
    private UserLogoutInteractor interactor;

    public UserLogoutPresenterImpl() {
        this.interactor = new UserLogoutInteractorImpl();
    }

    @Override
    public void removeFromRoom(String uid) {
        interactor.logout(uid);
    }
}
