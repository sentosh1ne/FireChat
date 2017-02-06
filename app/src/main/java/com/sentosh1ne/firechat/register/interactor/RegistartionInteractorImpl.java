package com.sentosh1ne.firechat.register.interactor;

import android.support.annotation.NonNull;
import android.util.Log;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.sentosh1ne.firechat.register.presenter.RegisterPresenter;
import com.sentosh1ne.firechat.util.NetworkConstants;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sentosh1ne on 05.01.2017.
 */

public class RegistartionInteractorImpl implements RegistrationInteractor {
    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    private Firebase ref = new Firebase(NetworkConstants.INSTANCE.getFireBaseUsers());

    private RegisterPresenter mPresenter;

    public RegistartionInteractorImpl(RegisterPresenter pre) {
        this.mPresenter = pre;
    }

    @Override
    public void register(final String userName, String email, String password, final String avatar) {
       firebaseAuth
               .createUserWithEmailAndPassword(email,password)
               .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
           @Override
           public void onComplete(@NonNull Task<AuthResult> task) {
               if (task.isSuccessful()) {
                   FirebaseUser user = task.getResult().getUser();
                   ref.child(user.getUid()).setValue(mapUser(userName, avatar));
                   mPresenter.onSuccess();
               }else {
                   mPresenter.onFailed();
               }
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
