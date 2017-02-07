package com.sentosh1ne.firechat.adapters.user;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sentosh1ne.firechat.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pojos.User;

/**
 * Created by sentosh1ne on 29.01.2017.
 */

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder> implements UsersOnlineView{

    private List<User> mUsersList;
    private UsersOnlinePresenter presenter;
    private int mLayout;

    public UsersAdapter(List<User> mUsersList,int layout) {
        this.mUsersList = mUsersList;
        this.presenter = new UsersOnlinePresenterImpl(this);
        this.mLayout = layout;
    }

    public UsersAdapter(){

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(mLayout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        User current = mUsersList.get(position);
        holder.mUserTextView.setText(current.getUserName());
    }

    @Override
    public int getItemCount() {
        return mUsersList.size();
    }

    @Override
    public void addCurrentUsers(List<User> users) {
        mUsersList.clear();
        mUsersList.addAll(users);
        notifyDataSetChanged();
    }

    @Override
    public void request() {
        presenter.request();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.current_number_of_users_text_view)
        TextView mUserTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
