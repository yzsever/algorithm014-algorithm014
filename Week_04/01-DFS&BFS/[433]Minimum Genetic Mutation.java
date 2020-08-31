//A gene string can be represented by an 8-character long string, with choices f
//rom "A", "C", "G", "T". 
//
// Suppose we need to investigate about a mutation (mutation from "start" to "en
//d"), where ONE mutation is defined as ONE single character changed in the gene s
//tring. 
//
// For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation. 
//
// Also, there is a given gene "bank", which records all the valid gene mutation
//s. A gene must be in the bank to make it a valid gene string. 
//
// Now, given 3 things - start, end, bank, your task is to determine what is the
// minimum number of mutations needed to mutate from "start" to "end". If there is
// no such a mutation, return -1. 
//
// Note: 
//
// 
// Starting point is assumed to be valid, so it might not be included in the ban
//k. 
// If multiple mutations are needed, all mutations during in the sequence must b
//e valid. 
// You may assume start and end string is not the same. 
// 
//
// 
//
// Example 1: 
//
// 
//start: "AACCGGTT"
//end:   "AACCGGTA"
//bank: ["AACCGGTA"]
//
//return: 1
// 
//
// 
//
// Example 2: 
//
// 
//start: "AACCGGTT"
//end:   "AAACGGTA"
//bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
//
//return: 2
// 
//
// 
//
// Example 3: 
//
// 
//start: "AAAAACCC"
//end:   "AACCCCCC"
//bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
//
//return: 3
// 
//
// 
// 👍 430 👎 59


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 1、BFS
    public int minMutation(String start, String end, String[] bank) {
        if (start == null || end == null || start != null && start.equals(end)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        char[] chars = new char[]{'A', 'C', 'G', 'T'};
        Set<String> visited = new HashSet<>();
        List<String> banks = new ArrayList<>(Arrays.asList(bank));
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String curr = queue.poll();
                if (curr.equals(end)) {
                    return level;
                }
                char[] currChars = curr.toCharArray();
                for (int i = 0; i < currChars.length; i++) {
                    for (char c : chars) {
                        if (currChars[i] == c) {
                            continue;
                        }
                        char oldC = currChars[i];
                        currChars[i] = c;
                        String next = new String(currChars);
                        if (banks.contains(next) && !visited.contains(next)) {
                            queue.offer(next);
                            visited.add(next);
                        }
                        // restore current status
                        currChars[i] = oldC;
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
