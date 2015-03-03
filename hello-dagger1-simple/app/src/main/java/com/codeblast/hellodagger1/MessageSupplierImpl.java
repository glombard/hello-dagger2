package com.codeblast.hellodagger1;

import javax.inject.Inject;

public class MessageSupplierImpl implements MessageSupplier {

  private final TimeService timeService;

  @Inject
  public MessageSupplierImpl(TimeService timeService) {
    this.timeService = timeService;
  }

  @Override
  public String getMessage() {
    int hour = timeService.currentHour();
    String partOfDay;
    if (hour < 12)
      partOfDay = "morning";
    else if (hour >= 17)
      partOfDay = "evening";
    else
      partOfDay = "afternoon";
    return "Good " + partOfDay + ", Dagger 1.2!";
  }
}
