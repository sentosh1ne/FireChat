package com.sentosh1ne.firechat.chat.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.sentosh1ne.firechat.R;
import com.sentosh1ne.firechat.adapters.chat.MessageRecyclerAdapter;
import com.sentosh1ne.firechat.chat.presenter.ChatMessagePresenter;
import com.sentosh1ne.firechat.chat.presenter.ChatMessagePresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChatFragment extends Fragment {
    @BindView(R.id.chat_recycler_view)
    RecyclerView mChatRecyclerView;

    @BindView(R.id.chat_message_body)
    EditText mMessageBodyText;

    @BindView(R.id.chat_send_button)
    ImageButton mSendMessageButton;


    ChatMessagePresenter presenter;
    MessageRecyclerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chat_fragment, container, false);
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
        presenter = new ChatMessagePresenterImpl();

    }



    @OnClick(R.id.chat_send_button)
    void sendMessageOnClick(){
        Intent currentIntent = getActivity().getIntent();
        String message = mMessageBodyText.getText().toString();
        String avatar = currentIntent.getStringExtra("avatar");
        String username = currentIntent.getStringExtra("username");
        presenter.sendMessage(username,message,avatar);
        mMessageBodyText.setText("");
        mChatRecyclerView.scrollToPosition(mChatRecyclerView.getBottom());
    }


}
