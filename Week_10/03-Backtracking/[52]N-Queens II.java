//The n-queens puzzle is the problem of placing n queens on an n×n chessboard su
//ch that no two queens attack each other. 
//
// 
//
// Given an integer n, return the number of distinct solutions to the n-queens p
//uzzle. 
//
// Example: 
//
// 
//Input: 4
//Output: 2
//Explanation: There are two distinct solutions to the 4-queens puzzle as shown 
//below.
//[
// [".Q..",  // Solution 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // Solution 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
// 
// Related Topics Backtracking 
// 👍 641 👎 167


import io.netty.handler.codec.memcache.AbstractMemcacheObjectAggregator;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // Backtracking
    int ans = 0;

    public int totalNQueens(int n) {
        if (n < 1) return 0;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        backtracking(board, 0);
        return ans;
    }

    private void backtracking(char[][] board, int x) {
        // terminator
        if (x >= board.length) {
            ans++;
            return;
        }
        // process current logic
        for (int j = 0; j < board[x].length; j++) {
            if (!isValid(board, x, j)) continue;
            board[x][j] = 'Q';
            // drill down
            backtracking(board, x + 1);
            // restore current state
            board[x][j] = '.';
        }
    }

    private boolean isValid(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[x].length) {
            return false;
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'Q' && (j == y || x + y == i + j || x + j == i + y)) {
                    return false;
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
