package com.codeblast.hellodagger1;

import dagger.Module;
import dagger.Provides;

@Module(injects = {MainActivity.class}, addsTo = RootModule.class)
public class HelloModule {

  private final MainActivity activity;

  public HelloModule(MainActivity activity) {
    this.activity = activity;
  }

  @Provides
  HelloView helloView() {
    return activity;
  }

  @Provides
  MessageSupplier messageSupplier(MessageSupplierImpl impl) {
    return impl;
  }

  @Provides
  HelloPresenter helloPresenter(HelloPresenterImpl impl) {
    return impl;
  }

}
