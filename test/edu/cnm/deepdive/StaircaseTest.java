package edu.cnm.deepdive;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StaircaseTest {
  private static final String[] TWO = {
      " *",
      "**",
  };
    private static final String[] FIVE = {
        "    *",
        "   **",
        "  ***",
        " ****",
        "*****",
    };
  private static final String[] TEN = {
      "         *",
      "        **",
      "       ***",
      "      ****",
      "     *****",
      "    ******",
      "   *******",
      "  ********",
      " *********",
      "**********",
  };

  @Test
  void buildLinearStaircase() {
    assertArrayEquals(TWO, Staircase.buildLinearStaircase(2));
    assertArrayEquals(FIVE, Staircase.buildLinearStaircase(5));
    assertArrayEquals(TEN, Staircase.buildLinearStaircase(10));

  }
}