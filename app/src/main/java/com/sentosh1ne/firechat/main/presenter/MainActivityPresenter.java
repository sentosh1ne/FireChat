package com.sentosh1ne.firechat.main.presenter;

/**
 * Created by sentosh1ne on 03.01.2017.
 */

public interface MainActivityPresenter {
    void receiveRequest();

    String getNumberOfUsers(long numberOfUsers);

    void sendNumberOfChildren(long number);
}
