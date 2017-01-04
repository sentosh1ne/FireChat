package com.sentosh1ne.firechat.login.interactor;

import com.firebase.client.AuthData;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.auth.FirebaseAuth;
import com.kelvinapps.rxfirebase.RxFirebaseAuth;
import com.sentosh1ne.firechat.login.presenter.LoginPresenter;
import com.sentosh1ne.firechat.util.NetworkConstants;

import java.util.HashMap;
import java.util.Map;

import pojos.User;

/**
 * Created by sentosh1ne on 03.01.2017.
 */

public class LoginInteractorImpl implements LoginInteractor {
    private  Firebase mFirebase = new Firebase(
            NetworkConstants.INSTANCE.getFireBaseURL() +
                    "users/");

    private final LoginPresenter mPresenter;

    public LoginInteractorImpl(LoginPresenter presenter){
        mPresenter = presenter;
    }

    @Override
    public void loginWithEmail(String email, String password) {
        mFirebase.authWithPassword(email, password, new Firebase.AuthResultHandler() {
            @Override
            public void onAuthenticated(final AuthData authData) {
                mFirebase = new Firebase(
                        NetworkConstants.INSTANCE.getFireBaseURL() +
                                "users/" + authData.getUid());
                mFirebase.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        User user = dataSnapshot.getValue(User.class);
                        Firebase loggedUser = new Firebase(NetworkConstants.INSTANCE.getFireBaseURL() + authData.getUid()); //redundant?
                        loggedUser.setValue(createUser(user.getUserName(), user.getAvatar()));
                        mPresenter.onSuccess(user.getUserName(), authData.getUid(), user.getAvatar());
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {

                    }
                });
            }

            @Override
            public void onAuthenticationError(FirebaseError firebaseError) {
                mPresenter.onFailed();
            }
        });

    }

    @Override
    public Map<String, Object> createUser(String user, String avatar) {
        Map<String, Object> userToCreate = new HashMap<>();
        userToCreate.put("username", user);
        userToCreate.put("avatar", avatar);
        return userToCreate;
    }
}
