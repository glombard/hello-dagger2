package com.codeblast.hellodagger1;

public class HelloPresenterImpl implements HelloPresenter {
  private final HelloView view;
  private final MessageSupplier messageSupplier;

  public HelloPresenterImpl(HelloView view, MessageSupplier messageSupplier) {
    this.view = view;
    this.messageSupplier = messageSupplier;
  }

  public void requestMessage() {
    view.onMessageUpdated(messageSupplier.getMessage());
  }
}
