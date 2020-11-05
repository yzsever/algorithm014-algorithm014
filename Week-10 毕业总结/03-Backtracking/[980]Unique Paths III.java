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
// 👍 1107 👎 83


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // Backtracking
    private int ans = 0;

    public int uniquePathsIII(int[][] grid) {
        if (grid == null || grid.length < 1) return ans;
        int m = grid.length;
        int n = grid[0].length;
        int sx = 0;
        int sy = 0;
        int total = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    total++;
                } else if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                }
            }
        }
        backtracking(grid, sx, sy, 0, total);
        return ans;
    }

    private int[][] routes = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private void backtracking(int[][] grid, int x, int y, int count, int total) {
        // terminator
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] < 0) {
            return;
        }
        if (grid[x][y] == 2) {
            if (count == total + 1) ans++;
            return;
        }

        // process current logic
        grid[x][y] = -2;
        for (int[] route : routes) {
            // drill down
            backtracking(grid, x + route[0], y + route[1], count + 1, total);
        }
        // restore current logic
        grid[x][y] = 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
