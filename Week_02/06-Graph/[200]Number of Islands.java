//Given a 2d grid map of '1's (land) and '0's (water), count the number of islan
//ds. An island is surrounded by water and is formed by connecting adjacent lands 
//horizontally or vertically. You may assume all four edges of the grid are all su
//rrounded by water. 
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
// Related Topics Depth-first Search Breadth-first Search Union Find 
// 👍 6054 👎 203


import java.util.LinkedList;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numIslands(char[][] grid) {
//        从1的位置开始搜索，相邻的1全都置为0，岛屿的数量就是搜索的次数
//        1、dfs T:O(MN) S:O(MN)
/*        if(grid == null || grid.length == 0){
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int num = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    dfs(i, j, grid);
                }
            }
        }
        return num;*/

//        2、bfs T:O(MN) S:O(min(M,N))
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int num = 0;
        int[][] routes = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    grid[i][j] = '0';
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] curr = queue.poll();
                        for (int[] route : routes) {
                            int r = route[0] + curr[0];
                            int c = route[1] + curr[1];
                            if (r >= 0 && r < row && c >= 0 && c < col && grid[r][c] == '1') {
                                grid[r][c] = '0';
                                queue.offer(new int[]{r, c});
                            }
                        }
                    }
                }
            }
        }
        return num;
    }

    public void dfs(int row, int col, char[][] grid) {
        if (row < 0 || col < 0
                || row >= grid.length || col >= grid[0].length
                || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        dfs(row, col - 1, grid);
        dfs(row - 1, col, grid);
        dfs(row, col + 1, grid);
        dfs(row + 1, col, grid);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
