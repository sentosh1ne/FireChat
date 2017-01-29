package com.sentosh1ne.firechat.adapters.user;

import java.util.List;

import pojos.User;

/**
 * Created by sentosh1ne on 29.01.2017.
 */

public interface UsersOnlineView {
    void addCurrentUsers(List<User> users);
    void request();
}
