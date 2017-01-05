package com.sentosh1ne.firechat.register.interactor;

import java.util.Map;

/**
 * Created by sentosh1ne on 05.01.2017.
 */

public interface RegistrationInteractor {
    void register(String userName,String email, String password, String avatar);
    Map<String,Object> mapUser(String userName, String avatar);
}
