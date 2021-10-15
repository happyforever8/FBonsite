653. Two Sum IV - Input is a BST

Share
Given the root of a Binary Search Tree and a target number k, 
return true if there exist two elements in the BST such that their sum is equal to the given target.

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        
        return helper(root, set, k);
    }
    
    public boolean helper(TreeNode root, Set<Integer> set, int k){
        if (root == null){
            return false;
        }
        if (set.contains(k - root.val)){
            return true;
        }
        set.add(root.val);
        return helper(root.left, set, k) || helper(root.right, set, k);
    }
}


given a binary tree, find 2 nodes in different levels which sum up to given target

create a class, 

Pari{
  TreeNode node,
  int level
}


Given a binary tree and an integer K, return two nodes which are at different level and their sum is equal to K.

Constraints :

Tree can have duplicate values.
Incase more than one pair is available in the tree, then return any of the pair.



Level order + HashMap (idea of one pass two sum problem solution)

 public List<TreeNode> treeSum(TreeNode root,int k){
        if(root==null){
            return null;
        }
        List<TreeNode> result = new ArrayList<>();
        Map<Integer,TreeNode> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode curr = null;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                curr = queue.poll();
                if(map.containsKey((k-curr.val))){
                    result.add(map.get(k-curr.val));
                    result.add(curr);
                    return result;
                }
                
                map.put(curr.val,curr); 
                if(curr.left!=null) queue.add(curr.left);
                if(curr.right!=null) queue.add(curr.right);
            }
        }
        return result;
    }

