class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n =points.length, res = 0;
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        int[] dist = new int[n];
        for (int i = 1; i < n; i ++) {
            dist[i] = findDist(points, 0, i);
        }
        
        while (set.size() != n) {
            int next = -1;
            for (int i = 0; i < n; i ++) {
                if (set.contains(i)) {
                    continue;
                }
                if (next == -1 || dist[next] > dist[i]) {
                    next = i;
                }
            }
            set.add(next);
            res += dist[next];
            for (int i = 0; i < n; i ++) {
                if (!set.contains(i)) {
                    dist[i] = Math.min(dist[i], findDist(points, i, next));
                }
            }
        }
        return res;
    }
    
    private int findDist(int[][] points, int a, int b) {
        return Math.abs(points[a][0] - points[b][0]) + Math.abs(points[a][1] - points[b][1]);
    }
}
