package com.sentosh1ne.firechat.adapters.user;

import java.util.List;

import pojos.User;

/**
 * Created by sentosh1ne on 29.01.2017.
 */

public class UsersOnlinePresenterImpl implements UsersOnlinePresenter {

    private UsersOnlineView view;
    private UsersOnlineInteractor interactor;

    public UsersOnlinePresenterImpl(UsersOnlineView view) {
        this.view = view;
        this.interactor = new UsersOnlineInteractor(this);
    }

    @Override
    public void getChildren(List<User> listOfUsers) {
        view.addCurrentUsers(listOfUsers);
    }

    @Override
    public void request() {
        interactor.request();
    }
}
