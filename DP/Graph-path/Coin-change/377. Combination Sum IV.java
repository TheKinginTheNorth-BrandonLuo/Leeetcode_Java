class Solution {
    public int combinationSum4(int[] nums, int target) {
        int n = target + 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        
        for (int i = 1; i < n; i ++) {
            for (int num: nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[n - 1];
    }
}
