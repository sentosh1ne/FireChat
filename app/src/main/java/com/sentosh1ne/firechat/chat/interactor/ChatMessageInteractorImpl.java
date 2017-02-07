package com.sentosh1ne.firechat.chat.interactor;

import com.firebase.client.Firebase;
import com.sentosh1ne.firechat.chat.presenter.ChatMessagePresenter;
import com.sentosh1ne.firechat.util.NetworkConstants;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sentosh1ne on 07.01.2017.
 */

public class ChatMessageInteractorImpl implements ChatMessageInteractor {

    @Override
    public void push(String author, String message, String avatar) {
        Firebase firebase = new Firebase(NetworkConstants.INSTANCE.getFirebaseMessages());
        firebase.push().setValue(mapMessage(author,message,avatar));
    }

    @Override
    public Map<String, Object> mapMessage(String message, String author, String avatar) {
        Map<String,Object> messageMap = new HashMap<>();
        messageMap.put("message",message);
        messageMap.put("author",author);
        messageMap.put("avatar",avatar);
        return messageMap;
    }
}
