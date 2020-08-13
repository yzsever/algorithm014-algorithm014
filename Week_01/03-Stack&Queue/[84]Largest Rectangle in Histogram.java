//Given n non-negative integers representing the histogram's bar height where th
//e width of each bar is 1, find the area of largest rectangle in the histogram. 
//
// 
//
// 
//Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3
//]. 
//
// 
//
// 
//The largest rectangle is shown in the shaded area, which has area = 10 unit. 
//
// 
//
// Example: 
//
// 
//Input: [2,1,5,6,2,3]
//Output: 10
// 
// Related Topics Array Stack 
// 👍 3920 👎 88

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
//        1、暴力，找到每个柱子的左右边界，然后用柱子的高度乘边界的宽度得到以该柱子高度形成的矩形，并获得最大值 O(n^2)
//        2、栈，栈内需要保存柱子的高度和柱子的位置，栈底存入(-1,-1)
//          - 当前元素比栈顶元素大时，入栈
//          - 栈内的元素前一个元素为左边界
//          - 当栈顶元素不为-1，且当前元素小于栈顶元素时，即找到了右边界，栈顶元素出栈，计算矩形面积。直到栈顶元素大于当前元素，当前元素入栈
//          - 元素遍历结束后，栈顶元素的位置加1为所有栈内元素的右边界，依次执行出栈操作计算矩形面积
/*        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        int top, leftBound, rightBound, height, area;
        for (int i = 0; i < heights.length; i++) {
            top = stack.peek();
            while (top != -1 && heights[i] < heights[top]) {
                rightBound = i;
                height = heights[top];
                stack.pop();
                leftBound = top = stack.peek();
                area = height * (rightBound - leftBound - 1);
                max = Math.max(max, area);
            }
            stack.push(i);
        }
        if (!stack.isEmpty() && stack.peek() != -1) {
            rightBound = stack.peek() + 1;
            while (!stack.isEmpty() && stack.peek() != -1) {
                height = heights[stack.pop()];
                leftBound = stack.peek();
                area = height * (rightBound - leftBound - 1);
                max = Math.max(max, area);
            }
        }
        return max;*/

        //3、栈，代码优化 T:O(n) S:O(n)
        int n = heights.length;
        int[] leftBound = new int[n];
        int[] rightBound = new int[n];
        Arrays.fill(rightBound, n);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                rightBound[stack.peek()] = i;
                stack.pop();
            }
            leftBound[i] = (stack.isEmpty() ? -1 : stack.peek());
            stack.push(i);
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, heights[i] * (rightBound[i] - leftBound[i] - 1));
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
