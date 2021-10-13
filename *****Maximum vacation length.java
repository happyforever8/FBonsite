Variation of https://leetcode.com/problems/max-consecutive-ones-iii/
Given boolean array of days at work, [T, F, T, T, F, F, F, T] and 
pto (number of PTOs one can take) - where boolean T means paid holiday 
and F means you can take a PTO. Find the maximum length of vacation an employee can take.

int findMaxVacationLength(year = [F, T, F, T, F, T, F, ], pto = 2) 
  should return 5 because if we take PTO on indices year[2] and year[4], 
then we can get the maximum length vacation (consecutive T's).
                                             
                                             
     public static void main(String []args){
        System.out.println("Hello World");
        
        boolean[] days = {true, false, true, true, false, false, false, true};
        
        System.out.println(findMaxVacationLength(days, 2));
     }
     
 public static  int findMaxVacationLength(boolean[] days, int pto) {
    int counter = 0;
    int start = 0;
    int end = 0;
    int len = 0;
   // for (int end = 0; end < days.length; end++) {
    while (end < days.length){
        
      if (!days[end]) {
        counter++;
      }
      end++;
      while (counter > pto) {
        if (!days[start]) {
          counter--;
        }
        start++;
      }
      len = Math.max(len, end - start);
    }
    return len;
  }                       
}                                         
        
       给一字符串表示working days和holidays，再给一个pto_balance，求用掉balance可以得到的最长假期 （蠡口 咬琳零寺变体）
 
 Given a binary array nums and an integer k, return the maximum number 
 of consecutive 1's in the array if you can flip at most k 0's.

 

Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
  
  class Solution {
    // time is O(n);
    // space is O(n);
    public int longestOnes(int[] nums, int k) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int left = 0;
        int right = 0;
        
        int zeroCount = 0;
        int max = 0;
        
        while (right < nums.length){
            if (nums[right] == 0){
                zeroCount++;
            }
            right++;
             // if zeroCount is less than k, we can continue;
            // if zeroCount is greater than k, we can contaract our window
            while (zeroCount > k){
                if (nums[left] == 0){
                    zeroCount--;
                }
                left++;
            }
            max = Math.max(max, right - left);
        }
        return max;
    }
}
                                                                                                           
