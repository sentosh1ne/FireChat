package com.sentosh1ne.firechat.login.interactor;

import java.util.Map;

/**
 * Created by sentosh1ne on 03.01.2017.
 */

public interface LoginInteractor {
    void loginWithEmail(String email,String password);

    Map<String,Object> createUser(String user, String avatar, String uid);
}
