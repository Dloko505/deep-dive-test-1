package edu.cnm.deepdive;



/**

 * The static methods of this class compute the angles to which the hands of a

 * clock will be oriented at a given time of day.

 * <p>

 *   Some of the method names contain the word "Degrees". The value returned by

 *   each of these should be an angle in degrees, measured clockwise from

 *   straight up (12 o'clock on the clock face). Another way to think of this

 *   angle is that it follows the conventions used when reading a compass. The

 *   values returned should be in the interval [0, 360) &ndash; that is, from 0

 *   (inclusive) to 360 (exclusive).

 * </p>

 * <p>

 *   Other methods contain the word "Radians"; these methods (for extra credit)

 *   should return angles in radians, measured counter-clockwise from the

 *   positive X-axis (3 o'clock on the clock face). In other words, these angles

 *   follow the conventions of analytic geometry. The value returned by each of

 *   these methods should be in the interval [0, 2&pi;).

 * </p>

 * <h3>Assumptions</h3>

 * <ol>

 *   <li>The value of the <code>hours</code> parameter will always be in the

 *   range 0 to 23, inclusive. (Note that your code shouldn't care whether a

 *   12-hour or 24-hour clock is being used.)</li>

 *   <li>The value of the <code>minutes</code> parameter will always be in the

 *   real-valued interval [0, 60) &ndash; that is a floating-point number

 *   ranging from 0 (inclusive) to 60 (exclusive).</li>

 *   <li>The angle of the minute hand doesn't depend at all on the hours;

 *   however, the angle of the hour hand depends on both the hours and

 *   the minutes, since the hour hand on the clock face advances even as the

 *   minutes advance.</li>

 *   <li>Since non-integral computations are almost always inexact, results

 *   need only be accurate to within 0.01&deg;, or (approximately) 0.00017

 *   radians.</li>

 * </ol>

 * <h3>Basic test cases</h3>

 * <p>

 *   Please note that the values below are guaranteed to be included in the test

 *   cases; others may be included at our discretion. However, if your code

 *   works correctly with the cases below, and assuming it doesn't simply have

 *   hard-coded conditions looking for these specific inpupt values, it should

 *   have no problem with additional test values. In other words, your code

 *   should include the necessary computations to handle general cases, and not

 *   just those shown here.

 * </p>

 * <table summary="Test inputs and expected outputs" class="striped">

 *   <thead>

 *     <tr>

 *       <th><code>hours</code></th>

 *       <th><code>minutes</code></th>

 *       <th><code>hourHandDegrees(hours, minutes)</code></th>

 *       <th><code>minuteHandDegrees(minutes)</code></th>

 *       <th><code>hourHandRadians(hours, minutes)</code></th>

 *       <th><code>minuteHandRadians(minutes)</code></th>

 *     </tr>

 *   </thead>

 *   <tbody>

 *     <tr>

 *       <td><code>0</code></td>

 *       <td><code>0</code></td>

 *       <td><code>0</code></td>

 *       <td><code>0</code></td>

 *       <td><code>1.57079632679</code></td>

 *       <td><code>1.57079632679</code></td>

 *     </tr>

 *     <tr>

 *       <td><code>3</code></td>

 *       <td><code>15</code></td>

 *       <td><code>97.5</code></td>

 *       <td><code>90</code></td>

 *       <td><code>6.152285613280012</code></td>

 *       <td><code>0</code></td>

 *     </tr>

 *     <tr>

 *       <td><code>12</code></td>

 *       <td><code>30</code></td>

 *       <td><code>15</code></td>

 *       <td><code>180</code></td>

 *       <td><code>1.3089969389957474</code></td>

 *       <td><code>4.71238898038469</code></td>

 *     </tr>

 *     <tr>

 *       <td><code>19</code></td>

 *       <td><code>42</code></td>

 *       <td><code>231</code></td>

 *       <td><code>252</code></td>

 *       <td><code>3.822271061867582</code></td>

 *       <td><code>3.4557519189487724</code></td>

 *     </tr>

 *   </tbody>

 * </table>

 */

public class ClockAngles {



  /**

   * Computes and returns the angle made by the hour hand, measured clockwise

   * from straight up (12 o'clock on the clock face).

   *

   * @param hours   hour component of time, from integer set

   *                {0, 1, &hellip;, 23}.

   * @param minutes minute component of time, from real interval [0&ndash;60).

   * @return        angle (in degrees) to which hour hand is oriented.

   */

  public static double hourHandDegrees(int hours, double minutes) {
    double hoursDegree = 0;
    if (hours >= 0 && hours <= 23) {
       hoursDegree = (hours % 12) * 30;
       minutes = (minutes / 2);
       hoursDegree = hoursDegree + minutes;
    }
    return hoursDegree;

  }


  /**

   * Computes and returns the angle made by the minute hand, measured clockwise

   * from straight up (12 o'clock on the clock face).

   *

   * @param minutes minute component of time, from real interval [0&ndash;60).

   * @return        angle (in degrees) to which minute hand is oriented.

   */

  public static double minuteHandDegrees(double minutes) {

    return (minutes = minutes * 6);

  }



  /**

   * Computes and returns the angle made by the hour hand, measured

   * counter-clockwise from the positive X-axis (3 o'clock on the clock face).

   *

   * @param hours   hour component of time, from integer set

   *                {0, 1, &hellip;, 23}.

   * @param minutes minute component of time, from real interval [0&ndash;60).

   * @return        angle (in radians) to which hour hand is oriented.

   */

//  public static double hourHandRadians(int hours, double minutes) {
//
//    // TODO Implement method for EXTRA CREDIT!
//
//  }



  /**

   * Computes and returns the angle made by the minute hand, measured

   * counter-clockwise from the positive X-axis (3 o'clock on the clock face).

   *

   * @param minutes minute component of time, from real interval [0&ndash;60).

   * @return        angle (in radians) to which minute hand is oriented.

   */

//  public static double minuteHandRadians(double minutes) {
//
//    // TODO Implement method for EXTRA CREDIT!
//
//  }



}