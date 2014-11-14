package com.codeblast.hellodagger2;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.inject.Inject;

public class TimeServiceImpl implements TimeService {
  @Inject
  public TimeServiceImpl() {
  }

  @Override
  public int currentHour() {
    return new GregorianCalendar().get(Calendar.HOUR_OF_DAY);
  }
}
