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
