package com.codeblast.hellodagger1;

import android.widget.TextView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.util.ActivityController;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MyTestRunner.class)
public class MainActivityTest {

  @Test
  public void testInitialDefaultMessage() {
    ActivityController<MainActivity> controller = Robolectric.buildActivity(MainActivity.class)
        .create();

    MainActivity activity = controller.get();
    TextView text = (TextView) activity.findViewById(R.id.message);
    assertEquals("Dagger 1 test starting!", text.getText());
  }

  @Test
  public void testInitiallyNoCallToPresenterInOnCreate() {
    // TODO: can't do this yet, because it's too late to override presenter after onCreate...
    fail();
  }

  @Test
  public void testOnPostResumeRequestsMessageFromPresenter() {
    ActivityController<MainActivity> controller = Robolectric.buildActivity(MainActivity.class)
        .create();

    MainActivity activity = controller.get();

    // Hack: override Presenter with a mock...
    activity.presenter = mock(HelloPresenter.class);

    TextView text = (TextView) activity.findViewById(R.id.message);
    controller.resume().visible();

    verify(activity.presenter).requestMessage();
  }
}
