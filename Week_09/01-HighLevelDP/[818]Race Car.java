//Your car starts at position 0 and speed +1 on an infinite number line. (Your c
//ar can go into negative positions.) 
//
// Your car drives automatically according to a sequence of instructions A (acce
//lerate) and R (reverse). 
//
// When you get an instruction "A", your car does the following: position += spe
//ed, speed *= 2. 
//
// When you get an instruction "R", your car does the following: if your speed i
//s positive then speed = -1 , otherwise speed = 1. (Your position stays the same.
//) 
//
// For example, after commands "AAR", your car goes to positions 0->1->3->3, and
// your speed goes to 1->2->4->-1. 
//
// Now for some target position, say the length of the shortest sequence of inst
//ructions to get there. 
//
// 
//Example 1:
//Input: 
//target = 3
//Output: 2
//Explanation: 
//The shortest instruction sequence is "AA".
//Your position goes from 0->1->3.
// 
//
// 
//Example 2:
//Input: 
//target = 6
//Output: 5
//Explanation: 
//The shortest instruction sequence is "AAARA".
//Your position goes from 0->1->3->7->7->6.
// 
//
// 
//
// Note: 
//
// 
// 1 <= target <= 10000. 
// 
// Related Topics Dynamic Programming Heap 
// 👍 537 👎 58


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // DP
    // Explanation
    //
    //Let's say n is the length of target in binary and we have 2 ^ (n - 1) <= target < 2 ^ n
    //We have 2 strategies here:
    //
    //1. Go pass our target , stop and turn back
    //We take n instructions of A.
    //1 + 2 + 4 + ... + 2 ^ (n-1) = 2 ^ n - 1
    //Then we turn back by one R instruction.
    //In the end, we get closer by n + 1 instructions.
    //
    //2. Go as far as possible before pass target, stop and turn back
    //We take n - 1 instruction of A and one R.
    //Then we take m instructions of A, where m < n
    //
    //Complexity
    //Time O(TlogT)
    //Space O(T)
    int[] dp = new int[10001];

    public int racecar(int target) {
        if (dp[target] > 0) return dp[target];
        int n = (int) (Math.log(target) / Math.log(2)) + 1;
        if ((1 << n) - 1 == target) {
            dp[target] = n;
        } else {
            dp[target] = racecar((1 << n) - 1 - target) + n + 1;
            for (int m = 0; m < n - 1; m++) {
                dp[target] = Math.min(dp[target],
                        racecar(target - (1 << (n - 1)) + (1 << m)) + n + m + 1);
            }
        }
        return dp[target];
    }

}
//leetcode submit region end(Prohibit modification and deletion)
