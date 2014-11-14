package com.codeblast.hellodagger2;

import android.test.ActivityUnitTestCase;
import android.test.UiThreadTest;
import android.view.ContextThemeWrapper;
import android.widget.TextView;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class HelloActivityTest extends ActivityUnitTestCase<HelloActivity> {
  HelloActivity activity;

  @Inject
  private HelloPresenter presenter;

  public HelloActivityTest() {
    super(HelloActivity.class);
  }

  @Override
  protected void setUp() throws Exception {
    super.setUp();

    // Setup Theme.AppCompat theme for ActionBarActivity:
    ContextThemeWrapper context = new ContextThemeWrapper(getInstrumentation().getTargetContext(), R.style.AppTheme);
    setActivityContext(context);

    setActivity(launchActivity("com.codeblast.hellodagger2", HelloActivity.class, null));
    activity = getActivity();

    // At this point, onCreate has run and Dagger has already injected
    // the activity's members.  How do I insert my MockModule into
    // the object graph here to inject a mock presenter?

    presenter = mock(HelloPresenter.class); // HACK! Must let Dagger do this...
    activity.presenter = presenter;
  }

  @UiThreadTest
  public void testOnPostResumeRequestsMessageFromPresenter() throws Throwable {
    activity.onPostResume();
    verify(presenter).requestMessage();
  }

  @UiThreadTest
  public void testOnMessageUpdateSetsText() throws Throwable {
    activity.onMessageUpdated("Abc.");
    TextView textView = (TextView) activity.findViewById(R.id.message);
    assertEquals("Abc.", textView.getText());
  }

  @Module(
      addsTo = HelloModule.class,
      overrides = true,
      injects = HelloActivityTest.class)
  class MockModule {
    @Provides
    HelloPresenter presenter() {
      // TODO: set up presenter as needed...
      return mock(HelloPresenter.class);
    }
  }
}