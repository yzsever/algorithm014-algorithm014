//Given a non-empty array of integers, return the k most frequent elements. 
//
// Example 1: 
//
// 
//Input: nums = [1,1,1,2,2,3], k = 2
//Output: [1,2]
// 
//
// 
// Example 2: 
//
// 
//Input: nums = [1], k = 1
//Output: [1] 
// 
//
// Note: 
//
// 
// You may assume k is always valid, 1 ≤ k ≤ number of unique elements. 
// Your algorithm's time complexity must be better than O(n log n), where n is t
//he array's size. 
// It's guaranteed that the answer is unique, in other words the set of the top 
//k frequent elements is unique. 
// You can return the answer in any order. 
// 
// Related Topics Hash Table Heap 
// 👍 3481 👎 222


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[]{};
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
//        1、使用字典+大根堆 T：O(nlogn) S:O(n)
/*        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(entry);
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> entry = queue.poll();
            ans[i] = entry.getKey();
        }
        return ans;*/

//        2、使用字典+桶排序 T：O(n) S:O(n)
        int n = nums.length;
        List<Integer>[] bucket = new List[n + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            List<Integer> list = bucket[entry.getValue()];
            if (list == null) {
                list = new ArrayList<>();
                bucket[entry.getValue()] = list;
            }
            list.add(entry.getKey());
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = n; i > 0 && ans.size() < k; i--) {
            List<Integer> list = bucket[i];
            if (list != null) {
                ans.addAll(list);
            }
        }
        int[] ret = new int[ans.size()];
        int pos = 0;
        for (int num : ans) {
            ret[pos++] = num;
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
