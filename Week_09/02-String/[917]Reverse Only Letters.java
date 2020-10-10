//Given a string S, return the "reversed" string where all characters that are n
//ot a letter stay in the same place, and all letters reverse their positions. 
//
// 
//
// 
// 
// 
// 
// 
// 
// 
// 
//
// 
// Example 1: 
//
// 
//Input: "ab-cd"
//Output: "dc-ba"
// 
//
// 
// Example 2: 
//
// 
//Input: "a-bC-dEf-ghIj"
//Output: "j-Ih-gfE-dCba"
// 
//
// 
// Example 3: 
//
// 
//Input: "Test1ng-Leet=code-Q!"
//Output: "Qedo1ct-eeLg=ntse-T!"
// 
//
// 
//
// 
// Note: 
//
// 
// S.length <= 100 
// 33 <= S[i].ASCIIcode <= 122 
// S doesn't contain \ or " 
// 
// 
// 
// 
// Related Topics String 
// 👍 641 👎 38


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // String
    // T:O(n) S:O(n)
    public String reverseOnlyLetters(String S) {
        if(S == null || S.length() < 2) return S;
        char[] sc = S.toCharArray();
        int left = 0, right = S.length()-1;
        while (left < right){
            while (left < right && !Character.isLetter(sc[left])) left++;
            while (left < right && !Character.isLetter(sc[right])) right--;
            char temp = sc[left];
            sc[left++] = sc[right];
            sc[right--] = temp;
        }
        return String.valueOf(sc);
    }

    public String reverseOnlyLetters1(String S) {
        StringBuilder sb = new StringBuilder(S);
        for (int i = 0, j = S.length() - 1; i < j; ++i, --j) {
            while (i < j && !Character.isLetter(sb.charAt(i))) ++i;
            while (i < j && !Character.isLetter(sb.charAt(j))) --j;
            sb.setCharAt(i, S.charAt(j));
            sb.setCharAt(j, S.charAt(i));
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
