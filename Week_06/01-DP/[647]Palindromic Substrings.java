//Given a string, your task is to count how many palindromic substrings in this 
//string. 
//
// The substrings with different start indexes or end indexes are counted as dif
//ferent substrings even they consist of same characters. 
//
// Example 1: 
//
// 
//Input: "abc"
//Output: 3
//Explanation: Three palindromic strings: "a", "b", "c".
// 
//
// 
//
// Example 2: 
//
// 
//Input: "aaa"
//Output: 6
//Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
// 
//
// 
//
// Note: 
//
// 
// The input string length won't exceed 1000. 
// 
//
// Related Topics String Dynamic Programming 
// 👍 2985 👎 123


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //DP T：O（n^2）S:O(n^2)
    //1、拆分子问题，判断一个数是不是回文串，首尾字母相同s[i] == s[j], 情况1：字符串长度小于等于3 情况2：子串s[i+1,j-1]是回文串
    //2、状态数组：dp[n][n]
    //3、DP方程：dp[i][j] =  s.charAt(i) == s.charAt(j) && (j-i<3 || dp[i+1][j-1])
    //因为状态方程i依赖i+1，j依赖j-1,所以i逆序循环，j升序循环
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int ans = 0;
        for (int i = n-1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                if (dp[i][j]) ans++;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
