package com.codeblast.hellodagger1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  @Override
  protected void onPostResume() {
    super.onPostResume();
      final int hour = new GregorianCalendar().get(Calendar.HOUR_OF_DAY);
      final String partOfDay;
      if (hour < 12)
          partOfDay = "morning";
      else if (hour >= 17)
          partOfDay = "evening";
      else
          partOfDay = "afternoon";
      final String message = "Good " + partOfDay + ", Dagger 1.2!";
      ((TextView) findViewById(R.id.message)).setText(message);
  }
}
