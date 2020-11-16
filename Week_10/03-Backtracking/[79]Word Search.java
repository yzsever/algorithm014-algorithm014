//Given a 2D board and a word, find if the word exists in the grid. 
//
// The word can be constructed from letters of sequentially adjacent cells, wher
//e "adjacent" cells are horizontally or vertically neighboring. The same letter c
//ell may not be used more than once. 
//
// 
// Example 1: 
//
// 
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "ABCCED"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "SEE"
//Output: true
// 
//
// Example 3: 
//
// 
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "ABCB"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// board and word consists only of lowercase and uppercase English letters. 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 1 <= word.length <= 10^3 
// 
// Related Topics Array Backtracking 
// 👍 4655 👎 209


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // Backtracking
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0
                || word == null || board.length * board[0].length < word.length()) {
            return false;
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtracking(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private int[][] routes = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public boolean backtracking(char[][] board, int x, int y, int pos, String word) {
        // terminator
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != word.charAt(pos)) {
            return false;
        }
        if (pos == word.length() - 1) {
            return true;
        }
        // process current logic
        char oldc = board[x][y];
        board[x][y] = '.';
        for (int[] route : routes) {
            if (backtracking(board, x + route[0], y + route[1], pos + 1, word)) {
                return true;
            }
        }
        board[x][y] = oldc;
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
