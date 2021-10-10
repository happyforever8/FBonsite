Given a matrix and a target, return the number of non-empty submatrices that sum to target.

A submatrix x1, y1, x2, y2 is the set of all cells matrix[x][y] with x1 <= x <= x2 and y1 <= y <= y2.

Two submatrices (x1, y1, x2, y2) and (x1', y1', x2', y2') are different if they have some coordinate that is different: for example, if x1 != x1'.

 

Example 1:


Input: matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
Output: 4
Explanation: The four 1x1 submatrices that only contain 0.
Example 2:

Input: matrix = [[1,-1],[-1,1]], target = 0
Output: 5
Explanation: The two 1x2 submatrices, plus the two 2x1 submatrices, plus the 2x2 submatrix.
  
  class Solution {

    
        //时间复杂度：O(m^2 * n^2)
    //空间复杂度：O(m * n)
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
           int n = matrix.length, m = matrix[0].length;
        int[][] sum = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int p = 1; p <= i; p++) {
                    for (int q = 1; q <= j; q++) {
                        if (sum[i][j] - sum[p - 1][j] - sum[i][q - 1] + sum[p - 1][q - 1] == target) ans++;
                    }
                }
            }
        }
        return ans;

    }
    // 时间复杂度：O(m * n^2)
    // 空间复杂度：O(m * n)
//     public int numSubmatrixSumTarget(int[][] matrix, int target) {
        
//         int n = matrix.length, m = matrix[0].length;
        
//         int[][] sum = new int[n + 1][m + 1];
//         for (int i = 1; i <= n; i++) {
//             for (int j = 1; j <= m; j++) {
//                 sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
//             }
//         }
//         int ans = 0;
//         for (int top = 1; top <= n; top++) {
//             for (int bot = top; bot <= n; bot++) {
//                 int cur = 0;
//                 Map<Integer, Integer> map = new HashMap<>();
//                 for (int r = 1; r <= m; r++) {
//                     cur = sum[bot][r] - sum[top - 1][r];
//                     if (cur == target) ans++;
//                     if (map.containsKey(cur - target)) ans += map.get(cur - target);
//                     map.put(cur, map.getOrDefault(cur, 0) + 1);
//                 }
//             }
//         }
//         return ans;

//     }
    

}

