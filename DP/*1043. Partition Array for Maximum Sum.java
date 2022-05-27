class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 0);
        dp[0] = arr[0];
        int maxFirstK = arr[0];
        
        for (int i = 1; i < k; i ++) {
            maxFirstK = Math.max(maxFirstK, arr[i]);
            dp[i] = maxFirstK * (i + 1);
        }
        
        for (int i = k; i < arr.length; i ++) {
            int partitionMax = 0;
            for (int j = 0; j < k; j ++) {
                partitionMax = Math.max(partitionMax, arr[i - j]);
                int prevSum = dp[i - j - 1];
                dp[i] = Math.max(dp[i], prevSum + (j + 1) * partitionMax);
            }
        }
        return dp[dp.length - 1];
    }
}
