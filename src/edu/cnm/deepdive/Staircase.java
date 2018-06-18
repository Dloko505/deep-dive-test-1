package edu.cnm.deepdive;


import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * The static methods in this class build string array "staircases".
 *
 * <p>
 *
 * Consider a text staircase of height 6:
 *
 * </p>
 *
 * <pre><code>      *
 *
 *     **
 *
 *    ***
 *
 *   ****
 *
 *  *****
 *
 * ******</code></pre>
 *
 * <p>
 *
 * Note that each line consists of spaces and the asterisk character. Further,
 *
 * each line has the exact same heightber of characters, so that (when a
 *
 * monospace font is used), the right edges line up. Finally, note that though
 *
 * the last line appears to have a leading space, the staircases produced by
 *
 * your code should end with a string with no leading spaces.
 *
 * </p>
 *
 * <p>
 *
 * Your task will be to write code to construct such staircases, and return
 *
 * them as an array of strings. The 1<sup>st</sup>element will have a single
 *
 * asterisk, with leading spaces as necessary; the last element will have
 *
 * asterisks only; all the previous strings in the array should be left-padded
 *
 * as necessary so that all of the strings are of the same length &ndash; i.e.
 *
 * when printed out, one string per line, the right edges will be aligned in
 *
 * the printout.
 *
 * </p>
 *
 * <p>
 *
 * In the basic problem, the staircase is linear &ndash; that is, when
 *
 * counting from the top of the staircase down, each successive string has 1
 *
 * more asterisk than the previous.
 *
 * </p>
 *
 * <p>
 *
 * There is an extra credit problem as well. In this problem, the staircase
 *
 * doesn't ascend/descend in a linear fashion, but as a Fibonacci sequence.
 *
 * That is, the top 2 steps have one asterisk each, but each successively
 *
 * lower step has as many asterisks as the sum of the previous 2. For example,
 *
 * a Fibonacci staircase of height 6 would appear as the following:
 *
 * </p>
 *
 * <pre><code>         *
 *
 *         *
 *
 *        **
 *
 *       ***
 *
 *     *****
 *
 * *********</code></pre>
 *
 * <h3>Assumptions</h3>
 *
 * <ol>
 *
 * <li>For the linear staircase, the value of <code>height</code> parameter
 *
 * will always be in the range 2 to 1,000,000, inclusive.</li>
 *
 * <li>For the Fibonacci staircase, the value of <code>height</code> parameter
 *
 * will always be in the range 2 to 30, inclusive.</li>
 *
 * <li>Whether your code prints anything out is up to you. What it
 *
 * <strong>must</strong> do is return a {@link String String[]} &ndash; i.e.
 *
 * an array of strings.</li>
 *
 * </ol>
 *
 * <h3>Basic test cases</h3>
 *
 * <p>
 *
 * Please note that the values below are guaranteed to be included in the test
 *
 * cases; others may be included at our discretion. However, if your code
 *
 * works correctly with the cases below, and assuming it doesn't simply have
 *
 * hard-coded conditions looking for these specific inpupt values, it should
 *
 * have no problem with additional test values. In other words, your code
 *
 * should include the necessary computations to handle general cases, and not
 *
 * just those shown here.
 *
 * </p>
 *
 * <table summary="Test inputs and expected outputs" class="striped">
 *
 * <thead>
 *
 * <tr>
 *
 * <th><code>height</code></th>
 *
 * <th><code>buildLinearStaircase(height)</code></th>
 *
 * <th><code>buildFibonacciStaircase(height)</code></th>
 *
 * </tr>
 *
 * </thead>
 *
 * <tbody>
 *
 * <tr>
 *
 * <td><code>2</code></td>
 *
 * <td><pre><code>  *
 *
 * **</code></pre></td>
 *
 * <td><pre><code> *
 *
 * *</code></pre></td>
 *
 * </tr>
 *
 * <tr>
 *
 * <td><code>5</code></td>
 *
 * <td>
 *
 * <pre><code>     *
 *
 *    **
 *
 *   ***
 *
 *  ****
 *
 * *****</code></pre>
 *
 * </td>
 *
 * <td>
 *
 * <pre><code>     *
 *
 *     *
 *
 *    **
 *
 *   ***
 *
 * *****</code></pre>
 *
 * </td>
 *
 * </tr>
 *
 * </tbody>
 *
 * </table>
 */

public class Staircase {


  /**
   * Constructs and returns an array of strings, where the first element is the
   *
   * top step of the staircase, containing a single asterisk (*), right-aligned
   *
   * (that is, padded on the left with spaces, as necessary), and each
   *
   * successive element is a string containing one more asterisk than the
   *
   * previous. The final string in the array should have <code>height</code>
   *
   * asterisk characters, without any leading spaces.
   *
   * @param height staircase height (heightber of steps).
   * @return array of length <code>height</code>.
   */

  public static String[] buildLinearStaircase(int height) {

//    Scanner in = new Scanner(System.in);
//    height  = Integer.parseInt(in.nextLine());
    String[] stairs = new String[height];
    String stair = "";

    if (height >= 2 && height <= 1000000) {
      for (int step = 0; step < height; step++) {
        for (int space = height - 1; space >= 0; space--) {
          if (space <= step) {
            stair += "*";
          } else {
            stair += " ";
          }
        }
        stairs[step] = stair;
        stair = "";
      }
    }
    return stairs;
  }
}

/**
 * Constructs and returns an array of strings, where the first element is the
 *
 * top step of the staircase, containing a single asterisk (*), right-aligned
 *
 * (that is, padded on the left with spaces, as necessary); the second element
 *
 * also has a single asterisk, right-aligned (left-padded); each
 *
 * successive element is a string containing a heightber of asterisks equal to the
 *
 * the sum of the heightber of asterisks in the previous 2 elements. For example,
 *
 * the 3<sup>rd</sup> element will have 1 + 1 = 2 asterisks; the 4<sup>th</sup>
 *
 * will have 2 + 1 = 3 asterisks; etc. The last element of the array should
 *
 * contain nothing but asterisks.
 *
 * @param height staircase height (heightber of steps).
 * @return array of length <code>height</code>.
 */

//  public static String[] buildFibonacciStaircase(int height) {
//
//    // TODO Implement method for EXTRA CREDIT!
//
//  }
//
//
//}