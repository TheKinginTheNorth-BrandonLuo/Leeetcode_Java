class Solution {
    public int splitArray(int[] nums, int m) {
        int left = nums[0];
        int right = 0;
        for (int n: nums) {
            right += n;
            left = Math.max(left, n);
        }
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (countSubarrays(nums, mid) <= m) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    public int countSubarrays(int[] nums, int mid) {
        int total = 0, count = 1;
        for (int num: nums) {
            if (total + num <= mid) {
                total += num;
            }
            else {
                total = num;
                count += 1;
            }
        }
        return count;
        
    }
}
