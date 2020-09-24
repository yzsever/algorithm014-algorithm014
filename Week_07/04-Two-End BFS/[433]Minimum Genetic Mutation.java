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
// 👍 446 👎 60


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // Two-End BFS
    // T:O(n) S:O(n)
    public int minMutation(String start, String end, String[] bank) {
        if (start == null || start.length() == 0 || end == null || end.length() == 0 || start.length() != end.length())
            return -1;
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(end)) return -1;
        Set<String> qs = new HashSet<>(), qe = new HashSet<>(), visited = new HashSet<>(), qn;
        qs.add(start);
        visited.add(start);
        qe.add(end);
        visited.add(end);
        for (int len = 1; !qs.isEmpty(); len++) {
            qn = new HashSet<>();
            for (String word : qs) {
                Set<String> nexts = this.getNextWords(word, bankSet);
                for (String next : nexts) {
                    if (qe.contains(next)) return len;
                    if (visited.contains(next)) continue;
                    qn.add(next);
                    visited.add(next);
                }
            }
            qs = qn.size() < qe.size() ? qn : qe;
            qe = qs == qn ? qe : qn;
        }
        return -1;
    }

    public char[] cs = new char[]{'A', 'C', 'G', 'T'};

    public Set<String> getNextWords(String word, Set<String> bankSet) {
        Set<String> nextWords = new HashSet<>();
        char[] ws = word.toCharArray();
        for (int i = 0; i < ws.length; i++) {
            for (char c : cs) {
                if (ws[i] == c) continue;
                char oldc = ws[i];
                ws[i] = c;
                String nextWord = String.valueOf(ws);
                ws[i] = oldc;
                if (bankSet.contains(nextWord)) nextWords.add(nextWord);
            }
        }
        return nextWords;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
