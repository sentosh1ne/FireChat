package com.sentosh1ne.firechat.register.presenter;

/**
 * Created by sentosh1ne on 06.01.2017.
 */

public interface UniqueUserPresenter {
    void ifAlreadyExists(String username);
    void onExists();
    void onAbscent();
}
