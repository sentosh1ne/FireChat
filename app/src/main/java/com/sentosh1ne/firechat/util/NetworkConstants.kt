package com.sentosh1ne.firechat.util

import com.google.gson.Gson

/**
 * Created by sentosh1ne on 03.01.2017.
 */
object NetworkConstants {
    val fireBaseURL = "https://firechat-7e7ef.firebaseio.com/"
    val fireBaseUsers = fireBaseURL + "users/"
    val firebaseCurrentUSers = fireBaseURL + "currentUsers/"
    val firebaseMessages = fireBaseURL + "messages/"
    val gson = Gson()

}