//On a 2x3 board, there are 5 tiles represented by the integers 1 through 5, and
// an empty square represented by 0. 
//
// A move consists of choosing 0 and a 4-directionally adjacent number and swapp
//ing it. 
//
// The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]
//]. 
//
// Given a puzzle board, return the least number of moves required so that the s
//tate of the board is solved. If it is impossible for the state of the board to b
//e solved, return -1. 
//
// Examples: 
//
// 
//Input: board = [[1,2,3],[4,0,5]]
//Output: 1
//Explanation: Swap the 0 and the 5 in one move.
// 
//
// 
//Input: board = [[1,2,3],[5,4,0]]
//Output: -1
//Explanation: No number of moves will make the board solved.
// 
//
// 
//Input: board = [[4,1,2],[5,0,3]]
//Output: 5
//Explanation: 5 is the smallest number of moves that solves the board.
//An example path:
//After move 0: [[4,1,2],[5,0,3]]
//After move 1: [[4,1,2],[0,5,3]]
//After move 2: [[0,1,2],[4,5,3]]
//After move 3: [[1,0,2],[4,5,3]]
//After move 4: [[1,2,0],[4,5,3]]
//After move 5: [[1,2,3],[4,5,0]]
// 
//
// 
//Input: board = [[3,2,4],[1,5,0]]
//Output: 14
// 
//
// Note: 
//
// 
// board will be a 2 x 3 array as described above. 
// board[i][j] will be a permutation of [0, 1, 2, 3, 4, 5]. 
// 
// Related Topics Breadth-first Search 
// 👍 770 👎 25


import com.magima.bean.ErrorMessage;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // BFS
    public int slidingPuzzle(int[][] board) {
        int m = board.length;
        if (m == 0) return 0;
        int n = board[0].length;
        if (n == 0) return 0;
        int[][] routes = new int[][]{{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        int len = m * n + 1;
        int[] newb = new int[len];
        int pos = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                newb[i * n + j] = board[i][j];
                if (board[i][j] == 0) pos = i * n + j;
            }
        }
        newb[len - 1] = pos;
        String end = "123450";
        String start = buildString(newb, 0, len - 1);
        if (end.equals(start)) return 0;
        Set<String> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(newb);
        visited.add(start);
        int ans = 0;
        while (!queue.isEmpty()) {
            ans++;
            int size = queue.size();
            while (size-- > 0) {
                int[] curr = queue.poll();
                int index = curr[len - 1];
                for (int route : routes[index]) {
                    int[] next = Arrays.copyOf(curr, len);
                    swap(next, index, route);
                    next[len - 1] = route;
                    String nextStr = buildString(next, 0, len - 1);
                    if (end.equals(nextStr)) return ans;
                    if (visited.add(nextStr)) queue.add(next);
                }
            }
        }
        return -1;
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private String buildString(int[] arr, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
