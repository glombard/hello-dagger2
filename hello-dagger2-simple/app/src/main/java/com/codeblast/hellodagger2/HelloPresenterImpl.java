package com.codeblast.hellodagger2;

import javax.inject.Inject;

public class HelloPresenterImpl implements HelloPresenter {
  private final HelloView view;
  private final MessageSupplier messageSupplier;

  @Inject
  public HelloPresenterImpl(HelloView view, MessageSupplier messageSupplier) {
    this.view = view;
    this.messageSupplier = messageSupplier;
  }

  public void requestMessage() {
    view.onMessageUpdated(messageSupplier.getMessage());
  }
}
