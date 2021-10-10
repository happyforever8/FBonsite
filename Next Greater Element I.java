The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.

You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.

For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.

Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.

 

Example 1:

Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
Output: [-1,3,-1]
Explanation: The next greater element for each value of nums1 is as follows:
- 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
- 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
- 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
  
  
  class Solution {
    
    // time is O(m + n)
    // space is O(m + n)
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new ArrayDeque<>();
        
        // key is the value
        // value is the number greater than value
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[nums1.length];
        
        for (int i = 0; i < nums2.length; i++){
            while (!stack.isEmpty() && stack.peek() < nums2[i]){
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        
        for (int i = 0; i < nums1.length; i++){
            result[i] = map.getOrDefault(nums1[i], -1);
        }
        return result;
=========================
        
        503. Next Greater Element II
        
        Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] 
         is nums[0]), return the next greater number for every element in nums.

The next greater number of a number x is the first greater number to its
       traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.

 

Example 1:

Input: nums = [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number. 
The second 1's next greater number needs to search circularly, which is also 2.
    }
    
    
    
    class Solution {
    // time is O(n)
    // space is O(n)
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0){
            return new int[0];
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[nums.length];
        
        Arrays.fill(result, -1);
        for (int i = 0; i < nums.length * 2; i++){
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % nums.length]){
                result[stack.pop()] = nums[i % nums.length];
            }
            stack.push(i % nums.length);
        }
        return result;
    }
}
}

=================556. Next Greater Element III=================================
 
 Given a positive integer n, find the smallest integer which has exactly 
 the same digits existing in the integer n and is greater in value than n. If no such positive integer exists, return -1.

Note that the returned integer should fit in 32-bit integer, if there is a valid answer but it does not fit in 32-bit integer, return -1.

 

Example 1:

Input: n = 12
 
 
 class Solution {
    
    // same as next permutation 
    // time is O(n)
    // space is O(n)
    public int nextGreaterElement(int n) {
        String str = String.valueOf(n);
        
        char[] ch = str.toCharArray();
        
        int i = ch.length - 2;
        
        while(i >= 0 && ch[i] >= ch[i + 1]){
            i--;
        }
        if (i == -1){
            return -1;
        }
        
        int j = ch.length - 1;
        
        if (i >= 0){
            while (i >= 0 && ch[i] >= ch[j]){
                j--;
            }
        }
        swap(ch, i, j);
        reverse(ch, i + 1);
        
        if (Long.valueOf(String.valueOf(ch)) > Integer.MAX_VALUE){
            return -1;
        } 
        return Integer.valueOf(String.valueOf(ch));
        
    }

        
    public void swap(char[] ch, int i, int j){
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
    
    public void reverse(char[] ch, int i){
        int start = i;
        int end = ch.length - 1;
        
        while (start <= end){
            swap(ch, start, end);
            start++;
            end--;
        }
        
    }
}
Output: 21
