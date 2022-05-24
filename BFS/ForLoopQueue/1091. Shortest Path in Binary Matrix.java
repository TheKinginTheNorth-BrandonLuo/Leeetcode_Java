class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, 1});
        grid[0][0] = 1;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i ++) {
                int[] temp = queue.poll();
                int r = temp[0], c = temp[1], path = temp[2];
                if (r == n - 1 && c == n - 1) {
                    return path;
                }
                int[][] directions = {{r - 1, c}, {r + 1, c}, {r, c + 1}, {r, c - 1}, {r - 1, c - 1}, {r - 1, c + 1}, {r + 1, c - 1}, {r + 1, c + 1}};
                for (int[] dir: directions) {
                    if (0 <= dir[0] && 0 <= dir[1] && dir[0] < n && dir[1] < n && grid[dir[0]][dir[1]]  == 0) {
                        grid[dir[0]][dir[1]] = 1;
                        queue.offer(new int[]{dir[0], dir[1], path + 1});
                    }
                }
            }
        }
        return -1;
    }
}
