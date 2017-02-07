package com.sentosh1ne.firechat.adapters.chat;

/**
 * Created by sentosh1ne on 27.01.2017.
 */


import android.util.Log;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.google.gson.Gson;
import com.sentosh1ne.firechat.util.NetworkConstants;

import pojos.Message;

/**
 * Created by Filip on 25/02/2016.
 */
public class MessageInteractor {
    private final MessagePresenter presenter;
    private final Firebase mMessagesRef = new Firebase(NetworkConstants.INSTANCE.getFirebaseMessages());
    private final Query mMessageQuery;
    private final Gson gson = NetworkConstants.INSTANCE.getGson();

    public MessageInteractor(MessagePresenter presenter) {
        this.presenter = presenter;
        this.mMessageQuery = mMessagesRef.orderByValue().limitToLast(100);
    }

    public void request() {
        mMessageQuery.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Log.i("MESSAGE", dataSnapshot.getValue().toString());
                presenter.sendMessageToAdapter(gson.fromJson(dataSnapshot.getValue().toString(),Message.class));
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