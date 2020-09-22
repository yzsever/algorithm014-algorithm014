//There are N students in a class. Some of them are friends, while some are not.
// Their friendship is transitive in nature. For example, if A is a direct friend 
//of B, and B is a direct friend of C, then A is an indirect friend of C. And we d
//efined a friend circle is a group of students who are direct or indirect friends
//. 
//
// Given a N*N matrix M representing the friend relationship between students in
// the class. If M[i][j] = 1, then the ith and jth students are direct friends wit
//h each other, otherwise not. And you have to output the total number of friend c
//ircles among all the students. 
//
// Example 1: 
//
// 
//Input: 
//[[1,1,0],
// [1,1,0],
// [0,0,1]]
//Output: 2
//Explanation:The 0th and 1st students are direct friends, so they are in a frie
//nd circle. 
//The 2nd student himself is in a friend circle. So return 2.
// 
//
// 
//
// Example 2: 
//
// 
//Input: 
//[[1,1,0],
// [1,1,1],
// [0,1,1]]
//Output: 1
//Explanation:The 0th and 1st students are direct friends, the 1st and 2nd stude
//nts are direct friends, 
//so the 0th and 2nd students are indirect friends. All of them are in the same 
//friend circle, so return 1.
//
// 
//
// 
// Constraints: 
//
// 
// 1 <= N <= 200 
// M[i][i] == 1 
// M[i][j] == M[j][i] 
// 
// Related Topics Depth-first Search Union Find 
// 👍 2142 👎 149


//leetcode submit region begin(Prohibit modification and deletion)
class UnionFind {
    private int count = 0;
    private int[] parent;

    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        parent[rootP] = rootQ;
        count--;
    }

    public int getCount(){
        return count;
    }
}

class Solution {
    // Disjoint Set
    // T:O(n^2) S:O(n)
    public int findCircleNum(int[][] M) {
        int n = M.length;
        if (n == 0) return 0;
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (M[i][j] == 1) unionFind.union(i, j);
            }
        }
        return unionFind.getCount();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
