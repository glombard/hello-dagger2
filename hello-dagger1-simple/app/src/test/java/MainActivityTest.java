import com.codeblast.hellodagger1.MainActivity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;

import static org.junit.Assert.assertTrue;

@RunWith(MyTestRunner.class)
public class MainActivityTest {
  @Test
  public void testOnPostResumeRequestsMessageFromPresenter() {
    MainActivity activity = Robolectric.buildActivity(MainActivity.class)
        .create()
        .postResume()
        .get();

    // TODO: verify the correct interaction took place here.

    assertTrue(false);
  }
}
