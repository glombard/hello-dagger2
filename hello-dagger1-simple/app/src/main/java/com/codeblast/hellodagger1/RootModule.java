package com.codeblast.hellodagger1;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
    library = true,
    complete = false
)
public class RootModule {
  private final Context _context;

  public RootModule(Context context) {
    _context = context;
  }

  @Provides
  @Singleton
  public Context provideApplicationContext() {
    return _context;
  }

  @Provides
  @Singleton
  public TimeService provideTimeService() {
    return new TimeServiceImpl();
  }
}
