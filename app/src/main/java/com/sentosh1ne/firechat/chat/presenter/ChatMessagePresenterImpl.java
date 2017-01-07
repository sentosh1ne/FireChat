package com.sentosh1ne.firechat.chat.presenter;


import com.sentosh1ne.firechat.chat.interactor.ChatMessageInteractor;
import com.sentosh1ne.firechat.chat.interactor.ChatMessageInteractorImpl;

/**
 * Created by sentosh1ne on 07.01.2017.
 */

public class ChatMessagePresenterImpl implements ChatMessagePresenter {

    private ChatMessageInteractor interactor;

    public ChatMessagePresenterImpl() {
        this.interactor = new ChatMessageInteractorImpl();
    }

    @Override
    public void sendMessage(String author, String message, String avatar) {
        interactor.push(author,message,avatar);
    }
}
