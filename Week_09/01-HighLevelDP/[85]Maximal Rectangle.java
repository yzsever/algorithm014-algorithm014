//Given a rows x cols binary matrix filled with 0's and 1's, find the largest re
//ctangle containing only 1's and return its area. 
//
// 
// Example 1: 
//
// 
//Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1",
//"1"],["1","0","0","1","0"]]
//Output: 6
//Explanation: The maximal rectangle is shown in the above picture.
// 
//
// Example 2: 
//
// 
//Input: matrix = []
//Output: 0
// 
//
// Example 3: 
//
// 
//Input: matrix = [["0"]]
//Output: 0
// 
//
// Example 4: 
//
// 
//Input: matrix = [["1"]]
//Output: 1
// 
//
// Example 5: 
//
// 
//Input: matrix = [["0","0"]]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// rows == matrix.length 
// cols == matrix.length 
// 0 <= row, cols <= 200 
// matrix[i][j] is '0' or '1'. 
// 
// Related Topics Array Hash Table Dynamic Programming Stack 
// 👍 3300 👎 74


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // DP T:O(mn) S:O(n)
    // subproblem 计算每个点的最大高度、左边界和右边界，即可计算
    // state array:left[i][j], height[i][j], right[i][j]
    // DP方程：
    // left[i][j] = Math.max(left[i-1][j], curLeft);
    // if(matrix[i][j] == '1') height[i][j] = height[i-1][j] + 1 else height[i][j] = 0;
    // right[i][j] = Math.min(right[i-1][j], curRight);
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        if (n == 0) return 0;

        int[] left = new int[n];
        int[] height = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);
        int ans = 0;
        for (int i = 0; i < m; i++) {
            int curLeft = 0, curRight = n;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                    left[j] = Math.max(left[j], curLeft);
                } else {
                    height[j] = 0;
                    left[j] = 0;
                    curLeft = j + 1;
                }
            }
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], curRight);
                } else {
                    right[j] = n;
                    curRight = j;
                }
            }
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, height[j] * (right[j] - left[j]));
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
