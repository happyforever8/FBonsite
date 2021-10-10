Given the root of a binary tree, return the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child 
connections. 
*****The longest consecutive path needs to be from parent to child (cannot be the reverse).*****
class Solution {
    int max = 0;
    public int longestConsecutive(TreeNode root) {
        if (root == null){
            return 0;
        }
        helper(root);
        return max;
    }
    public int helper(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = helper(root.left) + 1;
        int right = helper(root.right) + 1;
        
        if (root.left != null && root.val + 1 != root.left.val){
            left = 1;
        }
        if (root.right != null && root.val + 1 != root.right.val){
            right = 1;
        }
        int currMax = Math.max(left, right);
        
        max = Math.max(max, currMax);
        
        return currMax;
    }
}


******** follow up **************
On the other hand, the path can be in the child-Parent-child order, where not necessarily be parent-child order.
  
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
    int maxLen = 0;
    public int longestConsecutive(TreeNode root) {
        if (root == null){
            return 0;
        }
        helper(root);
        return maxLen;
    }
    public int[] helper(TreeNode root){
        if (root == null){
            return new int[0];
        }
        
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int inc = 1;
        int dec = 1;
        
        if (root.left != null){
            if (root.val == root.left.val + 1){
                dec = left[1] + 1;
            }
            if (root.val == root.left.val - 1){
                inc = left[0] + 1;
            }
        }
        if (root.right != null){
            if (root.val == root.right.val + 1){
                dec = Math.max(dec, right[1] + 1);
            }
            if (root.val == root.right.val - 1){
                inc = Math.max(inc, right[0] + 1);
            }
        }
        maxLen = Math.max(maxLen, inc + dec - 1);
        return new int[]{inc, dec};
    }
}
