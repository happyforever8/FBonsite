Given a 2D array of characters grid of size m x n, you need to find if there exists any cycle consisting of the same value in grid.

A cycle is a path of length 4 or more in the grid that starts and ends at the same cell. From a given cell, you can move to one of the cells adjacent to it - in one of the four directions (up, down, left, or right), if it has the same value of the current cell.

Also, you cannot move to the cell that you visited in your last move. For example, the cycle (1, 1) -> (1, 2) -> (1, 1) is invalid because from (1, 2) we visited (1, 1) which was the last visited cell.

Return true if any cycle of the same value exists in grid, otherwise, return false.

 

Example 1:



Input: grid = [["a","a","a","a"],
               ["a","b","b","a"],
               ["a","b","b","a"],
               ["a","a","a","a"]]
Output: true
Explanation: There are two valid cycles shown in different colors in the image below:


class Solution {
    
    
    
    // The idea of using backtracking and setting the nodes to # and then 
    //     resetting it back to the real value is\ 
    //     It removes lot of unnecessary code to be written to handle the edge cases related to visited nodes
// time is O(mn), space is O(mn)

   public boolean containsCycle(char[][] grid) {
        boolean[][] seen = new boolean[grid.length][grid[0].length];
            
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!seen[i][j] && search(grid, grid[i][j], i, j, seen)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean search(char[][] grid, char target, int i, int j, boolean[][] seen) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != target) {
            return false;
        }
        
        if (seen[i][j]) {
            return true;
        }
        
        seen[i][j] = true;
        grid[i][j] = '#';
        
        boolean found =  search(grid, target, i + 1, j, seen)
                    ||  search(grid, target, i - 1, j, seen)
                    ||  search(grid, target, i, j - 1, seen)
                    ||  search(grid, target, i, j + 1, seen);

        grid[i][j] = target;
        
        return found;
    }
}
