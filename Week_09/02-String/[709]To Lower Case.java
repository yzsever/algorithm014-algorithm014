//Implement function ToLowerCase() that has a string parameter str, and returns 
//the same string in lowercase. 
//
// 
//
// 
// Example 1: 
//
// 
//Input: "Hello"
//Output: "hello"
// 
//
// 
// Example 2: 
//
// 
//Input: "here"
//Output: "here"
// 
//
// 
// Example 3: 
//
// 
//Input: "LOVELY"
//Output: "lovely"
// 
// 
// 
// Related Topics String 
// 👍 540 👎 1662


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // String
    // T:O(n) S:O(n)
    public String toLowerCase1(String str) {
        if (str == null || str.length() == 0) return str;
        char[] sc = str.toCharArray();
        for (int i = 0; i < sc.length; i++) {
            if (sc[i] >= 'A' && sc[i] <= 'Z') {
                sc[i] += 32;
            }
        }
        return String.valueOf(sc);
    }

    // Bit Manipulation
    // T:O(n) S:O(n)
    public String toLowerCase(String str) {
        if (str == null || str.length() == 0) return str;
        char[] sc = str.toCharArray();
        for (int i = 0; i < sc.length; i++) {
            sc[i] |= 32;
        }
        return String.valueOf(sc);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
