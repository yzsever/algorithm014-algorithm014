//Given an array nums of n integers, are there elements a, b, c in nums such tha
//t a + b + c = 0? Find all unique triplets in the array which gives the sum of ze
//ro. 
//
// Note: 
//
// The solution set must not contain duplicate triplets. 
//
// Example: 
//
// 
//Given array nums = [-1, 0, 1, 2, -1, -4],
//
//A solution set is:
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics Array Two Pointers 
// 👍 7495 👎 850


import com.mongodb.util.Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
//        1、穷举+排重 O(n^3)
//        2、将问题降维到两数之和，a+b+c=0变成a+b=-c。再使用指针两边夹逼 O(n^2)
//       方法一：使用了Set，但是时间比较慢，要180ms
/*        Arrays.sort(nums);
        Set<List<Integer>> results = new HashSet<>();
        System.out.println(Arrays.toString(nums));
        for (int k = 0; k < nums.length - 2; k++) {
            int i = k + 1, j = nums.length - 1;
            while(i < j){
                if (nums[i] + nums[j] == -nums[k]) {
                    List<Integer> result = new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[j]));
                    results.add(result);
                    i++;
                    j--;
                } else if (nums[i] + nums[j] < -nums[k]) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        return new ArrayList<>(results);*/

//      方法二：进行了剪枝，时间比较快，仅20ms
        Arrays.sort(nums);
        List<List<Integer>> results = new LinkedList<>();
        for (int k = 0; k < nums.length - 2; k++) {
            // 重复的答案剪枝
            // num[k]已经在后面的集合A中找到了所有的答案集合B，则num[k+1]=num[k]时，对应的A‘是A的子集，则能找到的答案为B‘是B的子集
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            int low = k + 1;
            int high = nums.length - 1;
            while (low < high) {
                if (nums[low] + nums[high] == -nums[k]) {
                    List<Integer> result = new ArrayList<>(Arrays.asList(nums[k], nums[low], nums[high]));
                    results.add(result);
                    // 重复的答案剪枝
                    // low+high的答案组合确定时，如果下一个还是low，则满足要求的high必然一样，为重复答案，需要跳过
                    while (low < high && nums[low] == nums[low + 1]) {
                        low++;
                    }
                    // 重复的答案剪枝
                    while (low < high && nums[high] == nums[high - 1]) {
                        high--;
                    }
                    low++;
                    high--;
                } else if (nums[low] + nums[high] < -nums[k]) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return results;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
