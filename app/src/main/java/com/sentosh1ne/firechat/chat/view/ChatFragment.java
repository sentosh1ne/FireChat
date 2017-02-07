package com.sentosh1ne.firechat.chat.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.sentosh1ne.firechat.R;
import com.sentosh1ne.firechat.adapters.chat.MessageRecyclerAdapter;
import com.sentosh1ne.firechat.chat.presenter.ChatMessagePresenter;
import com.sentosh1ne.firechat.chat.presenter.ChatMessagePresenterImpl;
import com.sentosh1ne.firechat.util.NetworkConstants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pojos.User;

public class ChatFragment extends Fragment {
    @BindView(R.id.chat_recycler_view)
    RecyclerView mChatRecyclerView;

    @BindView(R.id.chat_message_body)
    EditText mMessageBodyText;

    @BindView(R.id.chat_send_button)
    ImageButton mSendMessageButton;


    ChatMessagePresenter presenter;
    MessageRecyclerAdapter adapter;

    User user;

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
        user = NetworkConstants.INSTANCE
                .getGson()
                .fromJson((String)getActivity()
                        .getIntent()
                        .getExtras()
                        .get("credentials"), User.class);

        Log.i("USERNAME",user.toString());
        setList();
    }



    @OnClick(R.id.chat_send_button)
    void sendMessageOnClick(){
        String message = mMessageBodyText.getText().toString();

        presenter.sendMessage(user.getUsername(), message, user.getAvatar());
        mMessageBodyText.setText("");
        mChatRecyclerView.scrollToPosition(mChatRecyclerView.getBottom());
    }

    private void setList(){
        adapter = new MessageRecyclerAdapter(user.getUsername());
        adapter.request();
        mChatRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mChatRecyclerView.setHasFixedSize(true);
        mChatRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mChatRecyclerView.setAdapter(adapter);
    }

}
