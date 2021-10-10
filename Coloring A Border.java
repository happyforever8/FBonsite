You are given an m x n integer matrix grid, and three integers row, col, and color. 
  Each value in the grid represents the color of the grid square at that location.

Two squares belong to the same connected component if they have the same color and are next to each other in any of the 4 directions.

The border of a connected component is all the squares in the connected component 
that are either 4-directionally adjacent to a square not in the component, or on the boundary of the grid (the first or last row or column).

You should color the border of the connected component that contains the square grid[row][col] with color.

Return the final grid.

 

Example 1:

Input: grid = [[1,1],[1,2]], row = 0, col = 0, color = 3
Output: [[3,3],[3,2]]



class Solution {
//     首先这道题是指找出给定位置（r0,c0）的连通分量，
//     并将边界赋为给定color。因此解题思路主要为判断给定位置四个边界，
//     并递归向外进行扩展判断，如果四个边不全，则进行上色。
    
    
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
         int m = grid.length, n = grid[0].length, i, j, k, x, y;
        int[][] dir = {{1,0},{0,1},{0,-1},{-1,0}};
        int origin = grid[r0][c0];
        boolean[][] vis = new boolean[m][n];
        Deque<int[]> q = new LinkedList<>();
        q.addLast(new int[]{r0, c0});
        vis[r0][c0] = true;
        while(!q.isEmpty())
        {
            int[] temp = q.pollLast();
            i = temp[0];
            j = temp[1];
            for(k = 0; k < 4; ++k)
            {
                x = i + dir[k][0];
                y = j + dir[k][1];
                if(x >=0 && x<m && y>=0 && y<n)//在界内
                {
                    if(vis[x][y]) continue;//访问过了，下一个
                    if(grid[x][y] != origin)//没有访问，颜色不同
                        grid[i][j] = color;// i, j 旁边的 x, y跟它不一样，边界
                    else//没有访问，颜色一样，正常入队
                    {
                        q.addLast(new int[]{x,y});
                        vis[x][y] = true;
                    }
                }
                else//出界了
                    grid[i][j] = color;//i,j 是边界
            }
        }
        return grid;
    }
}
