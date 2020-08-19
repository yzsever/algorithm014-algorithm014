//Write a program to find the n-th ugly number. 
//
// Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
//
// Example: 
//
// 
//Input: n = 10
//Output: 12
//Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ug
//ly numbers. 
//
// Note: 
//
// 
// 1 is typically treated as an ugly number. 
// n does not exceed 1690. 
// Related Topics Math Dynamic Programming Heap 
// 👍 2016 👎 124


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Ugly {
    public int[] nums = new int[1690];

    public Ugly() {
//        1、最小堆 T:O(nlogn) S:O(n)
//        - 取堆顶元素k，并将2*k,3*k,5*k入堆(不存在过的)
//        - 如果k在结果中已存在，则过滤
/*        PriorityQueue<Long> heap = new PriorityQueue<>();
        HashSet<Long> seen = new HashSet<>();
        heap.offer(1L);
        seen.add(1L);

        int i = 0;
        int[] primes = new int[]{2, 3, 5};
        while (i < 1690) {
            long currUgly = heap.poll();
            nums[i] = (int)currUgly;
            for (int j : primes) {
                long newUgly = currUgly * j;
                if (!seen.contains(newUgly)) {
                    heap.offer(newUgly);
                    seen.add(newUgly);
                }
            }
            i++;
        }*/

//        2、动态规划 T:O(1) S:O(n)
//        - 使用i2，i3，i5三个指针标记所指丑数要乘的因子
//        - 在2*nums[i2]，3*nums[i3],5*nums[i5]中选出最小的丑数并添加到数组中

        nums[0] = 1;
        int min, i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < 1690; i++) {
            min = Math.min(Math.min(2 * nums[i2], 3 * nums[i3]), 5 * nums[i5]);
            nums[i] = min;
            if (min == 2 * nums[i2]) {
                i2++;
            }
            if (min == 3 * nums[i3]) {
                i3++;
            }
            if (min == 5 * nums[i5]){
                i5++;
            }
        }
    }
}

class Solution {
    public static Ugly ugly = new Ugly();
    public int nthUglyNumber(int n) {
        return ugly.nums[n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
