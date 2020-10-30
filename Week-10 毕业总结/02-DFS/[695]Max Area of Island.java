//Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (r
//epresenting land) connected 4-directionally (horizontal or vertical.) You may as
//sume all four edges of the grid are surrounded by water. 
//
// Find the maximum area of an island in the given 2D array. (If there is no isl
//and, the maximum area is 0.) 
//
// Example 1: 
//
// 
//[[0,0,1,0,0,0,0,1,0,0,0,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,1,1,0,1,0,0,0,0,0,0,0,0],
// [0,1,0,0,1,1,0,0,1,0,1,0,0],
// [0,1,0,0,1,1,0,0,1,1,1,0,0],
// [0,0,0,0,0,0,0,0,0,0,1,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,0,0,0,0,0,0,1,1,0,0,0,0]]
// 
//Given the above grid, return 6. Note the answer is not 11, because the island 
//must be connected 4-directionally.
//
// Example 2: 
//
// 
//[[0,0,0,0,0,0,0,0]] 
//Given the above grid, return 0.
//
// Note: The length of each dimension in the given grid does not exceed 50. 
// Related Topics Array Depth-first Search 
// 👍 2322 👎 86


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // DFS
    // T:O(m*n) S:O(m*n)
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        if (m < 1) return 0;
        int n = grid[0].length;
        if (n < 1) return 0;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    ans = Math.max(ans, dfs(grid, i, j));
                }
            }
        }
        return ans;
    }

    private int[][] routes = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private int dfs(int[][] grid, int x, int y) {
        // terminator
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1) return 0;
        // process current logic
        grid[x][y] = 0;
        int ans = 1;
        // drill down
        for (int[] route : routes) {
            ans += dfs(grid, x + route[0], y + route[1]);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
