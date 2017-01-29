package com.sentosh1ne.firechat.adapters.user;

import java.util.List;

import pojos.User;

/**
 * Created by sentosh1ne on 29.01.2017.
 */

public interface UsersOnlinePresenter {
    void getChildren(List<User> listOfUsers);
    void request();
}
