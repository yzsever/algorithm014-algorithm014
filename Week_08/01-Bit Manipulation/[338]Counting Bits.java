//Given a non negative integer number num. For every numbers i in the range 0 ≤ 
//i ≤ num calculate the number of 1's in their binary representation and return th
//em as an array. 
//
// Example 1: 
//
// 
//Input: 2
//Output: [0,1,1] 
//
// Example 2: 
//
// 
//Input: 5
//Output: [0,1,1,2,1,2]
// 
//
// Follow up: 
//
// 
// It is very easy to come up with a solution with run time O(n*sizeof(integer))
//. But can you do it in linear time O(n) /possibly in a single pass? 
// Space complexity should be O(n). 
// Can you do it like a boss? Do it without using any builtin function like __bu
//iltin_popcount in c++ or in any other language. 
// Related Topics Dynamic Programming Bit Manipulation 
// 👍 3069 👎 177


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // DP + 最后设置位
    // P(x)=P(x&(x−1))+1;
    public int[] countBits1(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            ans[i] = ans[i & (i - 1)] + 1;
        }
        return ans;
    }

    // DP + 最低有效位
    // P(x)=P(x/2)+(xmod2)
    public int[] countBits2(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }

    // DP + 最高有效位
    // P(x+b)=P(x)+1,b=2^m>x
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        int i = 0, b = 1;
        // [0, b) is calculated
        while (b <= num) {
            // generate [b, 2b) or [b, num) from [0, b)
            while(i < b && i + b <= num){
                ans[i + b] = ans[i] + 1;
                ++i;
            }
            i = 0;   // reset i
            b <<= 1; // b = 2b
        }
        return ans;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
