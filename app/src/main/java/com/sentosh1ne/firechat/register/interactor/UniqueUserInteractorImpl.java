package com.sentosh1ne.firechat.register.interactor;

import android.util.Log;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.sentosh1ne.firechat.register.presenter.UniqueUserPresenter;
import com.sentosh1ne.firechat.util.NetworkConstants;

import pojos.User;

/**
 * Created by sentosh1ne on 05.01.2017.
 */

public class UniqueUserInteractorImpl implements UniqueUserInteractor {
    private UniqueUserPresenter mPresenter;
    private final String UNIQUE_INTERACTOR_TAG = "UNIQUEUSER_INTERACTOR";

    public UniqueUserInteractorImpl(UniqueUserPresenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void nameExists(final String userName) {
        Firebase firebase = new Firebase(NetworkConstants.INSTANCE.getFireBaseUsers());
        firebase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                boolean exists = false;
                for (DataSnapshot snap : dataSnapshot.getChildren()){
                    User user = snap.getValue(User.class);
                    if (user.getUsername().equals(userName)){
                        exists = true;
                        mPresenter.onExists();
                    } if (exists) break;
                }
                if (!exists) mPresenter.onAbscent();
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Log.i(UNIQUE_INTERACTOR_TAG,firebaseError.getMessage());
            }
        });
    }
}
