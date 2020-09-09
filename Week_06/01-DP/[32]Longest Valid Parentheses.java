//Given a string containing just the characters '(' and ')', find the length of 
//the longest valid (well-formed) parentheses substring. 
//
// Example 1: 
//
// 
//Input: "(()"
//Output: 2
//Explanation: The longest valid parentheses substring is "()"
// 
//
// Example 2: 
//
// 
//Input: ")()())"
//Output: 4
//Explanation: The longest valid parentheses substring is "()()"
// 
// Related Topics String Dynamic Programming 
// 👍 3783 👎 148


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 1 DP T:O(n) S(n)
    // 1 if s[i] == '('  dp[i] = 0
    // if s[i] == ')' and s[i-1] == '(' dp[i] = dp[i-2]+2
    // if s[i] == ')' and s[i-1] == ')' and s[i-dp[i-1]-1] = '(' dp[i] = dp[i-1]+2+dp[i-dp[i-1]-2]
    // 2 state array dp[i]
    public int longestValidParentheses1(String s) {
        if (s == null) {
            return 0;
        }
        int[] dp = new int[s.length()];
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')' && i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                dp[i] = i - dp[i - 1] - 2 >= 0 ? dp[i - 1] + 2 + dp[i - dp[i - 1] - 2] : dp[i - 1] + 2;
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }

    // 2 stack T:O(n) S:O(n)
    public int longestValidParentheses(String s) {
        if (s == null) {
            return 0;
        }
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
