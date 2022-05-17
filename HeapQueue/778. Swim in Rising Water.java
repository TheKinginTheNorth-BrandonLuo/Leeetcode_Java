class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        // HashSet<int[]> visited = new HashSet<>();
        // visited.add(new int[]{0, 0});
        boolean[][] visited = new boolean[n][n];
        int[][] directions = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        minHeap.offer(new int[]{grid[0][0], 0, 0});
        
        while (!minHeap.isEmpty()) {
            int[] heapPop = minHeap.poll();
            int t = heapPop[0], r = heapPop[1], c = heapPop[2];
            if (r == n - 1 && c == n - 1) {
                return t;
            }
            for (int[] dir: directions) {
                int newRow = r + dir[0], newCol = c + dir[1];
                if (newRow < 0 || newCol < 0 || newRow == n || newCol == n || visited[newRow][newCol] == true) {
                    continue;
                }
                // visited.add(new int[]{newRow, newCol});
                visited[newRow][newCol] = true;
                minHeap.offer(new int[]{Math.max(t, grid[newRow][newCol]), newRow, newCol});
            }
        }
        return 0;
    }
}
