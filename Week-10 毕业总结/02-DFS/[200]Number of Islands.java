//Given an m x n 2d grid map of '1's (land) and '0's (water), return the number 
//of islands. 
//
// An island is surrounded by water and is formed by connecting adjacent lands h
//orizontally or vertically. You may assume all four edges of the grid are all sur
//rounded by water. 
//
// 
// Example 1: 
//
// 
//Input: grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] is '0' or '1'. 
// 
// Related Topics Depth-first Search Breadth-first Search Union Find 
// 👍 6749 👎 218


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // DFS
    // T:O(4^(m*n)) S:O(1)
    public int numIslands(char[][] grid) {
        int n = grid.length;
        if (n < 1) return 0;
        int m = grid[0].length;
        if (m < 1) return 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    dfs(grid, i, j);
                }
            }
        }
        return ans;
    }

    private int[][] routes = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private void dfs(char[][] grid, int x, int y) {
        // terminator
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != '1') {
            return;
        }
        // process current logic
        grid[x][y] = '0';
        // drill down
        for (int[] route : routes) {
            dfs(grid, x + route[0], y + route[1]);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
