iven number M and N intervals in the form [a, b] (inclusive) where for every 
interval -M <= a <= b <= M, create a program that returns a point where the maximum number of intervals overlap.

Example:

M: 10
N: 4
Intervals:
[-3, 5]
[0, 2]
[8, 10]
[6, 7]
A correct answer would be either 0 ,1 or 2 since those points are found where 2 intervals overlap and 2 is the maximum number of overlapping intervals.
  
  import java.util.*;
public class HelloWorld{

   public static void main(String[] args) {
	int m = 10, n = 4;
	//int[][] intervals = {{-3, 5}, {0,2}, {8, 10}, {6, 7}};
		int[][] intervals = {{-3, 5}, {1,2}, {8, 10}, {6, 7}};
	System.out.println(getMaxPoint(intervals, n));
}

private static int getMaxPoint(int[][] intervals, int n) {
	Queue<int[]> minHeap = new PriorityQueue<>((a, b)-> a[0] - b[0]);
	int res = Integer.MIN_VALUE;
	int gloMax = 0;
	int max = 0;
	for(int[] it : intervals) {
		minHeap.offer(new int[] {it[0], 1});
		minHeap.offer(new int[] {it[1], -1});
	}
	while(!minHeap.isEmpty()) {
		int[] cur = minHeap.poll();
		max += cur[1];
		if(max > gloMax) {
			gloMax = max;
			res = cur[0];
		}
	}
	return res;
}
}
