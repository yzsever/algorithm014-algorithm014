//Given a 2D board containing 'X' and 'O' (the letter O), capture all regions su
//rrounded by 'X'. 
//
// A region is captured by flipping all 'O's into 'X's in that surrounded region
//. 
//
// Example: 
//
// 
//X X X X
//X O O X
//X X O X
//X O X X
// 
//
// After running your function, the board should be: 
//
// 
//X X X X
//X X X X
//X X X X
//X O X X
// 
//
// Explanation: 
//
// Surrounded regions shouldn’t be on the border, which means that any 'O' on th
//e border of the board are not flipped to 'X'. Any 'O' that is not on the border 
//and it is not connected to an 'O' on the border will be flipped to 'X'. Two cell
//s are connected if they are adjacent cells connected horizontally or vertically.
// 
// Related Topics Depth-first Search Breadth-first Search Union Find 
// 👍 2181 👎 717


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // DFS
    // T:O(9^(n*n)) S:O(1)
    public void solve(char[][] board) {
        int n = board.length;
        if (n < 1) return;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            dfs(board, i, 0);
            dfs(board, i, m - 1);
        }
        for (int j = 1; j < m; j++) {
            dfs(board, 0, j);
            dfs(board, n - 1, j);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'A') board[i][j] = 'O';
                else if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }

    private int[][] routes = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private void dfs(char[][] board, int x, int y) {
        // terminator
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'O') return;
        // process current logic
        board[x][y] = 'A';
        // drill down
        for (int[] route : routes) {
            dfs(board, x + route[0], y + route[1]);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
