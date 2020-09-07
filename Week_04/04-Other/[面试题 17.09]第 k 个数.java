//有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，
//5，7，9，15，21。 
//
// 示例 1: 
//
// 输入: k = 5
//
//输出: 9
// 
// Related Topics 堆 队列 数学 
// 👍 30 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getKthMagicNumber(int k) {
        int i3 = 1, i5 = 1, i7 = 1;
        int[] nums = new int[10000];
        nums[1] = 1;
        int magicNum = 1;
        for (int i = 2; i <= k; i++) {
            nums[i] = Math.min(3 * nums[i3], Math.min(5 * nums[i5], 7 * nums[i7]));
            if (3 * nums[i3] == nums[i]) {
                i3++;
            }
            if (5 * nums[i5] == nums[i]) {
                i5++;
            }
            if (7 * nums[i7] == nums[i]) {
                i7++;
            }
        }
        return nums[k];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
