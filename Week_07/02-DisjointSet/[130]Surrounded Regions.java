//Given a 2D board containing 'X' and 'O' (the letter O), capture all regions su
//rrounded by 'X'. 
//
// A region is captured by flipping all 'O's into 'X's in that surrounded region
//. 
//
// Example: 
//
// 
//X X X X
//X O O X
//X X O X
//X O X X
// 
//
// After running your function, the board should be: 
//
// 
//X X X X
//X X X X
//X X X X
//X O X X
// 
//
// Explanation: 
//
// Surrounded regions shouldn’t be on the border, which means that any 'O' on th
//e border of the board are not flipped to 'X'. Any 'O' that is not on the border 
//and it is not connected to an 'O' on the border will be flipped to 'X'. Two cell
//s are connected if they are adjacent cells connected horizontally or vertically.
// 
// Related Topics Depth-first Search Breadth-first Search Union Find 
// 👍 2055 👎 706


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

    public boolean isConnected(int p, int q){
        return find(p) == find(q);
    }

    public int getCount(){
        return count;
    }
}

class Solution {
    // Disjoint Set + BFS
    // T:O(mn) S:O(mn)
    public void solve(char[][] board) {
        int m = board.length;
        if(m == 0) return;
        int n = board[0].length;
        UnionFind unionFind = new UnionFind(m*n+1);
        int dummyNode = m*n;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') continue;
                int curr = i * n + j;
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    unionFind.union(curr, dummyNode);
                    continue;
                }
                if (i - 1 >= 0 && board[i - 1][j] == 'O') unionFind.union((i - 1) * n + j, curr);
                if (j - 1 >= 0 && board[i][j - 1] == 'O') unionFind.union(i * n + j - 1, curr);
                if (i + 1 < m && board[i + 1][j] == 'O') unionFind.union((i + 1) * n + j, curr);
                if (j + 1 < n && board[i][j + 1] == 'O') unionFind.union(i * n + j + 1, curr);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') continue;
                if (!unionFind.isConnected(i * n + j, dummyNode)) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
