package presenter;

import com.sentosh1ne.firechat.register.interactor.RegistrationInteractor;
import com.sentosh1ne.firechat.register.presenter.RegisterPresenter;
import com.sentosh1ne.firechat.register.presenter.RegisterPresenterImpl;
import com.sentosh1ne.firechat.register.view.RegisterView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

/**
 * Created by sentosh1ne on 31.01.2017.
 */

public class RegisterPresenterTest {
    @Mock
    RegistrationInteractor interactor;
    @Mock
    RegisterView view;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        RegisterPresenter presenter = new RegisterPresenterImpl(view);
        doNothing().when(interactor).register(anyString(),anyString(),anyString(),anyString());
    }

    @Test
    public void progressBarShowed(){
        verify(interactor).register(anyString(),anyString(),anyString(),anyString());
    }




}