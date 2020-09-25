//In an N by N square grid, each cell is either empty (0) or blocked (1). 
//
// A clear path from top-left to bottom-right has length k if and only if it is 
//composed of cells C_1, C_2, ..., C_k such that: 
//
// 
// Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are d
//ifferent and share an edge or corner) 
// C_1 is at location (0, 0) (ie. has value grid[0][0]) 
// C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1]) 
// If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0). 
//
// 
//
// Return the length of the shortest such clear path from top-left to bottom-rig
//ht. If such a path does not exist, return -1. 
//
// 
//
// Example 1: 
//
// 
//Input: [[0,1],[1,0]]
//
//
//Output: 2
//
// 
//
// 
// Example 2: 
//
// 
//Input: [[0,0,0],[1,1,0],[1,1,0]]
//
//
//Output: 4
//
// 
//
// 
// 
//
// Note: 
//
// 
// 1 <= grid.length == grid[0].length <= 100 
// grid[r][c] is 0 or 1 
// 
// Related Topics Breadth-first Search 
// 👍 538 👎 43


import com.magima.bean.ErrorMessage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // BFS
    // T:O(n) S:O(n)
    public static int[][] routes = {{0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}};

    public int shortestPathBinaryMatrix1(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        if (n == 0) return 0;
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) return -1;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ans++;
            while (size-- > 0) {
                int[] curr = queue.poll();
                if (curr[0] == m - 1 && curr[1] == n - 1) return ans;
                for (int[] route : routes) {
                    int x = curr[0] + route[0], y = curr[1] + route[1];
                    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 1 || visited[x][y])
                        continue;
                    queue.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
        return -1;
    }

    // A*
    private static class Node implements Comparable<Node> {
        // coordinate
        private int x;
        private int y;

        // g(node) is the cost of the path from the start node to node
        private int g;
        // f(node) = g(node) + h(node)
        private int f;

        private Node(int x, int y, int g, int h) {
            this.x = x;
            this.y = y;
            this.g = g;
            this.f = g + h;
        }

        @Override
        public int compareTo(Node node) {
            return this.f - node.f;
        }
    }

    // eight directions sorted in clockwise order
    private static int[][] DIRECTIONS = new int[][]{{0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int endX = m - 1, endY = n - 1;

        if (grid[endX][endY] == 1) return -1; // early exit

        // Initialize the open list -> which node we expand next?
        PriorityQueue<Node> pq = new PriorityQueue<Node>();

        // Initialize the closed list -> which nodes we've already visited? What is the minimum g from start node to this?
        int[] closed = new int[m * n];
        Arrays.fill(closed, Integer.MAX_VALUE);

        // put the starting node on the open list
        pq.add(new Node(0, 0, 1, Math.max(m, n)));

        // while the open list is not empty
        while (!pq.isEmpty()) {

            // retrive the node with the least f on the open list, call it "node"
            Node node = pq.remove();

            int x = node.x;
            int y = node.y;


            // if node is the goal, stop search
            if (x == endX && y == endY) return node.g;

            // if a node with the same position is in the closed list
            // which has a lower or equals g than this, skip this expansion
            if (closed[x * m + y] <= node.g) continue;

            // push node on the closed list
            closed[x * m + y] = node.g;

            // generate 8 successors to node
            for (int[] dir : DIRECTIONS) {
                // skip disallowed area
                if (x + dir[0] < 0 || x + dir[0] >= m || y + dir[1] < 0 || y + dir[1] >= n || grid[x + dir[0]][y + dir[1]] == 1) continue;
                // for each successor
                // successor.g = node.g + distance between successor and node (equals to 1)
                // successor.h = estimate distance from successor to goal
                int g = node.g + 1;

                // h(node) is a heuristic function that
                // estimates the cost of the cheapest path from node to the goal

                // Here we use **Diagonal Distance** as heuristic function,
                // because we can and only can move in eight directions
                int h = Math.max(Math.abs(endX - x), Math.abs(endY - y));

                // push the successor on the open list
                pq.add(new Node(x + dir[0], y + dir[1], g, h));
            }
        }

        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
