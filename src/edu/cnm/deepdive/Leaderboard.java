package edu.cnm.deepdive;



/**

 * The static methods of this class compute rankings of an input array of scores

 * against a leaderboard of scores.

 *

 * <h3>Scenario</h3>

 * <p>

 *   Imagine that we want to determine Alice's rank as she progresses up the

 *   leaderboard of a competition. For example, the four players on the

 *   leaderboard have high scores of 100, 90, 90, and 80. There are actually (at

 *   least) 2 ways we could rank a given score by Alice against the players

 *   already on the leaderboard:

 * </p>

 * <ul>

 *   <li>With <i>competition ranking</i>, we look at the number of players with

 *   better scores than the one being ranked. For example, if Alice has a score

 *   of 85, we see that there are 3 players with higher scores; therefore, using

 *   the competition ranking scheme, we would state that Alice is in

 *   4<sup>th</sup> place.</li>

 *   <li>With <i>dense ranking</i>, we look at the scores alone, counting the

 *   number of distinct scores that are better than the one being ranked,

 *   without regard for the number of players that might have achieved some of

 *   those scores in common. In the same example, with a score of 85, we see

 *   that there are 2 distinct scores (90 and 100) that are higher than Alice's

 *   score. Thus, with the dense ranking scheme, we'd say that Alice is in

 *   3<sup>rd</sup> place.</li>

 * </ul>

 * <p>

 *   Now imagine that we are tracking Alice's progress through multiple

 *   competition milestones (e.g. rounds of play), but that the players already

 *   on the leaderboard have already completed the competition. If Alice's score

 *   progresses from 70 to 80 to 105, her competition ranking will go

 *   accordingly, from 5<sup>th</sup> to 4<sup>th</sup> to 1<sup>st</sup>; under

 *   the dense ranking scheme, her ranking will go from 4<sup>th</sup> to

 *   3<sup>rd</sup> to 1<sup>st</sup>.

 * </p>

 * <p>

 *   Your programming task is to implement a method (or 2 of them, for

 *   additional credit) that takes 2 parameters:

 * </p>

 * <ol>

 *   <li><code>int[] leaderboard</code> &ndash; the other player's scores

 *   (already assumed to have completed the competition), in descending

 *   order.</li>

 *   <li><code>int[] scores</code> &ndash; the scores of the player to be

 *   ranked (Alice's scores in the example above). These will be in ascending

 *   order; your code can be written so that it doesn't require that these

 *   scores are in ascending order, but you might take advantage of this for

 *   some interesting efficiency optimizations (as well as extra credit).</li>

 * </ol>

 * <p>

 *   Your primary task is to implement competition ranking in the

 *   <code>getCompetitionRanking</code> method, using the inputs described above

 *   to compute and return an <code>int[]</code> of rankings, where each element

 *   of the result is the competition ranking for the corresponding score in

 *   <code>scores</code>.

 * </p>

 * <p>

 *   For extra credit, you may also implement the <code>getDenseRanking</code>

 *   method to implement the dense ranking scheme. The parameters and return

 *   type of this method are the same as those of the

 *   <code>getCompetitionRanking</code> method; the array returned, however,

 *   should contain dense rankings corresponding to the <code>scores</code>

 *   array.

 * </p>

 * <h3>Assumptions</h3>

 * <ol>

 *   <li>As noted above, the elements <code>leaderboard</code> will be in

 *   descending order; however, since there may be ties, this order will not

 *   necessarily be <i>strictly</i> descending.</li>

 *   <li>The elements of <code>scores</code> will be in ascending (again, not

 *   necessarily strictly ascending) order. You are welcome to take advantage of

 *   this (and extra credit is available for skillful use of this constraint),

 *   though it is not necessary to do so.</li>

 *   <li>The lengths of the <code>leaderboard</code> and <code>scores</code>

 *   arrays will be in the range from 1 to 1,000,000 (inclusive).</li>

 *   <li>The lengths of the <code>leaderboard</code> and <code>scores</code>

 *   arrays will not necessarily be the same; the returned result, of course,

 *   must be an array of the same size as <code>scores</code>.</li>

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

 *       <th><code>leaderboard</code></th>

 *       <th><code>scores</code></th>

 *       <th><code>getCompetitionRanking(leaderboard, scores)</code></th>

 *       <th><code>getDenseRanking(leaderboard, scores)</code></th>

 *     </tr>

 *   </thead>

 *   <tbody>

 *     <tr>

 *       <td><code>{100, 100, 50, 40, 40, 20, 10}</code></td>

 *       <td><code>{5, 25, 50, 120}</code></td>

 *       <td><code>{8, 6, 3, 1}</code></td>

 *       <td><code>{6, 4, 2, 1}</code></td>

 *     </tr>

 *     <tr>

 *       <td><code>{100, 90, 80, 80, 80, 20}</code></td>

 *       <td><code>{10, 50, 80, 90}</code></td>

 *       <td><code>{7, 6, 3, 2}</code></td>

 *       <td><code>{5, 4, 3, 2}</code></td>

 *     </tr>

 *   </tbody>

 * </table>

 */

public class Leaderboard {



  /**

   * Computes and returns an array of rankings, corresponding to the values in

   * the <code>scores</code> array. These should use the common "competition"

   * ranking scheme &ndash; for example, if 2 players are tied for

   * 1<sup>st</sup> place, the player with the next lower score is assumed to

   * in 3<sup>rd</sup> place. Another way of thinking about this scheme is that

   * if a player is in <i>n</i><sup>th</sup> place, according to this scheme,

   * then there are exactly (<i>n</i> - 1) players with a higher score.

   *

   * @param leaderboard scores on the leaderboard, in non-ascending order.

   * @param scores      scores to be ranked against leaderboard scores.

   * @return            resulting ranks.

   */

  public static int[] getCompetitionRanking(int[] leaderboard, int[] scores) {

    // TODO Implement method.

  }



  /**

   * Computes and returns an array of rankings, corresponding to the values in

   * the <code>scores</code> array. These should use the dense ranking scheme

   * &ndash; for example, if 2 players are tied for 1<sup>st</sup> place, the

   * player with the next lower score is assumed to be in 2<sup>rd</sup> place.

   * Another way of thinking about this scheme is that if a player is in

   * <i>n</i><sup>th</sup> place, according to this scheme, then there are

   * exactly (<i>n</i> - 1) higher score values, some of which may have been

   * scored by more than one player.

   *

   * @param leaderboard scores on the leaderboard, in non-ascending order.

   * @param scores      scores to be ranked against leaderboard scores.

   * @return            resulting ranks.

   */

  public static int[] getDenseRanking(int[] leaderboard, int[] scores) {

    // TODO Implement method for EXTRA CREDIT!

  }



}