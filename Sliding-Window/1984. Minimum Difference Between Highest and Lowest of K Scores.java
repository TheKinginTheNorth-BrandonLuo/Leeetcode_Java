class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = k - 1;
        int res = Integer.MAX_VALUE;
        
        while (r < nums.length) {
            res = Math.min(res, nums[r] - nums[l]);
            l += 1;
            r += 1;
        }
        return res;
    }
}
