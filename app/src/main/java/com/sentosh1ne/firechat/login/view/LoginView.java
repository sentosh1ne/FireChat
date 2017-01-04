package com.sentosh1ne.firechat.login.view;

/**
 * Created by sentosh1ne on 03.01.2017.
 */

public interface LoginView {
    void logIn(String username, String uid, String emoji);
    void onFailure();
    void spinProgressBar();
    void stopProgressBar();
}
