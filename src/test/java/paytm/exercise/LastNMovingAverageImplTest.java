package paytm.exercise;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.List;
import org.junit.Test;

public class LastNMovingAverageImplTest {

  @Test
  public void calculateLast2MovingElementAverage() {
    List<Double> resultsAverage = newArrayList();
    List<List<Double>> resultsElemtns = newArrayList();

    LastNMovingAverage last2MovingAverage = new LastNMovingAverageImpl(2);
    last2MovingAverage.add(1d);
    resultsAverage.add(last2MovingAverage.getLastNAverage());
    resultsElemtns.add(last2MovingAverage.getLastNAverageElements());

    last2MovingAverage.add(2d);
    resultsAverage.add(last2MovingAverage.getLastNAverage());
    resultsElemtns.add(last2MovingAverage.getLastNAverageElements());

    last2MovingAverage.add(5.5d);
    resultsAverage.add(last2MovingAverage.getLastNAverage());
    resultsElemtns.add(last2MovingAverage.getLastNAverageElements());

    last2MovingAverage.add(3.75d);
    resultsAverage.add(last2MovingAverage.getLastNAverage());
    resultsElemtns.add(last2MovingAverage.getLastNAverageElements());

    List<Double> expectedResultsAverage = newArrayList(1d, 1.5d, 3.75d, 4.63d);
    List<List<Double>> expectedResultsElements = newArrayList();
    expectedResultsElements.add(newArrayList(1d));
    expectedResultsElements.add(newArrayList(1d, 2d));
    expectedResultsElements.add(newArrayList(2d, 5.5d));
    expectedResultsElements.add(newArrayList(5.5d, 3.75d));

    assertThat(resultsAverage, equalTo(expectedResultsAverage));
    assertThat(resultsElemtns, equalTo(expectedResultsElements));
  }

  @Test
  public void calculateLast5MovingElementAverage() {
    List<Double> results = newArrayList();
    List<List<Double>> resultsElemtns = newArrayList();

    LastNMovingAverage last5MovingAverage = new LastNMovingAverageImpl(5);
    last5MovingAverage.add(1d);
    results.add(last5MovingAverage.getLastNAverage());
    resultsElemtns.add(last5MovingAverage.getLastNAverageElements());

    last5MovingAverage.add(2d);
    results.add(last5MovingAverage.getLastNAverage());
    resultsElemtns.add(last5MovingAverage.getLastNAverageElements());

    last5MovingAverage.add(5.5d);
    results.add(last5MovingAverage.getLastNAverage());
    resultsElemtns.add(last5MovingAverage.getLastNAverageElements());

    last5MovingAverage.add(3.75d);
    results.add(last5MovingAverage.getLastNAverage());
    resultsElemtns.add(last5MovingAverage.getLastNAverageElements());

    last5MovingAverage.add(9.99d);
    results.add(last5MovingAverage.getLastNAverage());
    resultsElemtns.add(last5MovingAverage.getLastNAverageElements());

    last5MovingAverage.add(3.99d);
    results.add(last5MovingAverage.getLastNAverage());
    resultsElemtns.add(last5MovingAverage.getLastNAverageElements());

    List<Double> expectedResults = newArrayList(1d, 1.5d, 2.83d, 3.06d, 4.45d, 5.05d);
    List<List<Double>> expectedResultsElements = newArrayList();
    expectedResultsElements.add(newArrayList(1d));
    expectedResultsElements.add(newArrayList(1d, 2d));
    expectedResultsElements.add(newArrayList(1d, 2d, 5.5d));
    expectedResultsElements.add(newArrayList(1d, 2d, 5.5d, 3.75d));
    expectedResultsElements.add(newArrayList(1d, 2d, 5.5d, 3.75d, 9.99d));
    expectedResultsElements.add(newArrayList(2d, 5.5d, 3.75d, 9.99d,3.99d));

    assertThat(results, equalTo(expectedResults));
    assertThat(resultsElemtns, equalTo(expectedResultsElements));
  }

  @Test
  public void calculateLast0MovingElementAverage() {
    List<Double> results = newArrayList();
    List<List<Double>> resultsElemtns = newArrayList();

    LastNMovingAverage last0MovingAverage = new LastNMovingAverageImpl(0);
    last0MovingAverage.add(1d);
    results.add(last0MovingAverage.getLastNAverage());
    resultsElemtns.add(last0MovingAverage.getLastNAverageElements());

    last0MovingAverage.add(2d);
    results.add(last0MovingAverage.getLastNAverage());
    resultsElemtns.add(last0MovingAverage.getLastNAverageElements());

    List<Double> expectedResults = newArrayList(0d, 0d);
    List<List<Double>> expectedResultsElements = newArrayList();
    expectedResultsElements.add(newArrayList());
    expectedResultsElements.add(newArrayList());

    assertThat(results, equalTo(expectedResults));
    assertThat(resultsElemtns, equalTo(expectedResultsElements));
  }
}