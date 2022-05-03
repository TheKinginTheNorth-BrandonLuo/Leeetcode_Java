class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] res = new int[1001];
        Arrays.fill(res, 0);
        
        for (int t[]: trips) {
            res[t[1]] += t[0];
            res[t[2]] -= t[0];
        }
        
        int curPassenger = 0;
        
        for (int i = 0; i < 1001; i ++) {
            curPassenger += res[i];
            if (curPassenger > capacity) {
                return false;
            }
        }
        return true;
    }
}
