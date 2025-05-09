import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int first;
    int second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    private void bfs(int ro, int co, boolean[][] vis, char[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(ro, co));
        vis[ro][co] = true;

        int n = grid.length;
        int m = grid[0].length;

        
        int[][] directions = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int row = curr.first;
            int col = curr.second;

        
            for (int[] dir : directions) {
                int nrow = row + dir[0];
                int ncol = col + dir[1];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && 
                    grid[nrow][ncol] == '1' && !vis[nrow][ncol]) {

                    vis[nrow][ncol] = true;
                    q.add(new Pair(nrow, ncol));
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m]; 
        int count = 0;

        
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (!vis[row][col] && grid[row][col] == '1') {
                    count++; 
                    bfs(row, col, vis, grid);
                }
            }
        }
        return count;
    }
}