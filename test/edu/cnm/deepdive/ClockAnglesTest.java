package edu.cnm.deepdive;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClockAnglesTest {

  @Test
  void hourHandDegrees() {
    assertEquals(0, ClockAngles.hourHandDegrees(0, 0.0));
    assertEquals(97.5, ClockAngles.hourHandDegrees(3, 15.0));
    assertEquals(15, ClockAngles.hourHandDegrees(12, 30.0));
    assertEquals(231, ClockAngles.hourHandDegrees(19, 42.0));
  }

  @Test
  void minuteHandDegrees() {
    assertEquals(0.0, ClockAngles.minuteHandDegrees(0.0));
    assertEquals(90.0, ClockAngles.minuteHandDegrees(15.0));
    assertEquals(180, ClockAngles.minuteHandDegrees(30.0));
    assertEquals(252, ClockAngles.minuteHandDegrees(42.0));

  }
}