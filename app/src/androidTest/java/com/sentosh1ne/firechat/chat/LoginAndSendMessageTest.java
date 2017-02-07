package com.sentosh1ne.firechat.chat;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import static  android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static android.support.test.espresso.action.ViewActions.*;
import com.sentosh1ne.firechat.R;
import com.sentosh1ne.firechat.login.view.LoginActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;



/**

 * Created by sentosh1ne on 07.02.2017.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginAndSendMessageTest {

    @Rule
    public ActivityTestRule<LoginActivity> rule = new ActivityTestRule<>(LoginActivity.class);

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testLoginAndSendMessage() throws Exception {
        onView(withId(R.id.login_email_edit_text)).perform(typeText("zapzap@mail.com"));
        onView(withId(R.id.login_password_edit_text)).perform(typeText("qwerty12345"));
        onView(withId(R.id.login_button)).perform(click());
        onView(withId(R.id.chat_message_body)).perform(typeText("WORKS!"));
        onView(withId(R.id.chat_send_button)).perform(click());
    }
}
