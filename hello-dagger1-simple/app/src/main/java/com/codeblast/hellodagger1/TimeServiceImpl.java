package com.codeblast.hellodagger1;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.inject.Inject;

public class TimeServiceImpl implements TimeService {
  public TimeServiceImpl() {
  }

  @Override
  public int currentHour() {
    return new GregorianCalendar().get(Calendar.HOUR_OF_DAY);
  }
}
