class Solution {
    public boolean isPerfectSquare(int num) {
        int left = 1, right = num;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int res = num / mid, remainder = num % mid;
            if (res == mid && remainder == 0) {
                return true;
            }
            else if (res > mid) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return false;
    }
}
