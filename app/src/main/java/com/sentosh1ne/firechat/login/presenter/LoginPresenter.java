package com.sentosh1ne.firechat.login.presenter;

/**
 * Created by sentosh1ne on 03.01.2017.
 */

public interface LoginPresenter {
    void receiveUserLogin(String email, String password);
    void onFailed();
    void onSuccess(String userId,String user, String avatar);
}
