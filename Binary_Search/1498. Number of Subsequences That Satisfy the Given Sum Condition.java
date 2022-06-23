class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        int mod = (int)1e9 + 7;
        // It is impossible to use 2^n in Java when n is very large
        // So we need to use DP-method to pre-calculate 2^n % 1e9+7
        int[] powDp = new int[nums.length];
        powDp[0] = 1;
        for (int i = 1; i < powDp.length; i ++) {
            powDp[i] = (powDp[i - 1] * 2) % mod;
        }
        for (int start = 0; start < nums.length; start ++) {
            int left = start, right = nums.length - 1;
            int end = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[start] + nums[mid] <= target) {
                    left = mid + 1;
                    end = mid;
                }
                else {
                    right = mid - 1;
                }
            }
            if (end == -1) {
                break;
            }
            res = (res + powDp[end - start]) % mod;
        }
        return res;
    }
}
