Given an m x n integer matrix grid, return the maximum score of a 
path starting at (0, 0) and ending at (m - 1, n - 1) moving in the 4 cardinal directions.

The score of a path is the minimum value in that path.

For example, the score of the path 8 → 4 → 5 → 9 is 4.
 

Example 1:


Input: grid = [[5,4,5],
               [1,2,6],
               [7,4,6]]
               max path is 5 4 5 6 6, score is 4
Output: 4
Explanation: The path with the maximum score is highlighted in yellow. 
  
  class Solution {
    public int maximumMinimumPath(int[][] A) {
        if (A == null || A.length == 0){
            return 0;
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        
        pq.offer(new int[]{0, 0, A[0][0]});
        
        int m = A.length;
        int n = A[0].length;
        int result = 0;
        boolean[][] visited = new boolean[m][n];
        
        int[] dirX = {0, 0 ,1, -1};
        int[] dirY = {1, -1, 0, 0};
        
        while (!pq.isEmpty()){
            int size = pq.size();
            
            //for (int i = 0; i < size; i++){
                int[] curr = pq.poll();
                
                if (curr[0] == A.length - 1 && curr[1] == A[0].length - 1){
                    return curr[2];
                }
                visited[curr[0]][curr[1]] = true;
                for (int j = 0; j < 4; j++){
                    int nx = curr[0] + dirX[j];
                    int ny = curr[1] + dirY[j];
                    
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]){
                        int min = Math.min(curr[2], A[nx][ny]);
                        pq.offer(new int[]{nx, ny, min});
                    }
                }
                
           // }
        }
        return -1;
    }
}
