//Given a non-negative integer num, repeatedly add all its digits until the resu
//lt has only one digit. 
//
// Example: 
//
// 
//Input: 38
//Output: 2 
//Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2. 
//             Since 2 has only one digit, return it.
// 
//
// Follow up: 
//Could you do it without any loop/recursion in O(1) runtime? Related Topics Mat
//h 
// 👍 882 👎 1148


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int addDigits(int num) {
        // 1、递归
        if (num / 10 == 0) {
            return num % 10;
        }
        int count = 0;
        while (num > 0) {
            count += num % 10;
            num /= 10;
        }
        return addDigits(count);


        // 2、迭代
    }

    public int addDigits2(int num) {
        // 3、数字根：T:O(1) S:O(1)
        // - 0 的数字根为0
        // - 非9的倍数的数字根为数字除9的余数
        // - 9的倍数的数字根为9
        return (num - 1) % 9 + 1;
    }

    public int addDigits3(int num) {
        // 3、数字根：T:O(1) S:O(1)
        // - 0 的数字根为0
        // - 非9的倍数的数字根为数字除9的余数
        // - 9的倍数的数字根为9
        // 3-2
        if (num == 0) {
            return 0;
        } else if (num % 9 == 0) {
            return 9;
        } else {
            return num % 9;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
