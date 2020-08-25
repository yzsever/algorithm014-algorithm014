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
// 👍 2067 👎 77


import com.magima.bean.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> solveNQueens(int n) {
        // 1、回溯 T:O(n!) S:O(n)
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++){
            for (int j= 0; j<n; j++){
                board[i][j] = '.';
            }
        }
        backtrack(board, 0, result);
        return result;
    }

    private void backtrack(char[][] board, int rowIndex, List<List<String>> result){
        // terminator
        if(rowIndex == board.length){
            result.add(buildBoardString(board));
            return;
        }
        for(int i=0; i< board[rowIndex].length; i++) {
            if(isQueen(board, rowIndex, i)){
                // process current logic
                board[rowIndex][i] = 'Q';
                // drill down
                backtrack(board, rowIndex+1, result);
                // restore current status
                board[rowIndex][i] = '.';
            }
        }
    }

    private List<String> buildBoardString(char[][] board){
        List<String> boardString = new ArrayList<>();
        for(int i=0; i< board.length; i++){
            boardString.add(new String(board[i]));
        }
        return boardString;
    }

    private boolean isQueen(char[][] board, int x, int y) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < board[x].length; j++) {
                if (board[i][j] == 'Q' && (y == j || i + j == x + y || i + y == x + j)) {
                    return false;
                }
            }
        }
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
