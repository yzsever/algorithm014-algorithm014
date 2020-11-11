//We have a list of points on the plane. Find the K closest points to the origin
// (0, 0). 
//
// (Here, the distance between two points on a plane is the Euclidean distance.)
// 
//
// You may return the answer in any order. The answer is guaranteed to be unique
// (except for the order that it is in.) 
//
// 
//
// 
// Example 1: 
//
// 
//Input: points = [[1,3],[-2,2]], K = 1
//Output: [[-2,2]]
//Explanation: 
//The distance between (1, 3) and the origin is sqrt(10).
//The distance between (-2, 2) and the origin is sqrt(8).
//Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
//We only want the closest K = 1 points from the origin, so the answer is just [
//[-2,2]].
// 
//
// 
// Example 2: 
//
// 
//Input: points = [[3,3],[5,-1],[-2,4]], K = 2
//Output: [[3,3],[-2,4]]
//(The answer [[-2,4],[3,3]] would also be accepted.)
// 
//
// 
//
// Note: 
//
// 
// 1 <= K <= points.length <= 10000 
// -10000 < points[i][0] < 10000 
// -10000 < points[i][1] < 10000 
// 
// 
// Related Topics Divide and Conquer Heap Sort 
// 👍 2344 👎 126


import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        if (points == null || points.length < K) return null;
        PriorityQueue<int[]> queue = new PriorityQueue<>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
        for (int i = 0; i < points.length; i++) {
            queue.offer(points[i]);
            if (i + 1 > K) {
                queue.poll();
            }
        }
        int[][] ans = new int[K][2];
        while (K > 0) {
            ans[--K] = queue.poll();
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
