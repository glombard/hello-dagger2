package com.codeblast.hellodagger1;

import android.app.Activity;

import org.junit.runners.model.InitializationError;
import org.robolectric.AndroidManifest;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.res.Fs;

import java.io.File;

public class MyTestRunner extends RobolectricTestRunner {
  private static final int ROBOLECTRIC_SDK_VERSION = 18;
  private static final String ROBOLECTRIC_THEME = "@style/RoboAppTheme";

  public MyTestRunner(Class<?> testClass)
      throws InitializationError {
    super(testClass);
  }

  @Override
  protected AndroidManifest getAppManifest(Config config) {
    String path = "src/main";
    if (!new File(path).exists()) {
      path = "app/" + path;
    }
    final String manifestProperty = path + "/AndroidManifest.xml";
    final String resProperty = path + "/res";
    return new AndroidManifest(Fs.fileFromPath(manifestProperty), Fs.fileFromPath(resProperty)) {
      @Override
      public int getTargetSdkVersion() {
        return ROBOLECTRIC_SDK_VERSION;
      }

      @Override
      public String getThemeRef(Class<? extends Activity> activityClass) {
        return ROBOLECTRIC_THEME;
      }
    };
  }
}
