class Solution {
    public int mySqrt(int x) {
        // note prevent overflow we should use / rather *
        if (x < 2) {
            return x;
        }
        
        int left = 1, right = x;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
                return mid;
            }
            else if (mid > x / mid) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }
}
