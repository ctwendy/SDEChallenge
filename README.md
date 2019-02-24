# PaytmLabs SDE Challenge

## LastNMovingAverage

LastNMovingAverage is an interface for calculating last N moving targets average values.

## Usage

### Implementation
The implementation for `LastNMovingAverage` interface is `LastNMovingAverageImpl` which you could construct by passing `N` value as argument.

```
public LastNMovingAverageImpl(int N)
```

### Interface Methods

| return type | method | description |
| ----------- | ------ | ----------- |
| void | add | add an new item/value to the data structure |
| double | getLastNAverage | get current last N average value to the 2 decimal precision |
| List<Double> | getLastNAverageElements | get current elements list for calculating average |

## Efficiency & Memory usage

### Efficiency
There are two situation for calculating average.
1. when the current elements size is smaller than size N.
  we will calculate the average by formula \
  `(previous_average * current_elements_size + new_add_element) / current_element_size + 1`
2. when the current elements size is equal to N.
   we will calculate the average by formula \
  `(previous_average * N - first_element + new_add_element) / N`

Since I choose an queue for the underneath data structure, it will always hold just N elements. There is no case that the current elements size is larger than N.
Both actions for calculating average efficiency are O(1) 

### Memery usage
While there are multiple ways for underneath data structure implementation, I chosse `Queue`(com.google.common.collect.Queues.newArrayDeque) to limit down the memory usage. Which mean at all time it will hold max N elements (or N + 1 during the calculation). 
On other hand if we choose using a `List`, it will need to hold up to M (total size of user input elements) otherwise we need furing action to redue the memory usage.

Also, since google deque underneath is using a object array, it can retrieve the elements easily.


