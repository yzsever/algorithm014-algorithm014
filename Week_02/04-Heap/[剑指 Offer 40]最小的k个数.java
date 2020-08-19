//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 堆 分治算法 
// 👍 122 👎 0


import java.util.Comparator;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
//        1、升序排序，返回最小的k个数 T:O(nlogn) S:O(logn)
/*        Arrays.sort(arr);
        int[] ans = new int[k];
        for(int i=0; i<k; i++){
            ans[i] = arr[i];
        }
        return ans;*/
//        2、快排的思想
//        3、大根堆 维护小的k个数，新数比堆顶大，则替换队顶元素 T：O(nlogn) S:O(k)
        if(k == 0 || arr.length == 0){
            return new int[0];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            if (i < k) {
                queue.offer(arr[i]);
            } else {
                int head = queue.peek();
                if (head > arr[i]) {
                    queue.poll();
                    queue.offer(arr[i]);
                }
            }
        }
        int[] ans = new int[queue.size()];
        int i = 0;
        for (int num : queue) {
            ans[i++] = num;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
