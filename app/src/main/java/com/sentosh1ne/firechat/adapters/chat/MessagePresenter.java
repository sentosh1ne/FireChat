package com.sentosh1ne.firechat.adapters.chat;

import pojos.Message;

/**
 * Created by sentosh1ne on 27.01.2017.
 */

public interface MessagePresenter {
    void sendMessageToAdapter(Message message);
    void requestMessages();
}
