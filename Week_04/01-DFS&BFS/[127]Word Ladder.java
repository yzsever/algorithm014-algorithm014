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
// 👍 3485 👎 1236


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 1 BFS T:O(M*N) S:O(M*N)
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int length = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            length++;
            while (size-- > 0) {
                String currWord = queue.poll();
                for (int i = 0; i < endWord.length(); i++) {
                    for (char letter = 'a'; letter <= 'z'; letter++) {
                        StringBuilder newWord = new StringBuilder(currWord);
                        newWord.setCharAt(i, letter);
                        if (set.contains(newWord.toString())) {
                            if (newWord.toString().equals(endWord)) {
                                return length + 1;
                            }
                            set.remove(newWord.toString());
                            queue.offer(newWord.toString());
                        }
                    }
                }
            }
        }
        return 0;
    }

    // 2 Two-End-BFS T:O(n*m) S:O(n*m) 14ms
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Set<String> dict = new HashSet<>(wordList), qs = new HashSet<>(), qe = new HashSet<>(), vis = new HashSet<>();
        qs.add(beginWord);
        qe.add(endWord);
        for (int len = 2; !qs.isEmpty(); len++) {
            Set<String> nq = new HashSet<>();
            for (String w : qs) {
                for (int j = 0; j < w.length(); j++) {
                    char[] ch = w.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == ch[j]) continue; // beginWord and endWord not the same, so bypass itself
                        ch[j] = c;
                        String nb = String.valueOf(ch);
                        if (qe.contains(nb)) return len; // meet from two ends
                        if (dict.contains(nb) && vis.add(nb)) nq.add(nb); // not meet yet, vis is safe to use
                    }
                }
            }
            qs = (nq.size() < qe.size()) ? nq : qe; // switch to small one to traverse from other end
            qe = (qs == nq) ? qe : nq;
        }
        return 0;
    }

    // 2-2 31ms
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Set<String> dict = new HashSet<>(wordList), qStart = new HashSet<>(), qEnd = new HashSet<>(), visited = new HashSet<>();
        qStart.add(beginWord);
        qEnd.add(endWord);
        for (int len = 2; !qStart.isEmpty(); len++){
            Set<String> qNext = new HashSet<>();
            for(String word : qStart){
                for(int i=0; i<word.length(); i++) {
                    char[] ch = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (ch[i] == c) continue;
                        ch[i] = c;
                        String newWord  = String.valueOf(ch);
                        if(qEnd.contains(newWord)) return len;
                        if(dict.contains(newWord) && visited.add(newWord)) qNext.add(newWord);
                    }
                }
            }
            qStart = (qNext.size() < qEnd.size()) ? qNext : qEnd;
            qEnd = (qStart == qNext) ? qEnd : qNext;
        }
        return 0;
    }
}


//leetcode submit region end(Prohibit modification and deletion)
