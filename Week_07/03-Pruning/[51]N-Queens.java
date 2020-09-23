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
// 👍 2182 👎 80


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        if(n == 0) return results;
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(board[i], '.');
        }
        backtracking(board, 0, n, results);
        return results;
    }

    private void backtracking(char[][] board, int row, int n, List<List<String>> results) {
        // terminator
        if (row >= n) {
            results.add(buildStr(board));
            return;
        }
        // process current logic
        for (int i = 0; i < n; i++) {
            if (!isVaild(board, row, i)) continue;
            board[row][i] = 'Q';
            // drill down
            backtracking(board, row + 1, n, results);
            // restore current state
            board[row][i] = '.';
        }
        return;
    }

    private boolean isVaild(char[][] board, int x, int y) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'Q' && (j == y || x + y == i + j || x + j == i + y)) {
                    return false;
                }
            }
        }
        return true;
    }

    private List<String> buildStr(char[][] board) {
        List<String> str = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (char c : board[i]) sb.append(c);
            str.add(sb.toString());
        }
        return str;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
