//Write a program to solve a Sudoku puzzle by filling the empty cells. 
//
// A sudoku solution must satisfy all of the following rules: 
//
// 
// Each of the digits 1-9 must occur exactly once in each row. 
// Each of the digits 1-9 must occur exactly once in each column. 
// Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-b
//oxes of the grid. 
// 
//
// Empty cells are indicated by the character '.'. 
//
// 
//A sudoku puzzle... 
//
// 
//...and its solution numbers marked in red. 
//
// Note: 
//
// 
// The given board contain only digits 1-9 and the character '.'. 
// You may assume that the given Sudoku puzzle will have a single unique solutio
//n. 
// The given board size is always 9x9. 
// 
// Related Topics Hash Table Backtracking 
// 👍 2066 👎 93


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // Pruning + Backtracking
    // T:O(9^81) S:O(1)
    boolean[][] row = new boolean[9][9];
    boolean[][] col = new boolean[9][9];
    boolean[][] cube = new boolean[9][9];

    public void solveSudoku(char[][] board) {
        // check
        int n = board.length;
        if (n != 9) return;
        int m = board[0].length;
        if (m != 9) return;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int k = board[i][j] - '1';
                row[i][k] = true;
                col[j][k] = true;
                cube[(i / 3) * 3 + j / 3][k] = true;
            }
        }
        backtracking(board, 0, 0);
    }

    private boolean backtracking(char[][] board, int x, int y) {
        // terminator
        if (y == board[0].length) {
            x = x + 1;
            y = 0;
            if (x == board.length) {
                return true;
            }
        }
        if (board[x][y] != '.') {
            return backtracking(board, x, y + 1);
        }
        int cubeIndex = (x / 3) * 3 + y / 3;
        for (int i = 0; i < 9; i++) {
            if (row[x][i] || col[y][i] || cube[cubeIndex][i]) continue;
            board[x][y] = (char) (i + '1');
            row[x][i] = true;
            col[y][i] = true;
            cube[cubeIndex][i] = true;
            if (backtracking(board, x, y + 1)) {
                return true;
            }
            board[x][y] = '.';
            row[x][i] = false;
            col[y][i] = false;
            cube[cubeIndex][i] = false;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
