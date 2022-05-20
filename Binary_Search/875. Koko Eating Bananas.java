class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int right = 0;
        for (int p: piles) {
            right = Math.max(right, p);
        }
        int left = 1, res = right;
        
        while (left <= right) {
            int k = left + (right - left) / 2;
            int hours = 0;
            for (int p: piles) {
                hours += (p + k - 1) / k;
            }
            if (hours <= h) {
                res = Math.min(res, k);
                right = k - 1;
            }
            else {
                left = k + 1;
            }
        }
        return res;
    }
}
