//Given a collection of numbers that might contain duplicates, return all possib
//le unique permutations. 
//
// Example: 
//
// 
//Input: [1,1,2]
//Output:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//]
// 
// Related Topics Backtracking 
// 👍 2076 👎 63


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, result, used, results);
        return results;
    }

    private void backtrack(int[] nums, List<Integer> result, boolean[] used, List<List<Integer>> results){
        // terminator
        if(result.size() == nums.length){
            results.add(new ArrayList<>(result));
            return;
        }

        for(int i=0; i< nums.length; i++){
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            // process current logic
            result.add(nums[i]);
            used[i] = true;
            // drill down
            backtrack(nums, result, used, results);
            // restore current status
            result.remove(result.size()-1);
            used[i] = false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
