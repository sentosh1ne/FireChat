package com.sentosh1ne.firechat.main.interactor;

import android.util.Log;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.sentosh1ne.firechat.main.presenter.MainActivityPresenter;

/**
 * Created by sentosh1ne on 03.01.2017.
 */

public class MainInteractorImpl implements MainInteractor {
    private final Firebase mFirebase = new Firebase("https://firechat-7e7ef.firebaseio.com/currentUsers");
    private final MainActivityPresenter mPresenter;
    private final String INTERACTOR_DEBUG = "INTERACTOR";
    public MainInteractorImpl(MainActivityPresenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void receiveRequest() {
        mFirebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mPresenter.sendNumberOfChildren(dataSnapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Log.i(INTERACTOR_DEBUG,firebaseError.getMessage());
            }
        });
    }
}
