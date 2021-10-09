Given a non-empty array nums containing only positive integers, 
find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

 follow up : 698. Partition to K Equal Sum Subsets

Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
  
  class Solution {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0){
            return true;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if (sum % 2 != 0){
            return false;
        }
        sum /= 2;
        
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        
        for (int i = 1; i < nums.length; i++){
            for (int j = sum; j >= nums[i]; j--){
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[sum];
        
//         if (nums == null || nums.length == 0){
//             return true;
//         }
//         int sum = 0;
        
//         for (int num : nums){
//             sum += num;
//         }
//         if (sum % 2 != 0){
//             return false;
//         }
//         sum /= 2;
        
//         boolean[] dp = new boolean[sum + 1];
//         dp[0] = true;
        
//         for (int i = 1; i < nums.length; i++){
//             for (int j = sum; j >= nums[i]; j--){
//                 dp[j] = dp[j] || dp[j - nums[i]];
//             }
//         }
//         return dp[sum];
    }
}
