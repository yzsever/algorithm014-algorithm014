//You're given strings J representing the types of stones that are jewels, and S
// representing the stones you have. Each character in S is a type of stone you ha
//ve. You want to know how many of the stones you have are also jewels. 
//
// The letters in J are guaranteed distinct, and all characters in J and S are l
//etters. Letters are case sensitive, so "a" is considered a different type of sto
//ne from "A". 
//
// Example 1: 
//
// 
//Input: J = "aA", S = "aAAbbbb"
//Output: 3
// 
//
// Example 2: 
//
// 
//Input: J = "z", S = "ZZ"
//Output: 0
// 
//
// Note: 
//
// 
// S and J will consist of letters and have length at most 50. 
// The characters in J are distinct. 
// 
// Related Topics Hash Table 
// 👍 2267 👎 380


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // String
    // T:O(m+n) S:O(m)
    public int numJewelsInStones0(String J, String S) {
        if (J == null || J.length() == 0 || S == null || S.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char j : J.toCharArray()) {
            map.put(j, 0);
        }
        for (char s : S.toCharArray()) {
            if (map.get(s) != null) {
                map.put(s, map.get(s) + 1);
            }
        }
        int ans = 0;
        for (int val : map.values()) {
            ans += val;
        }
        return ans;
    }

    public int numJewelsInStones1(String J, String S) {
        if (J == null || J.length() == 0 || S == null || S.length() == 0) return 0;
        return S.replaceAll("[^" + J + "]", "").length();
    }

    public int numJewelsInStones(String J, String S) {
        int[] cnt = new int[128];
        for (char c : S.toCharArray())
            cnt[c]++;
        int ans = 0;
        for (char c : J.toCharArray())
            ans += cnt[c];
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
