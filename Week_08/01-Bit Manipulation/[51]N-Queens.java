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
// 👍 2212 👎 80


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // Backtracking + Bit Manipulation
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        if (n < 1) return results;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        backtracking(board, n, 0, 0, 0, 0, results);
        return results;
    }

    private void backtracking(char[][] board, int n, int row, int cols, int pie, int na, List<List<String>> results) {
        if (row >= n) {
            results.add(buildStr(board));
            return;
        }
        int bits = ~(cols | pie | na) & ((1 << n) - 1);
        while (bits != 0) {
            int p = bits & -bits;
            bits = bits & (bits - 1);
            int col = getIndex(p);
            board[row][col] = 'Q';
            backtracking(board, n, row + 1, cols | p, (pie | p) << 1, (na | p) >> 1, results);
            board[row][col] = '.';
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

    private int getIndex(int n) {
        int count = 0;
        while (n != 1) {
            n >>= 1;
            count++;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
