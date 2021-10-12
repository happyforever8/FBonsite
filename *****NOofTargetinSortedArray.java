34. Find First and Last Position of Element in Sorted Array

1.  number of occurrences of a given number in a sorted list. 
  input: [10, 10, 20, 20, 20, 30, 40], n = 20, output: 3。要求O(logn)
    
    class Solution {
    // time is O(logN)
    // space is O(1)
    public int searchRange(int[] nums, int target) {
       
        
        if (nums == null || nums.length == 0){
            return result;
        }
        int left = helper(nums, target, -1);
        int right = helper(nums, target, 1);
        
        if (left == right == -1){
          return 0;
        }
        return right - left + 1
    }
    
    public int helper(int[] nums, int target, int direction){
        int result = -1;
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right){
            int mid = left + (right - left) / 2;
            
            if (direction == -1){
                if (nums[mid] >= target){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] <= target){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if (nums[mid] == target){
                result = mid;
            }
        }
        return result;
    }
}
