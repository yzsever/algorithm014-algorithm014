//Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be val
//idated according to the following rules: 
//
// 
// Each row must contain the digits 1-9 without repetition. 
// Each column must contain the digits 1-9 without repetition. 
// Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without r
//epetition. 
// 
//
// 
//A partially filled sudoku which is valid. 
//
// The Sudoku board could be partially filled, where empty cells are filled with
// the character '.'. 
//
// Example 1: 
//
// 
//Input:
//[
//  ["5","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]
//]
//Output: true
// 
//
// Example 2: 
//
// 
//Input:
//[
//  ["8","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]
//]
//Output: false
//Explanation: Same as Example 1, except with the 5 in the top left corner being
// 
//    modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is 
//invalid.
// 
//
// Note: 
//
// 
// A Sudoku board (partially filled) could be valid but is not necessarily solva
//ble. 
// Only the filled cells need to be validated according to the mentioned rules. 
//
// The given board contain only digits 1-9 and the character '.'. 
// The given board size is always 9x9. 
// 
// Related Topics Hash Table 
// 👍 1899 👎 479


import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // REF:https://leetcode.com/problems/valid-sudoku/discuss/15472/Short%2BSimple-Java-using-Strings
    // Collect the set of things we see, encoded as strings. For example:
    //'4' in row 7 is encoded as "(4)7".
    //'4' in column 7 is encoded as "7(4)".
    //'4' in the top-right block is encoded as "0(4)2".
    //Scream false if we ever fail to add something because it was already added (i.e., seen before).
    // Pruning T:O(1) S:O(1)
    public boolean isValidSudoku1(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    String b = "(" + board[i][j] + ")";
                    if (!seen.add(i + b) || !seen.add(b + j) || !seen.add(i / 3 + b + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // 行中没有重复的数字。
    // 列中没有重复的数字。
    // 3 x 3 子数独内没有重复的数字。 可以使用 box_index = (row / 3) * 3 + columns / 3
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] col = new int[9][9];
        int[][] sbox = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '1';
                int index_box = (i / 3) * 3 + j / 3;
                if (rows[i][num] == 1) {
                    return false;
                } else {
                    rows[i][num] = 1;
                }
                if (col[j][num] == 1) {
                    return false;
                } else {
                    col[j][num] = 1;
                }
                if (sbox[index_box][num] == 1) {
                    return false;
                } else {
                    sbox[index_box][num] = 1;
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
