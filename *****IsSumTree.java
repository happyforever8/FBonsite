Write a function that returns true if the given Binary Tree is 
SumTree else false. A SumTree is a Binary Tree where the value of
a node is equal to the sum of the nodes present in its left subtree 
and right subtree. An empty tree is SumTree and the sum of an empty tree can be considered as 0. A leaf node is also considered as SumTree.

Following is an example of SumTree. 
          26
        /   \
      10     3
    /    \     \
  4      6      3
  
  Get the sum of nodes in the left subtree and right subtree. 
  Check if the sum calculated is equal to the root’s data. Also, recursively check if the left and right subtrees are SumTrees.
    
 Time Complexity: O(n^2) in the worst case. 
package fb;

public class isSumTree {

	static class TreeNode{
		int value;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int value){
			this.value = value;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        TreeNode root = new TreeNode(26);
        
        root.left=new TreeNode(10);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(6);
        root.right.right=new TreeNode(3);
        
        System.out.println(isSumTree(root));
	}
	
	public static boolean isSumTree(TreeNode root){
		if (root == null){
			return true;
		}
		if (root.left == null && root.right == null){
			return true;
		}
		
		int leftSum = sum(root.left);
		int rightSum = sum(root.right);
		
		if (root.value == leftSum + rightSum && (isSumTree(root.left)) && (isSumTree(root.right))){
			return true;
		}
		return false;
		
	}
	public  static int sum(TreeNode root){
		if (root == null){
			return 0;
		}
		return sum(root.left) + root.value + sum(root.right);
	}
	

}
