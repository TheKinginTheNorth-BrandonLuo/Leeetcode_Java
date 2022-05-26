class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums == null) {
            return 0;
        }
        
        int max = Integer.MIN_VALUE;
        for (int n: nums) {
            max = Math.max(max, n);
        }
        
        int[] freq = new int[max + 1];
        Arrays.fill(freq, 0);
        for (int n: nums) {
            freq[n] += n;
        }
        
        int[] dp = new int[max + 1];
        Arrays.fill(dp, 0);
        dp[1] = freq[1];
        
        for (int i = 2; i < max + 1; i ++) {
            dp[i] = Math.max(dp[i - 2] + freq[i], dp[i - 1]);
        }
        
        return dp[max];
    }
}
