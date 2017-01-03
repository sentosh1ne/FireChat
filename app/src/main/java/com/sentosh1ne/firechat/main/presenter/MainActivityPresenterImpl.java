package com.sentosh1ne.firechat.main.presenter;

import com.sentosh1ne.firechat.main.interactor.MainInteractor;
import com.sentosh1ne.firechat.main.interactor.MainInteractorImpl;
import com.sentosh1ne.firechat.main.view.MainView;

/**
 * Created by sentosh1ne on 03.01.2017.
 */

public class MainActivityPresenterImpl implements MainActivityPresenter {

    private final MainView mainView;
    private final MainInteractorImpl interactor;

    public MainActivityPresenterImpl(MainView mainView) {
        this.mainView = mainView;
        this.interactor = new MainInteractorImpl(this);
    }

    @Override
    public void receiveRequest() {
        interactor.receiveRequest();
    }

    @Override
    public String getNumberOfUsers(long numberOfUsers) {
        return "Online users: " + String.valueOf(numberOfUsers);
    }

    @Override
    public void sendNumberOfChildren(long number) {
        mainView.setNumberOfUsers(getNumberOfUsers(number));
    }
}
