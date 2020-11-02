//The n-queens puzzle is the problem of placing n queens on an n×n chessboard su
//ch that no two queens attack each other. 
//
// 
//
// Given an integer n, return all distinct solutions to the n-queens puzzle. 
//
// Each solution contains a distinct board configuration of the n-queens' placem
//ent, where 'Q' and '.' both indicate a queen and an empty space respectively. 
//
// Example: 
//
// 
//Input: 4
//Output: [
// [".Q..",  // Solution 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // Solution 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//Explanation: There exist two distinct solutions to the 4-queens puzzle as show
//n above.
// 
// Related Topics Backtracking 
// 👍 2311 👎 87


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // Backtracking
    public List<List<String>> solveNQueens(int n) {
        if (n < 1) return new ArrayList<>();
        List<List<String>> results = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        backtracking(board, 0, results);
        return results;
    }

    private void backtracking(char[][] board, int x, List<List<String>> results) {
        // terminator
        if (x >= board.length) {
            results.add(buildStr(board));
            return;
        }
        // process current logic
        for (int i = 0; i < board[0].length; i++) {
            if (!isValid(board, x, i)) {
                continue;
            }
            board[x][i] = 'Q';
            // drill down
            backtracking(board, x + 1, results);
            // restore current state
            board[x][i] = '.';
        }
    }

    private List<String> buildStr(char[][] board) {
        List<String> str = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < board[0].length; j++) {
                sb.append(board[i][j]);
            }
            str.add(sb.toString());
        }
        return str;
    }

    private boolean isValid(char[][] board, int x, int y) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'Q' && (j == y || x + y == i + j || x + j == i + y)) {
                    return false;
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
