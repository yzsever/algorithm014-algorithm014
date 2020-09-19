//Given a string S and a string T, find the minimum window in S which will conta
//in all the characters in T in complexity O(n). 
//
// Example: 
//
// 
//Input: S = "ADOBECODEBANC", T = "ABC"
//Output: "BANC"
// 
//
// Note: 
//
// 
// If there is no such window in S that covers all characters in T, return the e
//mpty string "". 
// If there is such window, you are guaranteed that there will always be only on
//e unique minimum window in S. 
// 
// Related Topics Hash Table Two Pointers String Sliding Window 
// 👍 5058 👎 342


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //新建两个Map，needs是存放子串的单个char值和出现的次数；windows是每次滑动的窗口
    Map<Character, Integer> needs = new HashMap<Character, Integer>();
    Map<Character, Integer> windows = new HashMap<Character, Integer>();

    public String minWindow(String s, String t) {
        //不符合的情况直接return
        if (s == null || s.length() == 0 || t == null || t.length() == 0 || s.length() < t.length()) return "";

        //把子串的数据保存到needs中，即(char, 出现的次数)
        for (int i = 0; i < t.length(); i++) {
            needs.put(t.charAt(i), needs.getOrDefault(t.charAt(i), 0) + 1);
        }
        //窗口左边界，窗口右边界
        int l = 0, r = -1;
        //求最小长度，先置为最大值，最小长度的左边界和右边界
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        //遍历，窗口往右滑，当窗口右边界的值==字符串长度时结束
        while (r < s.length()) {
            //每次右边界+1
            r++;
            //如果右边界的值是子串的某一值，将窗口windows的所对应的键值对进行+1操作
            if (r < s.length() && needs.containsKey(s.charAt(r))) {
                windows.put(s.charAt(r),windows.getOrDefault(s.charAt(r), 0) + 1);
            }
            //遍历，右边界右滑已经保证当前窗口已经包含子串，这次是左边界向左移，求最小窗口值
            while (check() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                //如果包含左边界的值，当前窗口对应的键值对进行-1操作，然后求下一个满足要求的滑动窗口
                if (needs.containsKey(s.charAt(l))) {
                    windows.put(s.charAt(l), windows.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }

        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public Boolean check() {
        for (Map.Entry<Character, Integer> entry : needs.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (windows.getOrDefault(key, 0) < value) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
