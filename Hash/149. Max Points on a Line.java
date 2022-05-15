class Solution {
    public int maxPoints(int[][] points) {
        int res = 1;
        for (int i = 0; i < points.length; i ++) {
            HashMap<Double, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j ++) {
                if (i != j) {
                    double k = Math.atan2(points[i][0] - points[j][0], points[i][1] - points[j][1]);
                    map.put(k, map.getOrDefault(k, 1) + 1);
                    res = Math.max(res, map.get(k));
                }
            }
        }
        return res;
    }
}
