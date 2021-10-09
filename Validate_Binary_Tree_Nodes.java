You have n binary tree nodes numbered from 0 to n - 1 where node i has two children leftChild[i] and rightChild[i], return true if and only if all the given nodes form exactly one valid binary tree.

If node i has no left child then leftChild[i] will equal -1, similarly for the right child.

Note that the nodes have no values and that we only use the node numbers in this problem.

class Solution {
    
    // step1 find the root
    // step2 using BFS, if two nodes visteid twice, return false
    // time is O(n)
    // space is O(n)
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int root = 0;
        
        Set<Integer> visited = new HashSet<>();
        
        for (int i = 0; i < leftChild.length; i++){
            if (leftChild[i] != -1){
                visited.add(leftChild[i]);
            }
        }
        
         for (int i = 0; i < rightChild.length; i++){
            if (rightChild[i] != -1){
                visited.add(rightChild[i]);
            }
        }
        
        for (int i = 0; i < n; i++){
            if (!visited.contains(i)){
                root = i;
                break;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        visited.clear();
        
        queue.offer(root);
        
        while (!queue.isEmpty()){
            int node = queue.poll();
            
            if (leftChild[node] != -1){
                if (visited.contains(leftChild[node])){
                    return false;
                }
                visited.add(leftChild[node]);
                queue.offer(leftChild[node]);
            }
            
             if (rightChild[node] != -1){
                if (visited.contains(rightChild[node])){
                    return false;
                }
                visited.add(rightChild[node]);
                queue.offer(rightChild[node]);
            }
        }
        // after the bfs, the visited size should be n - 1
        return visited.size() == n - 1;
    }
}
