class Solution {
    public int shortestPath(int[][] grid, int k) {
        int ROWS = grid.length, COLS = grid[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, k, 0});
        boolean[][][] visited = new boolean[ROWS][COLS][k + 1];
        
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
                int r = temp[0], c = temp[1], leftObstacle = temp[2], path = temp[3];
                if (r == ROWS - 1 && c == COLS - 1) {
                    return path;
                }
                int[][] directions = {{r - 1, c}, {r + 1, c}, {r, c + 1}, {r, c - 1}};
                for (int[] dir: directions) {
                    if (dir[0] < 0 || dir[1] < 0 || dir[0] >= ROWS || dir[1] >= COLS) {
                        continue;
                    }
                    int newK =  leftObstacle - grid[dir[0]][dir[1]];
                    if (newK >= 0 && !visited[dir[0]][dir[1]][newK]) {
                        visited[dir[0]][dir[1]][newK] = true;
                        queue.offer(new int[]{dir[0], dir[1], newK, path + 1});
                    }
                    
                }
            }
        return -1;
    }
}
