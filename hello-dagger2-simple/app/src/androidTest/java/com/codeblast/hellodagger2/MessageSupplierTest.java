package com.codeblast.hellodagger2;

import junit.framework.TestCase;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MessageSupplierTest extends TestCase {
  private final String MORNING = "Good morning, Dagger 2.0!";
  private final String AFTERNOON = "Good afternoon, Dagger 2.0!";
  private final String EVENING = "Good evening, Dagger 2.0!";

  public void testMidnightIsMorning() {
    runTest(0, MORNING);
  }

  public void testElevenAmIsMorning() {
    runTest(11, MORNING);
  }

  public void testTwelvePmIsAfternoon() {
    runTest(12, AFTERNOON);
  }

  public void testFourPmIsAfternoon() {
    runTest(16, AFTERNOON);
  }

  public void testFivePmIsEvening() {
    runTest(17, EVENING);
  }

  public void testElevenPmIsEvening() {
    runTest(23, EVENING);
  }

  private void runTest(int hour, String expectedMessage) {

    TimeService timeService = mock(TimeService.class);
    when(timeService.currentHour()).thenReturn(hour);
    MessageSupplier supplier = new MessageSupplierImpl(timeService);
    String result = supplier.getMessage();
    assertEquals(expectedMessage, result);
  }
}
