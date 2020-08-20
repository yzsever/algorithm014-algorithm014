//
//Given n pairs of parentheses, write a function to generate all combinations of
// well-formed parentheses.
// 
//
// 
//For example, given n = 3, a solution set is:
// 
// 
//[
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// Related Topics String Backtracking 
// 👍 5610 👎 281


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
//        1、暴力法：生成2^2n个可能的序列，再依次检验有效性，找出有效的 T：O(2^2n*n) S:O(n)
//        2、回溯法: T:O(4^n/n^0.5) S:O(n)
//        - 当左括号的数量小于n时加左括号
//        - 当右括号的数量小于左括号的时候加右括号
        List<String> result = new ArrayList<>();
        backtracking(result, "", 0, 0, n);
        return result;
    }

    private void backtracking(List<String> result, String str, int open, int close, int n) {
        if (str.length() == 2 * n) {
            result.add(str);
            return;
        }
        if (open < n) {
            backtracking(result, str+"(", open + 1, close, n);
        }
        if (close < open) {
            backtracking(result, str+")", open, close + 1, n);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
