//Given a set of distinct integers, nums, return all possible subsets (the power
// set). 
//
// Note: The solution set must not contain duplicate subsets. 
//
// Example: 
//
// 
//Input: nums = [1,2,3]
//Output:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics Array Backtracking Bit Manipulation 
// 👍 4151 👎 88


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    1、回溯
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        backtrack(nums, 0, result, results);
        return results;
    }

    private void backtrack(int[] nums, int start, List<Integer> result, List<List<Integer>> results) {
        results.add(new ArrayList<>(result));
        for (int i = start; i < nums.length; i++) {
            // process current logic
            result.add(nums[i]);
            // drill down
            backtrack(nums, i + 1, result, results);
            // restore current status
            result.remove(result.size() - 1);
        }
    }

    //    2、逐个枚举
    //    - 空集的幂集只有空集，每增加一个元素，让之前幂集中的每个集合，追加这个元素，就是新增的子集。
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<>());
        recursion(nums, 0, results);
        return results;
    }

    private void recursion(int[] nums, int pos, List<List<Integer>> results){
        // terminator
        if(pos == nums.length){
            return;
        }
        // process current logic
        int size = results.size();
        for(int i=0; i<size; i++){
            List<Integer> result = new ArrayList<>(results.get(i));
            result.add(nums[pos]);
            results.add(result);
        }
        // drill down
        recursion(nums, pos+1, results);
        // restore current status

        return;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
