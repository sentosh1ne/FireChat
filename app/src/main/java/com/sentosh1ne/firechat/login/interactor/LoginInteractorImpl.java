package com.sentosh1ne.firechat.login.interactor;

import android.support.annotation.NonNull;
import android.util.Log;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.sentosh1ne.firechat.login.presenter.LoginPresenter;
import com.sentosh1ne.firechat.util.NetworkConstants;

import java.util.HashMap;
import java.util.Map;

import pojos.User;

/**
 * Created by sentosh1ne on 03.01.2017.
 */

public class LoginInteractorImpl implements LoginInteractor {
    private  Firebase mFirebase;
    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    private final LoginPresenter mPresenter;

    public LoginInteractorImpl(LoginPresenter presenter){
        mPresenter = presenter;
    }

    public void loginWithEmail(String email, String password){
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    mFirebase = new Firebase(
                            NetworkConstants.INSTANCE.getFireBaseURL() +
                                    "users/" + firebaseAuth.getCurrentUser().getUid());
                    mFirebase.addListenerForSingleValueEvent(new ValueEventListener() {

                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            User user = NetworkConstants.INSTANCE.getGson().fromJson(dataSnapshot.getValue().toString(),User.class);
                            FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                            Log.i("ITISMYID", firebaseUser.getUid());
                            Log.i("ITISMYID", user.toString());
                            Firebase loggedUser = new Firebase(NetworkConstants.INSTANCE.getFireBaseURL() + firebaseUser.getUid());
                            loggedUser.setValue(createUser(user.getUsername(), user.getAvatar()));
                            mPresenter.onSuccess(firebaseUser.getUid(), user.getUsername(), user.getAvatar());
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {
                            mPresenter.onFailed();
                        }
                    });
                }
            }
        });
    }


    @Override
    public Map<String, Object> createUser(String user, String avatar) {
        Map<String, Object> userToCreate = new HashMap<>();
        userToCreate.put("username", user);
        userToCreate.put("avatar", avatar);
        Log.i("TESTMAP", userToCreate.get("username").toString());
        return userToCreate;
    }


}
