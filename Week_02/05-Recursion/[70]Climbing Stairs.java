//You are climbing a stair case. It takes n steps to reach to the top. 
//
// Each time you can either climb 1 or 2 steps. In how many distinct ways can yo
//u climb to the top? 
//
// Example 1: 
//
// 
//Input: 2
//Output: 2
//Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps
// 
//
// Example 2: 
//
// 
//Input: 3
//Output: 3
//Explanation: There are three ways to climb to the top.
//1. 1 step + 1 step + 1 step
//2. 1 step + 2 steps
//3. 2 steps + 1 step
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 45 
// 
// Related Topics Dynamic Programming 
// 👍 4588 👎 148


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int climbStairs(int n) {
        //1\
//        steps ways
//        1   1 f(1)=1
//        2   2 f(2)=2
//        3   3 f(3)=f(1)+f(2)
//        f(4)=f(3)+f(2)
//        ...
//        f(n)=f(n-1)+f(n-2)


//        1、递归 O(2^n)
/*        if (n <= 2) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);*/

//        2、递归+缓存 O()
        if (n <= 2) {
            return n;
        } else {
            if (map.get(n) != null) {
                return map.get(n);
            }
            map.put(n, climbStairs(n - 1) + climbStairs(n - 2));
        }
        return map.get(n);

//        3、动态规划 O(n)
/*        if(n <= 2){
            return n;
        }
        int f1 = 1, f2 = 2, f3 = 3;
        for(int i=4; i<=n; i++){
            f1 = f2;
            f2 = f3;
            f3 = f1+f2;
        }
        return f3;*/
    }
}
//leetcode submit region end(Prohibit modification and deletion)
