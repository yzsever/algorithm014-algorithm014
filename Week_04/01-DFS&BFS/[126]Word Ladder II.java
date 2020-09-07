//Given two words (beginWord and endWord), and a dictionary's word list, find al
//l shortest transformation sequence(s) from beginWord to endWord, such that: 
//
// 
// Only one letter can be changed at a time 
// Each transformed word must exist in the word list. Note that beginWord is not
// a transformed word. 
// 
//
// Note: 
//
// 
// Return an empty list if there is no such transformation sequence. 
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
//Output:
//[
//  ["hit","hot","dot","dog","cog"],
//  ["hit","hot","lot","log","cog"]
//]
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
//Output: []
//
//Explanation: The endWord "cog" is not in wordList, therefore no possible trans
//formation.
// 
//
// 
// 
// Related Topics Array String Backtracking Breadth-first Search 
// 👍 1916 👎 257


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dict = new HashSet<>(wordList);
        List<List<String>> results = new ArrayList<>();
        HashMap<String, ArrayList<String>> neighbors = new HashMap<>();
        // 每个节点距离起点的距离
        HashMap<String, Integer> distance = new HashMap<>();
        List<String> result = new ArrayList<>();

        dict.add(beginWord);
        bfs(beginWord, endWord, dict, neighbors, distance);
        dfs(beginWord, endWord, dict, neighbors, distance, result, results);
        return results;
    }

    // 计算每个节点和开始节点的距离
    private void bfs(String beginWord, String endWord, HashSet<String> dict, HashMap<String, ArrayList<String>> neighbors, HashMap<String, Integer> distance) {
        for(String str : dict){
            neighbors.put(str, new ArrayList<>());
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distance.put(beginWord, 0);
        while (!queue.isEmpty()){
            int size = queue.size();
            boolean foundEnd = false;
            while (size-- > 0){
                String curr = queue.poll();
                int curDis = distance.get(curr);
                List<String> nexts = getNeighbors(curr, dict);
                for(String next : nexts){
                    neighbors.get(curr).add(next);
                    if(!distance.containsKey(next)){
                        distance.put(next, curDis+1);
                        if(endWord.equals(next)){
                            foundEnd = true;
                        }else{
                            queue.offer(next);
                        }
                    }
                }
            }
            if(foundEnd){
                break;
            }
        }
    }

    private List<String> getNeighbors(String curr, HashSet<String> dict) {
        List<String> neighbors = new ArrayList<>();
        char[] ches = curr.toCharArray();
        for(int i=0; i<ches.length; i++){
            for(char c='a'; c<='z'; c++){
                if(ches[i] == c){
                    continue;
                }
                char oldC= ches[i];
                ches[i] = c;
                String newWord = String.valueOf(ches);
                ches[i] = oldC;
                if(dict.contains(newWord)){
                    neighbors.add(newWord);
                }
            }
        }
        return neighbors;
    }

    // 找到所有的最短路径
    private void dfs(String currWord, String endWord, HashSet<String> dict, HashMap<String, ArrayList<String>> neighbors, HashMap<String, Integer> distance, List<String> result, List<List<String>> results) {
        result.add(currWord);
        if(endWord.equals(currWord)){
            results.add(new ArrayList<>(result));
        }else{
            for(String next : neighbors.get(currWord)){
                if(distance.get(next) == distance.get(currWord)+1){
                    dfs(next, endWord, dict, neighbors, distance, result, results);
                }
            }
        }
        result.remove(result.size()-1);
    }


}
//leetcode submit region end(Prohibit modification and deletion)
