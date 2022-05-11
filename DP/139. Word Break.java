class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        HashSet<String> set = new HashSet<>();
        set.addAll(wordDict);
        
        for (int start = 0; start < n; start ++) {
            if (dp[start] != true) {
                continue;
            }
            for (int end = start + 1; end < n + 1; end ++) {
                if (set.contains(s.substring(start, end))) {
                    dp[end] = true;
                }
            }
        }
        return dp[n];
    }
}
