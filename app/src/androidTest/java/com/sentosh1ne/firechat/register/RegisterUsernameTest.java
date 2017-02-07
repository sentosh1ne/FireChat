package com.sentosh1ne.firechat.register;

import static  android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static android.support.test.espresso.action.ViewActions.*;
import android.support.test.filters.SmallTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.Button;
import android.widget.EditText;

import com.sentosh1ne.firechat.R;
import com.sentosh1ne.firechat.register.view.RegisterActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sentosh1ne on 06.02.2017.
 */
@RunWith(AndroidJUnit4.class)
@SmallTest
public class RegisterUsernameTest {

    @Rule
    public ActivityTestRule<RegisterActivity> rule = new ActivityTestRule(RegisterActivity.class);

    private RegisterActivity activity;

    @Before
    public void setUp() throws Exception {
        activity = rule.getActivity();
    }

    @Test
    public void inputName(){
        onView(withId(R.id.reg_username_edit_text)).perform(typeText("googlei"));
        onView(withId(R.id.continue_button)).perform(click());
    }

}
