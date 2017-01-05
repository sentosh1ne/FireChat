package com.sentosh1ne.firechat.register.interactor;

/**
 * Created by sentosh1ne on 05.01.2017.
 */

public class UniqueUserInteractorImpl implements UniqueUserInteractor {
    @Override
    public boolean nameExists(String userName) {
        return false;
    }
}
