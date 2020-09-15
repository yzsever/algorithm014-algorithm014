//A frog is crossing a river. The river is divided into x units and at each unit
// there may or may not exist a stone. The frog can jump on a stone, but it must n
//ot jump into the water. 
//
// Given a list of stones' positions (in units) in sorted ascending order, deter
//mine if the frog is able to cross the river by landing on the last stone. Initia
//lly, the frog is on the first stone and assume the first jump must be 1 unit.
// 
//
// If the frog's last jump was k units, then its next jump must be either k - 1,
// k, or k + 1 units. Note that the frog can only jump in the forward direction. 
//
// Note:
// 
// The number of stones is ≥ 2 and is < 1,100. 
// Each stone's position will be a non-negative integer < 231. 
// The first stone's position is always 0. 
// 
// 
//
// Example 1:
// 
//[0,1,3,5,6,8,12,17]
//
//There are a total of 8 stones.
//The first stone at the 0th unit, second stone at the 1st unit,
//third stone at the 3rd unit, and so on...
//The last stone at the 17th unit.
//
//Return true. The frog can jump to the last stone by jumping 
//1 unit to the 2nd stone, then 2 units to the 3rd stone, then 
//2 units to the 4th stone, then 3 units to the 6th stone, 
//4 units to the 7th stone, and 5 units to the 8th stone.
// 
// 
//
// Example 2:
// 
//[0,1,2,3,4,8,9,11]
//
//Return false. There is no way to jump to the last stone as 
//the gap between the 5th and 6th stone is too large.
// 
// Related Topics Dynamic Programming 
// 👍 1151 👎 112


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // DP T:O(n^2) S:O(n^2)
    // Sub-problem and state:
    // let dp[i][j] denote at stone i, the frog can or cannot make jump of size j
    // Recurrence relation:
    //    for any j < i,
    //            dist = stones[i] - stones[j];
    //    if dp[j][dist]:
    //        dp[i][dist - 1] = ture
    //        dp[i][dist] = ture
    //        dp[i][dist + 1] = ture
    public boolean canCross(int[] stones) {
        int n = stones.length;
        boolean[][] dp = new boolean[n][n + 1];
        dp[0][1] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int dist = stones[i] - stones[j];
                if (dist < 0 || dist > n || !dp[j][dist]) continue;
                if (i == n - 1) return true;
                if (dist - 1 >= 0) dp[i][dist - 1] = true;
                dp[i][dist] = true;
                if (dist + 1 < n) dp[i][dist + 1] = true;

            }
        }
        return false;
    }

//    Use map to represent a mapping from the stone (not index) to the steps that can be taken from this stone.
//    so this will be [0,1,3,5,6,8,12,17]
//    {17=[], 0=[1], 1=[1, 2], 3=[1, 2, 3], 5=[1, 2, 3], 6=[1, 2, 3, 4], 8=[1, 2, 3, 4], 12=[3, 4, 5]}
//
//    Notice that no need to calculate the last stone.
//    On each step, we look if any other stone can be reached from it,
//    if so, we update that stone's steps by adding step, step + 1, step - 1.
//    If we can reach the final stone, we return true. No need to calculate to the last stone.
//    Here is the code:

    public boolean canCross2(int[] stones) {
        if (stones.length == 0) {
            return true;
        }

        HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>(stones.length);
        map.put(0, new HashSet<Integer>());
        map.get(0).add(1);
        for (int i = 1; i < stones.length; i++) {
            map.put(stones[i], new HashSet<Integer>() );
        }

        for (int i = 0; i < stones.length - 1; i++) {
            int stone = stones[i];
            for (int step : map.get(stone)) {
                int reach = step + stone;
                if (reach == stones[stones.length - 1]) {
                    return true;
                }
                HashSet<Integer> set = map.get(reach);
                if (set != null) {
                    set.add(step);
                    if (step - 1 > 0) set.add(step - 1);
                    set.add(step + 1);
                }
            }
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
