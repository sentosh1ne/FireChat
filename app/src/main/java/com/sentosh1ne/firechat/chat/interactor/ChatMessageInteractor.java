package com.sentosh1ne.firechat.chat.interactor;

import java.util.Map;

/**
 * Created by sentosh1ne on 07.01.2017.
 */

public interface ChatMessageInteractor {
    void push(String author, String message, String emoji);

    Map<String, Object> mapMessage(String message, String author, String emoji);
}
