package com.sentosh1ne.firechat.adapters.chat;

/**
 * Created by sentosh1ne on 27.01.2017.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.sentosh1ne.firechat.R;
import com.sentosh1ne.firechat.chat.presenter.ChatMessagePresenterImpl;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import pojos.Message;

/**
 * Created by Filip on 27/02/2016.
 */
public class MessageRecyclerAdapter extends RecyclerView.Adapter<MessageRecyclerAdapter.ViewHolder> implements MessageAdapterView {
    private final ArrayList<Message> mMessageList = new ArrayList<>();
    private final String user;
    private final MessagePresenter presenter;

    public MessageRecyclerAdapter(String username) {
        this.user = username;
        presenter = new MessagePresenterImpl(this);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_message, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Message current = mMessageList.get(position);
        if (current.getAuthor().equals(user)) {
            holder.mAuthorTextView.setText("You");
        } else {
            holder.mAuthorTextView.setText(current.getAuthor());
        }
        holder.mMessageTextView.setText(current.getMessage());
        holder.mAvatarTextView.setText(current.getAvatar());
    }

    @Override
    public int getItemCount() {
        return mMessageList.size();
    }

    @Override
    public void addItem(Message message) {
        mMessageList.add(message);
        notifyDataSetChanged();
    }

    @Override
    public void request() {
        presenter.requestMessages();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.message_author)
        TextView mAuthorTextView;
        @BindView(R.id.message_value)
        TextView mMessageTextView;
        @BindView(R.id.message_avatar)
        TextView mAvatarTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}