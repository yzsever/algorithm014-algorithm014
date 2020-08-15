//You are playing the following Bulls and Cows game with your friend: You write 
//down a number and ask your friend to guess what the number is. Each time your fr
//iend makes a guess, you provide a hint that indicates how many digits in said gu
//ess match your secret number exactly in both digit and position (called "bulls")
// and how many digits match the secret number but locate in the wrong position (c
//alled "cows"). Your friend will use successive guesses and hints to eventually d
//erive the secret number. 
//
// Write a function to return a hint according to the secret number and friend's
// guess, use A to indicate the bulls and B to indicate the cows. 
//
// Please note that both secret number and friend's guess may contain duplicate 
//digits. 
//
// Example 1: 
//
// 
//Input: secret = "1807", guess = "7810"
//
//Output: "1A3B"
//
//Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7. 
//
// Example 2: 
//
// 
//Input: secret = "1123", guess = "0111"
//
//Output: "1A1B"
//
//Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.
// 
//
// Note: You may assume that the secret number and your friend's guess only cont
//ain digits, and their lengths are always equal. Related Topics Hash Table 
// 👍 675 👎 813

package leetcode.editor.en;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String getHint(String secret, String guess) {
        // 1、暴力法，两重循环 T:O(n^2) S:O(1)

        // 2、哈希表，T:O(n) S:(n)

        // 3、使用数组缓存数据。
        // - secret元素出现时，对应位置+1， guess位置出现时对应位置-1
        // - secret元素位置小于0说明之前guess中元素出现过。反之同理
        int bull = 0;
        int cows = 0;
        int[] nums = new int[10];
        int n = secret.length();
        for(int i=0; i<n; i++){
            int s = Character.getNumericValue(secret.charAt(i));
            int g = Character.getNumericValue(guess.charAt(i));
            if(s == g){
                bull++;
            }else{
                if(nums[s] < 0){
                    cows++;
                }
                if(nums[g] > 0){
                    cows++;
                }
                nums[s]++;
                nums[g]--;
            }
        }

        return bull+"A"+cows+"B";
    }
}
//leetcode submit region end(Prohibit modification and deletion)
