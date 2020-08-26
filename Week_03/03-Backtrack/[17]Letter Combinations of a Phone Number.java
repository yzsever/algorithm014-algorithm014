//Given a string containing digits from 2-9 inclusive, return all possible lette
//r combinations that the number could represent. 
//
// A mapping of digit to letters (just like on the telephone buttons) is given b
//elow. Note that 1 does not map to any letters. 
//
// 
//
// Example: 
//
// 
//Input: "23"
//Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// Note: 
//
// Although the above answer is in lexicographical order, your answer could be i
//n any order you want. 
// Related Topics String Backtracking 
// 👍 4219 👎 432


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public Map<Integer, String> keyBoard = new HashMap<>() {
        {
            put(2, "abc");
            put(3, "def");
            put(4, "ghi");
            put(5, "jkl");
            put(6, "mno");
            put(7, "pqrs");
            put(8, "tuv");
            put(9, "wxyz");
        }
    };

//    1、回溯 T:O(3^m*4^n) S:O(m+2)
    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return results;
        }
        backtrack(digits.toCharArray(), 0, new StringBuilder(), results);
        return results;
    }

    public void backtrack(char[] digits, int pos, StringBuilder result, List<String> results) {
        // terminator
        if (result.length() == digits.length || pos == digits.length) {
            results.add(result.toString());
            return;
        }
        String value = keyBoard.get(Character.getNumericValue(digits[pos]));
        for (int i = 0; i < value.length(); i++) {
            // process current logic
            result.append(value.charAt(i));
            // drill down
            backtrack(digits, pos + 1, result, results);
            // restore current status
            result.setLength(result.length() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
