//Given a string, determine if it is a palindrome, considering only alphanumeric
// characters and ignoring cases. 
//
// Note: For the purpose of this problem, we define empty string as valid palind
//rome. 
//
// Example 1: 
//
// 
//Input: "A man, a plan, a canal: Panama"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: "race a car"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// s consists only of printable ASCII characters. 
// 
// Related Topics Two Pointers String 
// 👍 1480 👎 3226


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // Two Pointer
    // T:O(n) S:O(1)
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            while (i<j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while (i<j && !Character.isLetterOrDigit(s.charAt(j))) j--;
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
