class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        int r = 0;
        int res = 0;
        long total = 0;
        
        while (r < nums.length) {
            total += nums[r];
            while (nums[r] * (r - l + 1) > total + k) {
                total -= nums[l];
                l += 1;
            }
            res = Math.max(res, r - l + 1);
            r += 1;
        }
        return res;
    }
}
