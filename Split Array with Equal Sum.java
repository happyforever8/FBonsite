Given an integer array nums of length n, return true if there is a triplet (i, j, k) which satisfies the following conditions:

0 < i, i + 1 < j, j + 1 < k < n - 1
The sum of subarrays (0, i - 1), (i + 1, j - 1), (j + 1, k - 1) and (k + 1, n - 1) is equal.
A subarray (l, r) represents a slice of the original array starting from the element indexed l to the element indexed r.
 

Example 1:

Input: nums = [1,2,1,2,1,2,1]
Output: true
Explanation:
i = 1, j = 3, k = 5. 
sum(0, i - 1) = sum(0, 0) = 1
sum(i + 1, j - 1) = sum(2, 2) = 1
sum(j + 1, k - 1) = sum(4, 4) = 1
sum(k + 1, n - 1) = sum(6, 6) = 1
Example 2:

Input: nums = [1,2,1,2,1,2,1,2]
Output: false
  
  class Solution {
//     本方法中，首先计算累加和数组 sumsum，其中 sum[i]sum[i] 
//         表示数组 numsnums 前 ii 项和。然后遍历第二个分割点 jj 所有可能的位置
//         。对每一个 jj，首先计算其左边分割点的位置 ii，
//         使得第一个子数组和第二个子数组的和相等，
//         即满足 sum[i-1] = sum [j-1] - sum[i]sum[i−1]=sum[j−1]−sum[i]，
//         并将该累加和存储到 HashSet 中（对每个 jj，都会创建一个新的 HashSet）。
//         因此，HashSet 中的累加和表示当中间分割点为 jj 时，
//         怎样的累加和会让第一个子数组和第二个子数组之和相等。

// 然后计算 jj 右边分割点 kk 的位置，
//         使得第三个子数组的和与第四个子数组的和相等，
//         即满足 sum[n-1]-sum[k]=sum[k-1] - sum[j]sum[n−1]−sum[k]=sum[k−1]−sum[j]。
//         再到 HashSet 中查找是否存在相等的子数组和。
//         如果存在，则找到满足条件的三元组 (i, j, k)(i,j,k)，否则不存在这样的分割方法。


    
    
    public boolean splitArray(int[] nums) {
        // time is O(n^2)
        // space is o(n)
        
        // step1, calculate presum
        // step2, using set to cache the result
        
        
        if (nums.length < 7){
            return false;
        }
        
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        
        for (int i = 1; i < nums.length; i++){
            sum[i] = sum[i - 1] + nums[i];
        }
        
        for (int j = 3; j < nums.length - 3; j++){
            Set<Integer> set = new HashSet<>();
            
            for (int i = 1; i < j - 1; i++ ){
                if (sum[i - 1] == sum[j - 1] - sum[i]){
                    set.add(sum[i - 1]);
                }
            }
            
            for (int k = j + 1; k < nums.length - 1; k++){
                if (sum[nums.length - 1] - sum[k] == sum[k - 1] - sum[j] && 
                   set.contains(sum[k - 1] - sum[j])){
                    return true;
                }
            }
        }
        return false;
    }
}














