The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given an integer array nums, return the sum of Hamming distances between all the pairs of the integers in nums.

 

Example 1:

Input: nums = [4,14,2]
Output: 6
Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
showing the four bits relevant in this case).
The answer will be:
HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
Example 2:

Input: nums = [4,14,4]
Output: 4
  
  class Solution {
    public int totalHammingDistance(int[] nums) {
        int total = 0;
        
		for(int i = 0; i < 32; i++)
		{
			int countOnes = 0;
            int countZeros = 0;

			for(int x : nums)
			{
				if((x >> i & 1) == 1)
                    countOnes++;
                else
                    countZeros++;
			} 
			total += countOnes * countZeros;
		}
		return total;
    }
}

// 0 1 0 0
// 1 1 1 0
// 0 0 1 0

// number of 1 in first column is 1, num(0) = 2, so it is 1 * 2
// number of 1 in second column is 2, num(0) = 1, so it is 2 * 1 
// number of 1 in third column is 2, num(0) = 2, so it is 1 * 2
    
//     result is 2 + 2 + 2 = 6
