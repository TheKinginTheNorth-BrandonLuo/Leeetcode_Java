class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        HashMap<Double, Integer> map = new HashMap<>();
        for (int[] r: rectangles) {
            double k = Math.atan2(Double.valueOf(r[0]), Double.valueOf(r[1]));
            map.put(k, map.getOrDefault(k, 0) + 1);
        }
        
        long res = 0;
        for (double c: map.values()) {
            if (c > 1) {
                res += c * (c - 1) / 2;
            }
        }
        return res;
    }
}
