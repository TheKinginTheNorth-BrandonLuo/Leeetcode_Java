class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (nums == null) {
            return 0;
        }
        if (n < 3) {
            return nums.length == 1 ? nums[0] : Math.max(nums[0], nums[1]);
        }
        
        int dp1 = 0, dp2 = 0;
        for (int i = 0; i < n - 1; i ++) {
            int tmp = dp1;
            dp1 = Math.max(dp1, nums[i] + dp2);
            dp2 = tmp;
        }
        
        int dpp1 = 0, dpp2 = 0;
        for (int i = 1; i < n; i ++) {
            int tmp = dpp1;
            dpp1 = Math.max(dpp1, nums[i] + dpp2);
            dpp2 = tmp;
        }
        return Math.max(dp1, dpp1);
    }
}
