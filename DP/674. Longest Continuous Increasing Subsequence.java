class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null) {
            return 0;
        }
        
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;
        
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }
}
