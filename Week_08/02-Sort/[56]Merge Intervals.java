//Given a collection of intervals, merge all overlapping intervals. 
//
// Example 1: 
//
// 
//Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
// 
//
// Example 2: 
//
// 
//Input: intervals = [[1,4],[4,5]]
//Output: [[1,5]]
//Explanation: Intervals [1,4] and [4,5] are considered overlapping. 
//
// NOTE: input types have been changed on April 15, 2019. Please reset to defaul
//t code definition to get new method signature. 
//
// 
// Constraints: 
//
// 
// intervals[i][0] <= intervals[i][1] 
// 
// Related Topics Array Sort 
// 👍 5126 👎 319


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // Sort
    // T:O(nlogn) S:O(n)
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[] next = intervals[0];
        result.add(next);
        for (int[] curr : intervals) {
            if (curr[0] <= next[1]) {
                next[1] = Math.max(curr[1], next[1]);
            } else {
                next = curr;
                result.add(next);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
