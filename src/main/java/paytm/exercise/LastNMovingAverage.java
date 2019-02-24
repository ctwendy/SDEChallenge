package paytm.exercise;

import java.util.List;

/**
 * A LastNAverage will return current will hold the last N elements and return both the elements and average values.
 * You can use add method to continue extend the moving average.
 *
 * @author Wendy Chen
 * @param <E> the type of elements held in this collection
 */
public interface LastNMovingAverage {
  /**
   * Inserts the number element into this LastNMovingAverage without any return
   *
   * @param item the element to add
   * @return none
   */
  void add(double item);
  /**
   * Return current Last N average value to the precision of 2
   *
   * @return last N average
   */
  double getLastNAverage();
  /**
   * Return current elements for calculating Last N elements average value.
   *
   * @return the N elements to calculate the average
   */
  List<Double> getLastNAverageElements();

}
