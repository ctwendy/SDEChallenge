package paytm.exercise;

import static com.google.common.collect.Queues.newArrayDeque;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class LastNMovingAverageImpl implements LastNMovingAverage {

  private static final int PRECISION = 2;

  private Queue<Double> itemsQueue;
  private int N;
  private double currentAverage;

  public LastNMovingAverageImpl(int N) {
    this.N = N;
    this.currentAverage = 0d;
    this.itemsQueue = newArrayDeque();
  }

  @Override
  public void add(double newItem) {
    if (N != 0) {
      itemsQueue.add(newItem);
      this.currentAverage = updateCurrentAverage(newItem);
    }
  }

  @Override
  public double getLastNAverage() {
    return new BigDecimal(currentAverage).setScale(PRECISION, RoundingMode.HALF_UP).doubleValue();
  }

  @Override
  public List<Double> getLastNAverageElements() {
    return itemsQueue.stream().map(item -> item.doubleValue()).collect(Collectors.toList());
  }

  private double updateCurrentAverage(double newItem) {
    int currentQueueSize = itemsQueue.size();
    double currentSum = currentAverage * (currentQueueSize - 1);

    if (currentQueueSize <= N) {
      return (currentSum + newItem) / currentQueueSize;
    } else {
      return (currentSum - itemsQueue.remove() + newItem) / N;
    }
  }

}
