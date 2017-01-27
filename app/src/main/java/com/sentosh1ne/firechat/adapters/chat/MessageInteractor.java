package com.sentosh1ne.firechat.adapters.chat;

/**
 * Created by sentosh1ne on 27.01.2017.
 */


import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.sentosh1ne.firechat.util.NetworkConstants;

import pojos.Message;

/**
 * Created by Filip on 25/02/2016.
 */
public class MessageInteractor {
    private final MessagePresenter presenter;
    private final Firebase mMessagesRef = new Firebase(NetworkConstants.INSTANCE.getFirebaseMessages());
    private final Query mMessageQuery;


    public MessageInteractor(MessagePresenter pre) {
        this.presenter = pre;
        this.mMessageQuery = mMessagesRef.orderByValue().limitToLast(100);
    }

    public void request() {
        mMessageQuery.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                presenter.sendMessageToAdapter(dataSnapshot.getValue(Message.class));
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
}