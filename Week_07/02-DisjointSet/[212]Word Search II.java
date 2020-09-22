//Given a 2D board and a list of words from the dictionary, find all words in th
//e board. 
//
// Each word must be constructed from letters of sequentially adjacent cell, whe
//re "adjacent" cells are those horizontally or vertically neighboring. The same l
//etter cell may not be used more than once in a word. 
//
// 
//
// Example: 
//
// 
//Input: 
//board = [
//  ['o','a','a','n'],
//  ['e','t','a','e'],
//  ['i','h','k','r'],
//  ['i','f','l','v']
//]
//words = ["oath","pea","eat","rain"]
//
//Output: ["eat","oath"]
// 
//
// 
//
// Note: 
//
// 
// All inputs are consist of lowercase letters a-z. 
// The values of words are distinct. 
// 
// Related Topics Backtracking Trie 
// 👍 2912 👎 124


import com.magima.bean.ErrorMessage;

import java.util.ArrayList;
import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Trie {
    private Trie[] next;
    private boolean isEnd;

    public Trie() {
        next = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        Trie curr = this;
        for (int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            if (curr.next[pos] == null) {
                curr.next[pos] = new Trie();
            }
            curr = curr.next[pos];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = searchPreifx(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie node = searchPreifx(prefix);
        return node != null;
    }

    public Trie searchPreifx(String prefix) {
        if (prefix != null && prefix.length() == 0) {
            return null;
        }
        Trie curr = this;
        for (int i = 0; i < prefix.length(); i++) {
            int n = prefix.charAt(i) - 'a';
            if (curr.next[n] == null) return null;
            curr = curr.next[n];
        }
        return curr;
    }
}

class Solution {
    // Trie+Backtracking
    // T:O(M(4⋅3^(L−1))O(M(4⋅3L−1))，其中M 是二维网格中的单元格数，L 是单词的最大长度。
    // S:O(N)，其中 N 是字典中的字母总数。
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> results = new HashSet<>();
        int m = board.length;
        if (m == 0) return new ArrayList<>(results);
        int n = board[0].length;
        Trie dict = new Trie();
        for (String word : words) {
            dict.insert(word);
        }
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                backtracking(board, dict, visited, "", i, j, results);
            }
        }
        return new ArrayList<>(results);
    }
    private static final int[][] routes = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public void backtracking(char[][] board, Trie dict, boolean[][] visited, String word, int row, int col, Set<String> results) {
        // terminator
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        }
        if (visited[row][col]) return;

        // process current logic
        String newWord = word + board[row][col];
        if (!dict.startsWith(newWord)) return;
        if (dict.search(newWord)) {
            results.add(newWord);
        }
        // drill down
        visited[row][col] = true;
        for(int[] route : routes) {
            backtracking(board, dict, visited, newWord, row + route[0], col + route[1], results);
        }
        visited[row][col] = false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
