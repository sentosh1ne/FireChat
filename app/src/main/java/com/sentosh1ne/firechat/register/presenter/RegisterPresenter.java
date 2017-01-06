package com.sentosh1ne.firechat.register.presenter;

/**
 * Created by sentosh1ne on 05.01.2017.
 */

public interface RegisterPresenter {
    void onSuccess();

    void onFailed();

    void onRequest(String userName,String email,String password,String avatar);
}
