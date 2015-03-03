package com.codeblast.hellodagger1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity implements HelloView {

  HelloPresenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    MessageSupplier supplier = new MessageSupplierImpl(new TimeServiceImpl());
    presenter = new HelloPresenterImpl(this, supplier);
  }

  @Override
  protected void onPostResume() {
    super.onPostResume();
    presenter.requestMessage();
  }

  @Override
  public void onMessageUpdated(String message) {
    ((TextView) findViewById(R.id.message)).setText(message);
  }
}
