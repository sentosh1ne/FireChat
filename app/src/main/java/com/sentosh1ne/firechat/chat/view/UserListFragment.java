package com.sentosh1ne.firechat.chat.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sentosh1ne.firechat.R;
import com.sentosh1ne.firechat.adapters.user.UsersAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;


public class UserListFragment extends Fragment {


    @BindView(R.id.online_user_recycler_view)
    RecyclerView usersList;

    private UsersAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat_users, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        fillUpList();
    }

    private void fillUpList() {
        adapter = new UsersAdapter();
        adapter.request();
        usersList.setAdapter(adapter);
    }


}
