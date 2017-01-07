package com.sentosh1ne.firechat.chat.interactor;

import com.firebase.client.Firebase;
import com.sentosh1ne.firechat.util.NetworkConstants;

/**
 * Created by sentosh1ne on 07.01.2017.
 */

public class UserLogoutInteractorImpl implements UserLogoutInteractor {
    @Override
    public void logout(String uid) {
        Firebase firebase = new Firebase(NetworkConstants.INSTANCE.getFirebaseCurrentUSers() + uid);
        firebase.removeValue();
    }
}
