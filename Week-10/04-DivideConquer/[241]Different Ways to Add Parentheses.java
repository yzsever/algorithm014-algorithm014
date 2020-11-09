//Given a string of numbers and operators, return all possible results from comp
//uting all the different possible ways to group numbers and operators. The valid 
//operators are +, - and *. 
//
// Example 1: 
//
// 
//Input: "2-1-1"
//Output: [0, 2]
//Explanation: 
//((2-1)-1) = 0 
//(2-(1-1)) = 2 
//
// Example 2: 
//
// 
//Input: "2*3-4*5"
//Output: [-34, -14, -10, -10, 10]
//Explanation: 
//(2*(3-(4*5))) = -34 
//((2*3)-(4*5)) = -14 
//((2*(3-4))*5) = -10 
//(2*((3-4)*5)) = -10 
//(((2*3)-4)*5) = 10
// Related Topics Divide and Conquer 
// 👍 1865 👎 99


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // Divide&Conquer
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ans = new ArrayList<>();
        // terminator
        if (input == null) return ans;
        // process current logic
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) continue;
            // Divide
            String left = input.substring(0, i);
            String right = input.substring(i + 1, input.length());
            List<Integer> lAns = diffWaysToCompute(left);
            List<Integer> rAns = diffWaysToCompute(right);
            // Conquer
            for (Integer l : lAns) {
                for (Integer r : rAns) {
                    int res = 0;
                    switch (input.charAt(i)) {
                        case '+':
                            res = l + r;
                            break;
                        case '-':
                            res = l - r;
                            break;
                        case '*':
                            res = l * r;
                    }
                    ans.add(res);
                }
            }
        }
        if (ans.size() == 0) {
            ans.add(Integer.valueOf(input));
            return ans;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
