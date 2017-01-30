package com.sentosh1ne.firechat.chat.view;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.firebase.client.Firebase;
import com.sentosh1ne.firechat.R;
import com.sentosh1ne.firechat.chat.presenter.UserLogoutPresenter;
import com.sentosh1ne.firechat.chat.presenter.UserLogoutPresenterImpl;

public class ChatActivity extends AppCompatActivity {

    private UserLogoutPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        Firebase.setAndroidContext(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .add(R.id.chat_activity_frame_layout,new ChatFragment(),"chat")
                .commit();
        presenter = new UserLogoutPresenterImpl();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_chat, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        FragmentManager manager = getSupportFragmentManager();
        if (manager.getBackStackEntryCount() == 0){
            manager.beginTransaction()
                  .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                  .replace(R.id.chat_activity_frame_layout,new UserListFragment(),"users_list")
                  .commit();
        } else{
            manager.popBackStack();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.removeFromRoom(getIntent().getStringExtra("uid"));
    }
}
