class Solution {
    public int minCut(String s) {
        int n = s.length(), min;
        
        int[] dp = new int[n];
        boolean[][] isPalindrome = new boolean[n][n];
        
        for (int right = 0; right < n; right ++) {
            min = right; // max curs to make palindrome
            for (int left = 0; left <= right; left ++) {
                if (s.charAt(left) == s.charAt(right) && (right - left < 3 || isPalindrome[left + 1][right - 1])) {
                    isPalindrome[left][right] = true;
                    min = (left == 0 ? 0 : Math.min(min, dp[left - 1] + 1));
                }
            }
            dp[right] = min;
        }
        return dp[n - 1];
    }
}
