//Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all ele
//ments in arr2 are also in arr1. 
//
// Sort the elements of arr1 such that the relative ordering of items in arr1 ar
//e the same as in arr2. Elements that don't appear in arr2 should be placed at th
//e end of arr1 in ascending order. 
//
// 
// Example 1: 
// Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//Output: [2,2,2,1,4,3,3,9,6,7,19]
// 
// 
// Constraints: 
//
// 
// arr1.length, arr2.length <= 1000 
// 0 <= arr1[i], arr2[i] <= 1000 
// Each arr2[i] is distinct. 
// Each arr2[i] is in arr1. 
// 
// Related Topics Array Sort 
// 👍 794 👎 58


import java.util.TreeMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // counting sort
    // T:O(1) S:O(1)
    public int[] relativeSortArray1(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        for (int i : arr1) count[i]++;
        int index = 0;
        for (int j : arr2) {
            while (count[j]-- > 0) {
                arr1[index++] = j;
            }
        }
        for (int i = 0; i < count.length; i++) {
            while (count[i]-- > 0) {
                arr1[index++] = i;
            }
        }
        return arr1;
    }

    // counting sort+ TreeMap
    // T:O(nlogn) S:O(n)
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i : arr1) map.put(i, map.getOrDefault(i, 0) + 1);
        int index = 0;
        for (int j : arr2) {
            for (int k = 0; k < map.get(j); k++) {
                arr1[index++] = j;
            }
            map.remove(j);
        }
        for (int i : map.keySet()) {
            for (int k = 0; k < map.get(i); k++) {
                arr1[index++] = i;
            }
        }
        return arr1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
