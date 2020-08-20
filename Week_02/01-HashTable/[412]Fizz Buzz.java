//Write a program that outputs the string representation of numbers from 1 to n.
// 
//
// But for multiples of three it should output “Fizz” instead of the number and 
//for the multiples of five output “Buzz”. For numbers which are multiples of both
// three and five output “FizzBuzz”. 
//
// Example:
// 
//n = 15,
//
//Return:
//[
//    "1",
//    "2",
//    "Fizz",
//    "4",
//    "Buzz",
//    "Fizz",
//    "7",
//    "8",
//    "Fizz",
//    "Buzz",
//    "11",
//    "Fizz",
//    "13",
//    "14",
//    "FizzBuzz"
//]
// 
// 👍 935 👎 1234


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> fizzBuzz(int n) {
//        1、根据规则遍历 T:O(N) S:O(1)

/*        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            boolean divisibleBy3 = i % 3 == 0;
            boolean divisibleBy5 = i % 5 == 0;
            if (divisibleBy3 && divisibleBy5) {
                result.add("FizzBuzz");
            } else if (divisibleBy3) {
                result.add("Fizz");
            } else if (divisibleBy5) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;*/

        // 1-2
/*        List<String> results = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String result = i % 15 == 0 ? "FizzBuzz" : (i % 3 == 0 ? "Fizz" : (i % 5 == 0 ? "Buzz" : String.valueOf(i)));
            results.add(result);
        }
        return results;*/

        //        2、哈希表 T:O(N) S:O(1)
        List<String> result = new ArrayList<>();
        Map<Integer, String> dict = new HashMap<>() {
            {
                put(3, "Fizz");
                put(5, "Buzz");
            }
        };
        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            for (Integer key : dict.keySet()) {
                if (i % key == 0) {
                    sb.append(dict.get(key));
                }
            }
            if (sb.length() == 0) {
                sb.append(i);
            }
            result.add(sb.toString());
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
