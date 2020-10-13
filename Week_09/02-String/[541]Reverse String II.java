//
//Given a string and an integer k, you need to reverse the first k characters fo
//r every 2k characters counting from the start of the string. If there are less t
//han k characters left, reverse all of them. If there are less than 2k but greate
//r than or equal to k characters, then reverse the first k characters and left th
//e other as original.
// 
//
// Example: 
// 
//Input: s = "abcdefg", k = 2
//Output: "bacdfeg"
// 
// 
//
//Restrictions: 
// 
// The string consists of lower English letters only. 
// Length of the given string and k will in the range [1, 10000] 
// Related Topics String 
// 👍 482 👎 1357


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // String
    // T:O(n) S:O(n)
    public String reverseStr(String s, int k) {
        if (s == null || s.length() == 0) return s;
        int n = s.length();
        char[] sc = s.toCharArray();
        for (int i = 0; i < n; i += 2 * k) {
            int j = Math.min(i + k - 1, n - 1);
            swap(sc, i, j);
        }
        return String.valueOf(sc);
    }

    private void swap(char[] sc, int i, int j) {
        for (; i < j; i++, j--) {
            char temp = sc[i];
            sc[i] = sc[j];
            sc[j] = temp;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
