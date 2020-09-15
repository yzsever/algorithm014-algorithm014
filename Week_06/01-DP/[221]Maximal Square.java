//Given a 2D binary matrix filled with 0's and 1's, find the largest square cont
//aining only 1's and return its area. 
//
// Example: 
//
// 
//Input: 
//
//1 0 1 0 0
//1 0 1 1 1
//1 1 1 1 1
//1 0 0 1 0
//
//Output: 4
// Related Topics Dynamic Programming 
// 👍 3415 👎 88


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // DP T:O(mn) S:O(mn)
    // 拆分子问题：b[i][j]为1时，此处结束的最大正方形的边长为以它为右下角点的小的正方形的其他三个点结束的最大正方形边长最小值+1 Math.min(b[i-1,j], Math.min(b[i-1,j-1], b[i][j-1]))+1
    // state arrays : b[i][j]表示位置（i，j）处结束的最大正方形的边长
    //  DP方程dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1])) + 1
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int side = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1]))+1;
                    side = Math.max(side, dp[i][j]);
                }
            }
        }
        return side * side;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
