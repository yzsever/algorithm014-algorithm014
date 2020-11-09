//Write a program to solve a Sudoku puzzle by filling the empty cells. 
//
// A sudoku solution must satisfy all of the following rules: 
//
// 
// Each of the digits 1-9 must occur exactly once in each row. 
// Each of the digits 1-9 must occur exactly once in each column. 
// Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes
// of the grid. 
// 
//
// The '.' character indicates empty cells. 
//
// 
// Example 1: 
//
// 
//Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5"
//,".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".","."
//,".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".","."
//,"6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"
//],[".",".",".",".","8",".",".","7","9"]]
//Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4
//","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3
//"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],[
//"9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3",
//"4","5","2","8","6","1","7","9"]]
//Explanation: The input board is shown above and the only valid solution is sho
//wn below:
//
//
// 
//
// 
// Constraints: 
//
// 
// board.length == 9 
// board[i].length == 9 
// board[i][j] is a digit or '.'. 
// It is guaranteed that the input board has only one solution. 
// 
// Related Topics Hash Table Backtracking 
// 👍 2208 👎 93


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // backtracking
    boolean[][] row = new boolean[9][9];
    boolean[][] col = new boolean[9][9];
    boolean[][] cube = new boolean[9][9];

    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return;
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int n = board[i][j] - '1';
                    row[i][n] = true;
                    col[j][n] = true;
                    cube[3 * (i / 3) + j / 3][n] = true;
                }
            }
        }
        backtracking(board, 0, 0);
    }

    private boolean backtracking(char[][] board, int x, int y) {
        // terminator
        if (y == 9) {
            y = 0;
            if (++x == 9) {
                return true;
            }
        }
        if (board[x][y] != '.') return backtracking(board, x, y + 1);
        // process current logic
        for (int i = 0; i < 9; i++) {
            int cubePos = 3 * (x / 3) + y / 3;
            if (row[x][i] || col[y][i] || cube[cubePos][i]) continue;
            board[x][y] = (char) (i + '1');
            row[x][i] = true;
            col[y][i] = true;
            cube[cubePos][i] = true;
            // drill down
            if (backtracking(board, x, y + 1)) {
                return true;
            }
            // restore current state
            board[x][y] = '.';
            row[x][i] = false;
            col[y][i] = false;
            cube[cubePos][i] = false;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
