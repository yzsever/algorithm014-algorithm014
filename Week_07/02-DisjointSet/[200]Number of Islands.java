//Given a 2d grid map of '1's (land) and '0's (water), count the number of islan
//ds. An island is surrounded by water and is formed by connecting adjacent lands 
//horizontally or vertically. You may assume all four edges of the grid are all su
//rrounded by water. 
//
// 
// Example 1: 
//
// 
//Input: grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//Output: 3
// 
// Related Topics Depth-first Search Breadth-first Search Union Find 
// 👍 6406 👎 207


//leetcode submit region begin(Prohibit modification and deletion)
class UnionFind {
    private int count = 0;
    private int[] parent;

    public UnionFind(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        parent = new int[m * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1'){
                    parent[i * m + j] = i * m + j;
                    count++;
                }
            }
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
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if(m == 0) return 0;
        int n = grid[0].length;
        UnionFind unionFind = new UnionFind(grid);
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1') {
                    grid[i][j] = '0';
                    bfs(grid, i, j, unionFind);
                }
            }
        }
        return unionFind.getCount();
    }

    private final int[][] routes = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public void bfs(char[][] grid, int x, int y, UnionFind unionFind) {
        int m = grid.length;
        int n = grid[0].length;
        for (int[] route : routes) {
            int newX = x + route[0];
            int newY = y + route[1];
            if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == '1') {
                unionFind.union(x * n + y, newX * n + newY);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
