Given an array arr[0 .. n-1] of distinct integers, the task is to find a
local minima in it. We say that an element arr[x] is a local minimum if it is less than or equal to both its neighbors.

For corner elements, we need to consider only one neighbor for comparison.
There can be more than one local minima in an array, we need to find any one of them.
Examples:

Input: arr[] = {9, 6, 3, 14, 5, 7, 4};
Output: Index of local minima is 2
The output prints index of 3 because it is 
smaller than both of its neighbors. 
Note that indexes of elements 5 and 4 are 
also valid outputs.

Input: arr[] = {23, 8, 15, 2, 3};
Output: Index of local minima is 1

Input: arr[] = {1, 2, 3};
Output: Index of local minima is 0

Input: arr[] = {3, 2, 1};
Output: Index of local minima is 2
  
  // A binary search based function that returns
    // index of a local minima.
    public static int localMinUtil(int[] arr, int low, 
                                   int high, int n)
    {
          
        // Find index of middle element
        int mid = low + (high - low) / 2;
          
         // Compare middle element with its neighbours
        // (if neighbours exist)
        if(mid == 0 || arr[mid - 1] > arr[mid] && mid == n - 1 || 
           arr[mid] < arr[mid + 1])
                return mid;
          
        // If middle element is not minima and its left
        // neighbour is smaller than it, then left half
        // must have a local minima.
        else if(mid > 0 && arr[mid - 1] < arr[mid])
                return localMinUtil(arr, low, mid - 1, n);
          
        // If middle element is not minima and its right
        // neighbour is smaller than it, then right half
        // must have a local minima.
        return localMinUtil(arr, mid + 1, high, n);
    }
      
    // A wrapper over recursive function localMinUtil()
    public static int localMin(int[] arr, int n)
    {
        return localMinUtil(arr, 0, n - 1, n);
    }
      
      
    public static void main (String[] args) 
    {
          
        int arr[] = {4, 3, 1, 14, 16, 40};
        int n = arr.length;
        System.out.println("Index of a local minima is " + localMin(arr, n));
     
    }
}
  
===== find peak =============
  
  A peak element is an element that is strictly greater than its neighbors.

Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞.

You must write an algorithm that runs in O(log n) time.

 

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
  
  
  class Solution {
    
// 首先要注意题目条件，在题目描述中出现了 nums[-1] = nums[n] = -∞
// ，这就代表着 只要数组中存在一个元素比相邻元素大，那么沿着它一定可以找到一个峰值
// 根据上述结论，我们就可以使用二分查找找到峰值
// 查找时，左指针 l，右指针 r，以其保持左右顺序为循环条件
// 根据左右指针计算中间位置 m，并比较 m 与 m+1 的值，如果 m 较大，则左侧存在峰值，r = m，如果 m + 1 较大，则右侧存在峰值，l = m + 1
// 时间复杂度：O(logN)


    public int findPeakElement(int[] nums) {
        if (nums == null){
            return -1;
        }
        if (nums.length == 0){
            return 0;
        }
        
        int start = 0;
        int end = nums.length - 1;
        
        while (start < end){
            int mid = start + (end - start) / 2;
            
            if (nums[mid] < nums[mid + 1]){
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
