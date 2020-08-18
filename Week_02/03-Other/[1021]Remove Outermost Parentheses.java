//A valid parentheses string is either empty (""), "(" + A + ")", or A + B, wher
//e A and B are valid parentheses strings, and + represents string concatenation. 
//For example, "", "()", "(())()", and "(()(()))" are all valid parentheses string
//s. 
//
// A valid parentheses string S is primitive if it is nonempty, and there does n
//ot exist a way to split it into S = A+B, with A and B nonempty valid parentheses
// strings. 
//
// Given a valid parentheses string S, consider its primitive decomposition: S =
// P_1 + P_2 + ... + P_k, where P_i are primitive valid parentheses strings. 
//
// Return S after removing the outermost parentheses of every primitive string i
//n the primitive decomposition of S. 
//
// 
//
// Example 1: 
//
// 
//Input: "(()())(())"
//Output: "()()()"
//Explanation: 
//The input string is "(()())(())", with primitive decomposition "(()())" + "(()
//)".
//After removing outer parentheses of each part, this is "()()" + "()" = "()()()
//".
// 
//
// 
// Example 2: 
//
// 
//Input: "(()())(())(()(()))"
//Output: "()()()()(())"
//Explanation: 
//The input string is "(()())(())(()(()))", with primitive decomposition "(()())
//" + "(())" + "(()(()))".
//After removing outer parentheses of each part, this is "()()" + "()" + "()(())
//" = "()()()()(())".
// 
//
// 
// Example 3: 
//
// 
//Input: "()()"
//Output: ""
//Explanation: 
//The input string is "()()", with primitive decomposition "()" + "()".
//After removing outer parentheses of each part, this is "" + "" = "".
// 
//
// 
// 
// 
//
// Note: 
//
// 
// S.length <= 10000 
// S[i] is "(" or ")" 
// S is a valid parentheses string 
// 
//
// 
// 
// 
// 
// Related Topics Stack 
// 👍 519 👎 646


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeOuterParentheses(String S) {
        // 计数法，遇到左括号+1，遇到右括号-1。所有在+1和-1之前，大于0的左括号的位置和大于1的右括号位置为有效数据。
        StringBuilder sb = new StringBuilder();
        int open = 0;
        for(char c : S.toCharArray()){
            if(c == '(' && open++ > 0){
                sb.append(c);
            }
            if(c == ')' && open-- > 1){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
