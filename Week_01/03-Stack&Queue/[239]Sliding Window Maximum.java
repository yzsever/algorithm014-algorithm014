//Given an array nums, there is a sliding window of size k which is moving from 
//the very left of the array to the very right. You can only see the k numbers in 
//the window. Each time the sliding window moves right by one position. Return the
// max sliding window. 
//
// Follow up: 
//Could you solve it in linear time? 
//
// Example: 
//
// 
//Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
//Output: [3,3,5,5,6,7] 
//Explanation: 
//
//Window position                Max
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10^5 
// -10^4 <= nums[i] <= 10^4 
// 1 <= k <= nums.length 
// 
// Related Topics Heap Sliding Window 
// 👍 3669 👎 171


import java.util.Deque;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
//        1、暴力 T：O(NK) S：O(N-k+1)。每次从本次位置遍历k个元素，找到最大值
//        2、单调队列 O(n+k)
//        - 使用双端队列构造一种单调队列，单调队列支持队首出队，队尾入队，和获取最大值
//        - 队尾入队：从队尾遍历移除掉队列中所有比入队元素小的元素，然后入队
//        - 队首出队：判断队首是不是要出队的元素，如果是出队，不是不用操作
//        - 获取最大值：直接返回队首元素
//        - 划动窗口时，将第k个元素入队，再将第一个元素出队，再返回最大值
        MonotonicQueue queue = new MonotonicQueue();
        int n = nums.length;
        int[] max = new int[n - k + 1];
/*        for (int i = 0; i < k - 1; i++) {
            queue.push(nums[i]);
        }
        int j = 0;
        for (int i = k - 1; i < nums.length; i++) {
            queue.push(nums[i]);
            max[j] = queue.getMax();
            queue.pop(nums[j]);
            j++;
        }*/
        for (int i = 0; i < n; i++) {
            if (i < k - 1) {
                queue.push(nums[i]);
            } else {
                queue.push(nums[i]);
                max[i - k + 1] = queue.getMax();
                queue.pop(nums[i - k + 1]);
            }
        }
        return max;
    }

    private class MonotonicQueue {
        private Deque<Integer> deque;

        public MonotonicQueue() {
            deque = new LinkedList<>();
        }

        private void push(int x) {
            while (!deque.isEmpty() && deque.peekLast() < x) {
                deque.pollLast();
            }
            deque.offerLast(x);
        }

        private void pop(int x) {
            if (!deque.isEmpty() && deque.peekFirst() == x) {
                deque.pollFirst();
            }
        }

        private int getMax() {
            return deque.peekFirst();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
