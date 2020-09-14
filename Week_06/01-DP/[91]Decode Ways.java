//A message containing letters from A-Z is being encoded to numbers using the fo
//llowing mapping: 
//
// 
//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// Given a non-empty string containing only digits, determine the total number o
//f ways to decode it. 
//
// Example 1: 
//
// 
//Input: "12"
//Output: 2
//Explanation: It could be decoded as "AB" (1 2) or "L" (12).
// 
//
// Example 2: 
//
// 
//Input: "226"
//Output: 3
//Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6)
//. 
// Related Topics String Dynamic Programming 
// 👍 3025 👎 3066


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // DP T：O（n） S：O（n）
    // 1、subproblem，当si！=0时，解有dp[i-1]种, 当si-1si在1-26之间时，解有dp[i-2]种
    // 2、state array dp[n+1]
    // 3、DP方程
    // if si != 0 dp[i] = dp[i-1]
    // if si-1si in 1-26 dp[i] +=dp[i-2]
    public int numDecodings2(String s) {
        if(s == null || s.length() == 0 || s.charAt(0) == '0'){
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));
            if(first != 0){
                dp[i] = dp[i-1];
            }
            if(second >= 10 && second <= 26){
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length];
        dp[0] = chars[0] == '0' ? 0 : 1;
        for (int i = 1; i < chars.length; i++) {
            char current = chars[i];
            char prev = chars[i - 1];
            if (current >= '1' && current <= '9') {
                dp[i] = dp[i - 1];
            }
            if ((prev == '1' && current >= '0' && current <= '9') ||
                    (prev == '2' && current >= '0' && current <= '6')) {
                dp[i] += i >= 2 ? dp[i - 2] : 1;
            }
        }
        return dp[chars.length - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
