Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

Implement the MovingAverage class:

MovingAverage(int size) Initializes the object with the size of the window size.
double next(int val) Returns the moving average of the last size values of the stream.
 

Example 1:

Input
["MovingAverage", "next", "next", "next", "next"]
[[3], [1], [10], [3], [5]]
Output
[null, 1.0, 5.5, 4.66667, 6.0]

Explanation
MovingAverage movingAverage = new MovingAverage(3);
movingAverage.next(1); // return 1.0 = 1 / 1
movingAverage.next(10); // return 5.5 = (1 + 10) / 2
movingAverage.next(3); // return 4.66667 = (1 + 10 + 3) / 3
movingAverage.next(5); // return 6.0 = (10 + 3 + 5) / 3


class MovingAverage {
// using double-ended queue
// time is O(1), space is O(n)
    int size;
    int sum;
    int count;
    Deque<Integer> queue;

  public MovingAverage(int size) {
      queue = new ArrayDeque<Integer>();
      this.size = size;
      sum = 0;
      count = 0;
  }

  public double next(int val) {
        count++;
        // calculate the new sum by shifting the window
        queue.add(val);
        int tail = count > size ? (int)queue.poll() : 0;

        sum = sum - tail + val;

        return sum * 1.0 / Math.min(size, count);
    }

}


/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
