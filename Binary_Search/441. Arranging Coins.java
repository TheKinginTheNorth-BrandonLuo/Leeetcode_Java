class Solution {
    public int arrangeCoins(int n) {
        long left = 1, right = n;
        long res = 0;
        
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long sum = (1 + mid) * mid / 2;
            if (sum > n) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
                res = Math.max(res, mid);
            }
        }
        return (int)res;
    }
}
