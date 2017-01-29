package com.sentosh1ne.firechat.adapters.user;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.sentosh1ne.firechat.util.NetworkConstants;

import java.util.ArrayList;
import java.util.List;

import pojos.User;

/**
 * Created by sentosh1ne on 29.01.2017.
 */

public class UsersOnlineInteractor {

    private UsersOnlinePresenter presenter;
    private Firebase onlineUsersRef = new Firebase(NetworkConstants.INSTANCE.getFirebaseCurrentUSers());

    public UsersOnlineInteractor(UsersOnlinePresenter presenter) {
        this.presenter = presenter;
    }

    public void request() {
        onlineUsersRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<User> mListOfUsers = new ArrayList<>();
                for (DataSnapshot x : dataSnapshot.getChildren()) {
                    mListOfUsers.add(x.getValue(User.class));
                }
                presenter.getChildren(mListOfUsers);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
    }
}
