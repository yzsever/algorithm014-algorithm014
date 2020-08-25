//Given a collection of distinct integers, return all possible permutations. 
//
// Example: 
//
// 
//Input: [1,2,3]
//Output:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
// 
// Related Topics Backtracking 
// 👍 4218 👎 109


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
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
            if(used[i]){
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
