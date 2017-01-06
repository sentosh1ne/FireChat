package com.sentosh1ne.firechat.register.view;

/**
 * Created by sentosh1ne on 06.01.2017.
 */

public interface RegisterView {
    void onSuccess();

    void onFailure();

    void activateProgressBar();

    void stopProgressBar();
}
