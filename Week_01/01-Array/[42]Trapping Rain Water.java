//Given n non-negative integers representing an elevation map where the width of
// each bar is 1, compute how much water it is able to trap after raining. 
//
// 
//The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In 
//this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos
// for contributing this image! 
//
// Example: 
//
// 
//Input: [0,1,0,2,1,0,1,3,2,1,2,1]
//Output: 6 
// Related Topics Array Two Pointers Stack 
// 👍 7602 👎 128

package leetcode.editor.en;

import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        // 1、暴力法，遍历找出每个位置两边最大值，取较小值为当前位置能接到的最大雨水 T:O(n^2) S:O(1)

        // 2、栈 T:O(n) S:O(n)
        // - 栈内存储数组元素下标
        // - 当前高度小于等于栈顶元素对应高度时，入栈
        // - 当前高度大于栈顶元素时，栈顶元素出栈，计算栈顶元素的积水量
        // - 出栈位置的distance = 右边界-左边界-1
        // - 出栈位置的积水高度为左右边界的较小值减当前高度：Math.min(height[curr]-height[stack.peek()])-height[top]
/*        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        int top, distance;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                distance = i - stack.peek() - 1;
                int min = Math.min(height[i], height[stack.peek()]);
                ans += distance * (min - height[top]);
            }
            stack.push(i);
        }

        return ans;*/

        // 3、双指针
        // 一端有更高的条形块（例如右端），积水的高度依赖于当前方向的高度（从左到右）。
        // 当我们发现另一侧（右侧）的条形块高度不是最高的，我们则开始从相反的方向遍历（从右到左）。
        //我们必须在遍历时维护
        //left_max 和 right_max
        int left = 0;
        int right = height.length - 1;
        int left_max = left;
        int right_max = right;
        int ans = 0;
        while (left < right) {
            if (height[left_max] < height[right_max]) {
                left++;
                // 左指针移动，计算积水面积
                if (height[left] < height[left_max]) {
                    ans += height[left_max] - height[left];
                } else {
                    left_max = left;
                }

            } else {
                right--;
                // 右指针移动，计算积水面积
                if (height[right] < height[right_max]) {
                    ans += height[right_max] - height[right];
                } else {
                    right_max = right;
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
