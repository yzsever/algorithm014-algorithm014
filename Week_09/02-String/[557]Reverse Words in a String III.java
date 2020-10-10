//Given a string, you need to reverse the order of characters in each word withi
//n a sentence while still preserving whitespace and initial word order. 
//
// Example 1: 
// 
//Input: "Let's take LeetCode contest"
//Output: "s'teL ekat edoCteeL tsetnoc"
// 
// 
//
// Note:
//In the string, each word is separated by single space and there will not be an
//y extra space in the string.
// Related Topics String 
// 👍 1176 👎 94


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() < 2) return s;
        char[] sc = s.toCharArray();
        for (int l = 0, r = 1; r <= sc.length; r++) {
            if (r == sc.length || sc[r] == ' ') {
                reverseWord(sc, l, r - 1);
                l = r + 1;
            }
        }
        return String.valueOf(sc);
    }

    public void reverseWord(char[] s, int l, int r) {
        while (l < r) {
            char temp = s[l];
            s[l++] = s[r];
            s[r--] = temp;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
