//Given two words (beginWord and endWord), and a dictionary's word list, find th
//e length of shortest transformation sequence from beginWord to endWord, such tha
//t: 
//
// 
// Only one letter can be changed at a time. 
// Each transformed word must exist in the word list. 
// 
//
// Note: 
//
// 
// Return 0 if there is no such transformation sequence. 
// All words have the same length. 
// All words contain only lowercase alphabetic characters. 
// You may assume no duplicates in the word list. 
// You may assume beginWord and endWord are non-empty and are not the same. 
// 
//
// Example 1: 
//
// 
//Input:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//Output: 5
//
//Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog
//" -> "cog",
//return its length 5.
// 
//
// Example 2: 
//
// 
//Input:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//Output: 0
//
//Explanation: The endWord "cog" is not in wordList, therefore no possible trans
//formation.
// 
//
// 
// 
// Related Topics Breadth-first Search 
// 👍 3650 👎 1271


import java.util.HashSet;
import java.util.List;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // Two-End BFS
    // T:O(n) S:O(n)
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || beginWord.length() == 0 || endWord == null
                || endWord.length() == 0 || beginWord.length() != endWord.length()) return 0;
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        Set<String> qs = new HashSet<>(), qe = new HashSet<>(), visited = new HashSet<>(), qn;
        qs.add(beginWord);
        visited.add(beginWord);
        qe.add(endWord);
        visited.add(endWord);
        for (int len = 2; !qs.isEmpty(); len++) {
            qn = new HashSet<>();
            for (String word : qs) {
                Set<String> nexts = getNextWords(word, wordSet);
                for (String next : nexts) {
                    if (qe.contains(next)) return len;
                    if (visited.contains(next)) continue;
                    qn.add(next);
                    visited.add(next);
                }
            }
            qs = (qn.size() < qe.size()) ? qn : qe;
            qe = (qs == qe) ? qn : qe;
        }
        return 0;
    }

    public Set<String> getNextWords(String word, Set<String> wordSet) {
        Set<String> nextWords = new HashSet<>();
        char[] wc = word.toCharArray();
        for (int i = 0; i < wc.length; i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (wc[i] == c) continue;
                char oldc = wc[i];
                wc[i] = c;
                String nextWord = String.valueOf(wc);
                wc[i] = oldc;
                if (wordSet.contains(nextWord)) nextWords.add(nextWord);
            }
        }
        return nextWords;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
