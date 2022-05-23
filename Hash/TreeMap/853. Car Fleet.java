class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < position.length; i ++) {
            map.put(target - position[i], speed[i]);
        }
        int res = 0;
        double r = -1.0;
        
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int d = entry.getKey();
            int s = entry.getValue();
            double t = 1.0 * d / s;
            
            if (t > r) {
                res += 1;
                r = t;
            }
        }
        return res;
    }
}
