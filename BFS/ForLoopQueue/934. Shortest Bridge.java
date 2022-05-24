class Solution {
    public int shortestBridge(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid.length];
        for (int r = 0; r < grid.length; r ++) {
            for (int c = 0; c < grid.length; c ++) {
                if (grid[r][c] == 1) {
                    dfs(grid, r, c, visited);
                    return bfs(grid, visited);
                }
            }
        }
        return 0;
    }
    
    public void dfs(int[][] grid, int r, int c, boolean[][] visited) {
        // dfs method to fill boolean array visited
        int[][] directions = {{r - 1, c}, {r + 1, c}, {r, c + 1}, {r, c - 1}};
        if (r < 0 || c < 0 || r >= grid.length || c >= grid.length || grid[r][c] == 0 || visited[r][c]) {
            return;
        }
        visited[r][c] = true;
        for (int[] dir: directions) {
            dfs(grid, dir[0], dir[1], visited);
        }
    }
    
    public int bfs(int[][] grid, boolean[][] visited) {
        int res = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid.length; j ++) {
                if (visited[i][j]) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i ++) {
                int[] temp = queue.poll();
                int r = temp[0], c = temp[1];
                int[][] directions = {{r - 1, c}, {r + 1, c}, {r, c + 1}, {r, c - 1}};
                for (int[] dir: directions) {
                    if (dir[0] < 0 || dir[1] < 0 || dir[0] >= grid.length || dir[1] >= grid.length || visited[dir[0]][dir[1]]) {
                        continue;
                    }
                    if (grid[dir[0]][dir[1]] == 1) {
                        return res;
                    }
                    queue.offer(new int[]{dir[0], dir[1]});
                    visited[dir[0]][dir[1]] = true;
                }
            }
            res += 1;
        }
        return res;
    }
}
