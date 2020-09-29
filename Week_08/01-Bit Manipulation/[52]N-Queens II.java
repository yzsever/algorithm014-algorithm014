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
// 👍 603 👎 165


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // Bit Manipulation
    private int count;

    public int totalNQueens(int n) {
        if (n < 1) return 0;
        count = 0;
        dfs(n, 0, 0, 0, 0);
        return count;
    }

    private void dfs(int n, int row, int cols, int pie, int na) {
        // terminator
        if (row == n) {
            count++;
            return;
        }
        // 得到当前所有空位
        int bits = (~(cols | pie | na)) & ((1 << n) - 1);
        while (bits != 0) {
            // 取到最低位的1
            int p = bits & -bits;
            bits = bits & (bits - 1);
            dfs(n, row + 1, cols | p, (pie | p) << 1, (na | p) >> 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
