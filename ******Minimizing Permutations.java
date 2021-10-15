
Anonymous User
Anonymous User
April 1, 2021 10:17 AM

10.8K VIEWS

Here's a graph question on the Facebook recruiting portal:

Minimizing Permutations

In this problem, you are given an integer N, and a permutation, P of the integers from 1 to N, denoted as (a_1, a_2, ..., a_N). You want to rearrange the elements of the permutation into increasing order, repeatedly making the following operation:
Select a sub-portion of the permutation, (a_i, ..., a_j), and reverse its order.
Your goal is to compute the minimum number of such operations required to return the permutation to increasing order.

Signature

int minOperations(int[] arr)
Input
Array arr is a permutation of all integers from 1 to N, N is between 1 and 8

Output
An integer denoting the minimum number of operations required to arrange the permutation in increasing order
Example
If N = 3, and P = (3, 1, 2), we can do the following operations:
Select (1, 2) and reverse it: P = (3, 2, 1).
Select (3, 2, 1) and reverse it: P = (1, 2, 3).
output = 2


  
  Solved it using a heap and a map.
Heap is to fetch numbers in increasing order.
Map is to maintain the index of the numbers as we go:

int minOperations(int[] arr) {

	Map<Integer, Integer> updatedIndexes = new HashMap<>(); 
	PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> a - b);
	for(int i = 0; i < arr.length; i++) {
		heap.add(arr[i]);
		updatedIndexes.put(arr[i], i);
	}

	int curr = 0;
	int swapCount = 0;
	while(!heap.isEmpty()) {
		int n = heap.poll();
		if(n < arr[curr]) {
			reverse(arr, Math.min(updatedIndexes.get(n), curr), Math.max(updatedIndexes.get(n), curr), updatedIndexes);
			swapCount++;
		}
		curr++;
	}
	
	return swapCount;
}

private void reverse(int[] arr, int min, int max, Map<Integer, Integer> updatedIndexes) {
	
	for(int i = min, j = max; i <= max && j > i; i++, j--) {
		swap(arr, i, j);
		updatedIndexes.put(arr[i], i);
		updatedIndexes.put(arr[j], j);
	}
}
   
   private void swap(int[] arr, int i, int j) {
	int temp = arr[i];
	arr[i] = arr[j];
	arr[j] = temp;
}
