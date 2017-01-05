package com.sentosh1ne.firechat.register.interactor;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.sentosh1ne.firechat.register.presenter.RegisterPresenter;
import com.sentosh1ne.firechat.util.NetworkConstants;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sentosh1ne on 05.01.2017.
 */

public class RegistartionInteractorImpl implements RegistrationInteractor {
    private Firebase firebase = new Firebase(NetworkConstants.INSTANCE.getFireBaseUsers());
    private RegisterPresenter mPresenter;

    public RegistartionInteractorImpl(RegisterPresenter pre) {
        this.mPresenter = pre;
    }

    @Override
    public void register(final String userName, String email, String password, final String avatar) {
        firebase.createUser(email, password, new Firebase.ValueResultHandler<Map<String, Object>>() {
            @Override
            public void onSuccess(Map<String, Object> stringObjectMap) {
                String uid = stringObjectMap.get("uid").toString();
                firebase = new Firebase(NetworkConstants.INSTANCE.getFireBaseUsers() + uid);
                firebase.setValue(mapUser(userName, avatar));
                mPresenter.onSuccess();
            }

            @Override
            public void onError(FirebaseError firebaseError) {
                mPresenter.onFailed();
            }
        });
    }

    @Override
    public Map<String, Object> mapUser(String userName, String avatar) {
        Map<String, Object> user = new HashMap<>();
        user.put("username", userName);
        user.put("avatar", avatar);
        return user;
    }
}
