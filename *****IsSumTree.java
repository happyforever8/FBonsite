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






          13
        /   \
      10     3
    /    \     \
  4      6      3  return true
  

// the following only check for sum of directly connected node 
class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
} 
   
class BinaryTree  
{ 
    Node root; 
   
    /* returns 1 if children sum property holds for the given 
    node and both of its children*/
    int isSumProperty(Node node)  
    { 
           
        /* left_data is left child data and right_data is for right  
           child data*/
        int left_data = 0, right_data = 0; 
   
        /* If node is NULL or it's a leaf node then 
        return true */
        if (node == null
                || (node.left == null && node.right == null)) 
            return 1; 
        else
        { 
              
            /* If left child is not present then 0 is used 
               as data of left child */
            if (node.left != null)  
                left_data = node.left.data; 
   
            /* If right child is not present then 0 is used 
               as data of right child */
            if (node.right != null)  
                right_data = node.right.data; 
   
            /* if the node and both of its children satisfy the 
               property return 1 else 0*/
            if ((node.data == left_data + right_data) 
                    && (isSumProperty(node.left)!=0) 
                    && isSumProperty(node.right)!=0) 
                return 1; 
            else
                return 0; 
        } 
    } 
      
    /* driver program to test the above functions */
    public static void main(String[] args)  
    { 
        BinaryTree tree = new BinaryTree(); 
        tree.root = new Node(10); 
        tree.root.left = new Node(8); 
        tree.root.right = new Node(2); 
        tree.root.left.left = new Node(3); 
        tree.root.left.right = new Node(5); 
        tree.root.right.right = new Node(2); 
        if (tree.isSumProperty(tree.root) != 0) 
            System.out.println("The given tree satisfies children"
                    + " sum property"); 
        else
            System.out.println("The given tree does not satisfy children"
                    + " sum property"); 
    } 
} 
==========================is the parent is the average of the children=====
	
	import java.util.*;

public class HelloWorld{

    static class TreeNode{
			int value;
			TreeNode left;
			TreeNode right;
			
			public TreeNode(int value){
				this.value = value;
			}
		}
		
	 //         5
//	         /   \
//	       5       5
//	     /    \     \
	//  4      6     5
	    static Map<TreeNode, List<TreeNode>> map = new HashMap<>();
		public static void main(String[] args) {
			// TODO Auto-generated method stub
	        TreeNode root = new TreeNode(4);
	        
	        root.left=new TreeNode(5);
	        root.right=new TreeNode(5);
	        root.left.left=new TreeNode(4);
	        root.left.right=new TreeNode(6);
	        root.right.right=new TreeNode(5);
	        
	       System.out.println( maximumAverageSubtree(root));
		}
	        
	    public static  boolean maximumAverageSubtree(TreeNode root) {
	        if (root == null){
	        	return true;
	        }
	        if (root.left == null || root.right == null){
	           return true;
	        }
	        int[] left = helper(root.left);
	        int[] right = helper(root.right);
	        
	        if (root.value != ((left[0] + right[0])/(left[1] + right[1]))){
	        	return false;
	        	
	        }
	        boolean left1 = maximumAverageSubtree(root.left);
	        boolean right1 = maximumAverageSubtree(root.right);
	        
	        return left1 && right1;
	       
	    }
	    public static int[] helper(TreeNode root){
	        if (root == null){
	            return new int[]{0, 0};
	        }
	        int[] result = new int[2];
	        int[] left = helper(root.left);
	        int[] right = helper(root.right);
	        
	        result[0] = left[0] + right[0] + root.value;
	        result[1] = left[1] + right[1] + 1;
	        return result;
	    }

}

===================================================================================================================
binary tree所有节点都是0或者1，每个节点是两个孩子节点的&值，一个叶子节点的值被flip（0->1 or 1->0) 给你这个节点把其他受影响的节点值更新
===================================================================================================================

import java.util.*;

public class HelloWorld{

		
	 //         1
//	         /   \
//	       1      1
//	     /    \     \
	// 0      1      1
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
        TreeNode root = new TreeNode(1);
        
        root.left=new TreeNode(1);
        root.right=new TreeNode(1);
        root.left.left=new TreeNode(1);
        root.left.right=new TreeNode(1);
        root.right.right=new TreeNode(1);
        root.right.left = new TreeNode(1);
        
        TreeNode node = isSumTree(root, root.right.right);
        root.right.value = root.right.value == 1 ? 0 : 1;
        
        System.out.println(node.value);
        System.out.println(node.left.value);
        System.out.println(node.right.value);
        System.out.println(node.left.left.value);
        System.out.println(node.left.right.value);
        System.out.println(node.right.left.value);
        System.out.println(node.right.right.value);
	}
	public static TreeNode isSumTree(TreeNode root, TreeNode newNode){
		if (root == null){
			return root;
		}
		
		int left = helper(root.left, newNode);
		int right = helper(root.right, newNode);
			
		root.value = left & right;
		
// 		System.out.println(root.value + "---");
// 		root.left = isSumTree(root.left, newNode);
// 	    root.right = isSumTree(root.right, newNode);
	    
	    
		return root;
		
	}
	static boolean visited = false;
	public  static int helper(TreeNode root, TreeNode newNode){
		if (root == null){
			return 1;
		}

		int left = helper(root.left, newNode);
		int right = helper(root.right, newNode);
		
		if (root == newNode && !visited){
		    root.value = newNode.value == 1 ? 0 : 1;
		    visited = true;
		}
		//System.out.println("value is ----" +(left & right & root.value));
		
		return left & right & root.value;
	}
}



=
