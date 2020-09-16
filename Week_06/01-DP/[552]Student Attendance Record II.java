//Given a positive integer n, return the number of all possible attendance recor
//ds with length n, which will be regarded as rewardable. The answer may be very l
//arge, return it after mod 109 + 7. 
//
// A student attendance record is a string that only contains the following thre
//e characters: 
//
// 
// 
// 'A' : Absent. 
// 'L' : Late. 
// 'P' : Present. 
// 
// 
//
// 
//A record is regarded as rewardable if it doesn't contain more than one 'A' (ab
//sent) or more than two continuous 'L' (late). 
//
// Example 1: 
// 
//Input: n = 2
//Output: 8 
//Explanation:
//There are 8 records with length 2 will be regarded as rewardable:
//"PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL"
//Only "AA" won't be regarded as rewardable owing to more than one absent times.
// 
// 
// 
//
// Note:
//The value of n won't exceed 100,000.
// 
//
//
// Related Topics Dynamic Programming 
// 👍 583 👎 112


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    DP T：O（n）S：O（n）
//    记录需要满足的条件为：1、不能出现两个A 2、不能连续出现超过两个L
//    P[i] = PorL[i - 1]; //this line means ending with P, just appending P in PorL
//    PorL[i] = (P[i] + P[i - 1] + P[i - 2]) % M; //P[i] end with P, P[i-1], end with one L(or PL), P[i-2], end with two L(or LL).
    static final int M = 1000000007;

    public int checkRecord(int n) {
        // ending with P or L, no A
        long[] PorL = new long[n + 1];
        // ending with P, no A
        long[] P = new long[n + 1];
        PorL[0] = P[0] = 1; P[1] = 1; PorL[1] = 2;
        for (int i = 2; i <= n; i++) {
            P[i] = PorL[i - 1];
            PorL[i] = (P[i] + P[i - 1] + P[i - 2]) % M;
        }
        long ans = PorL[n];
        // inserting A into (n-1)-length strings
        for (int i = 0; i < n; i++) {
            // A's index is i, A's left res is PorL[0], A's right res is PorL[n-i-1]
            long s = (PorL[i] * PorL[n - i - 1]) % M;
            ans = (ans + s) % M;
        }
        return (int)ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
