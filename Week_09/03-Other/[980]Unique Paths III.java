//On a 2-dimensional grid, there are 4 types of squares: 
//
// 
// 1 represents the starting square. There is exactly one starting square. 
// 2 represents the ending square. There is exactly one ending square. 
// 0 represents empty squares we can walk over. 
// -1 represents obstacles that we cannot walk over. 
// 
//
// Return the number of 4-directional walks from the starting square to the endi
//ng square, that walk over every non-obstacle square exactly once. 
//
// 
//
// 
// Example 1: 
//
// 
//Input: [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
//Output: 2
//Explanation: We have the following two paths: 
//1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
//2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2) 
//
// 
// Example 2: 
//
// 
//Input: [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
//Output: 4
//Explanation: We have the following four paths: 
//1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
//2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
//3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
//4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3) 
//
// 
// Example 3: 
//
// 
//Input: [[0,1],[2,0]]
//Output: 0
//Explanation: 
//There is no path that walks over every empty square exactly once.
//Note that the starting and ending square can be anywhere in the grid.
// 
// 
// 
// 
//
// 
//
// Note: 
//
// 
// 1 <= grid.length * grid[0].length <= 20 
// Related Topics Backtracking Depth-first Search 
// 👍 1063 👎 83


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // DFS
    // T:O(4^(m*n)) S:O(1)
    private int[][] routes = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private int sx, sy, empty = 1, ans = 0;

    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        if (n == 0) return 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) empty++;
                else if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                }
            }
        }
        dfs(grid, sx, sy);
        return ans;
    }

    private void dfs(int[][] grid, int x, int y) {
        // terminator
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] < 0) {
            return;
        }
        if (grid[x][y] == 2) {
            if (empty == 0) ans++;
            return;
        }
        //process current logic
        grid[x][y] = -2;
        empty--;
        for (int[] route : routes) {
            // drill down
            dfs(grid, x + route[0], y + route[1]);
        }
        // restore current state
        grid[x][y] = 0;
        empty++;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
