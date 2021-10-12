public class HelloWorld{

     public static void main(String []args){
      
    int[][] arr = new int[][] {
            {1,0,0,1,1,1},
            {1,0,0,1,1,1},
            {0,0,0,0,1,1},
            {0,0,0,0,1,1}
    };

 int[][] arr1 = new int[][] {
 {1, 0, 1, 1, 1},
 {1, 0, 1, 1, 1},
 {0, 1, 0, 1, 1}};
    System.out.println("Largest perimeter: " + perimeter(arr1));
}

private static  int totalCount;
private static  int innerCount;
private static boolean[][] visited;

public static int perimeter(int[][] arr) {
    int maxPerimeter = 0;
    int numIslands = 0;
    visited = new boolean[arr.length][arr[0].length];

    for (int r = 0; r < arr.length; r++) {
        for (int c = 0; c < arr[0].length; c++) {
            if (arr[r][c] == 1 && !visited[r][c]) {
                numIslands++;
                dfs(arr, r, c);
               // Perimeter of this island will be (totalCount - innerCount) and we maintain the max. 
                maxPerimeter = Math.max(maxPerimeter, (totalCount - innerCount));
            }
            totalCount = 0;
            innerCount = 0;
        }
    }

    System.out.println("Number of islands: " + numIslands);
    return maxPerimeter;
}

private static void dfs(int[][] arr, int r, int c) {
    if (r < 0 || c < 0
            || r >= arr.length || c >= arr[0].length
            || arr[r][c] == 0 || visited[r][c]) return;

/*
    If the land is surrounded on all sides by land, then we count the number of such lands.
*/
    if ((r > 0 && arr[r-1][c] == 1)
            && (c > 0 && arr[r][c-1] == 1)
            && (r < arr.length - 1 && arr[r+1][c] == 1)
            && (c < arr[0].length - 1 && arr[r][c+1] == 1)) {
        innerCount += 1;
    }

// Total number of lands in this island
    totalCount += 1;

    visited[r][c] = true;

    dfs(arr, r+1, c);
    dfs(arr, r, c+1);
    dfs(arr, r-1, c);
    dfs(arr, r, c-1);
}
}
