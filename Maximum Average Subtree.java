Given the root of a binary tree, return the maximum average value of a subtree of that tree. Answers within 10-5 of the actual answer will be accepted.

A subtree of a tree is any node of that tree plus all its descendants.

The average value of a tree is the sum of its values, divided by the number of nodes.

 5
6 1 
Example 1:


Input: root = [5,6,1]
Output: 6.00000
Explanation: 
For the node with value = 5 we have an average of (5 + 6 + 1) / 3 = 4.
For the node with value = 6 we have an average of 6 / 1 = 6.
For the node with value = 1 we have an average of 1 / 1 = 1.
So the answer is 6 which is the maximum.
Example 2:

Input: root = [0,null,1]
Output: 1.00000
  
  /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // Time is O(n)
    // space is 0(n)
        
    double max = Double.MIN_VALUE;
        
    public double maximumAverageSubtree(TreeNode root) {
        helper(root);
        return max;
    }
    public int[] helper(TreeNode root){
        if (root == null){
            return new int[]{0, 0};
        }
        int[] result = new int[2];
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        
        result[0] = left[0] + right[0] + root.val;
        result[1] = left[1] + right[1] + 1;
        max = Math.max(max, (double)result[0] / (double)result[1]);
        return result;
    }
}   
    
    
