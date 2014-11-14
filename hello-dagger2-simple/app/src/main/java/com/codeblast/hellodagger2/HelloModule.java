package com.codeblast.hellodagger2;

import dagger.Module;
import dagger.Provides;

@Module
public class HelloModule {
  private final HelloView view;

  public HelloModule(HelloView view) {
    this.view = view;
  }

  @Provides
  HelloView helloView() {
    return this.view;
  }

  @Provides
  MessageSupplier messageSupplier(MessageSupplierImpl impl) {
    return impl;
  }

  @Provides
  TimeService timeService(TimeServiceImpl impl) {
    return impl;
  }

  @Provides
  HelloPresenter helloPresenter(HelloPresenterImpl impl) {
    return impl;
  }
}
