class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, maximum = 0, numZeros = 0;
        
        for (int right = 0; right < nums.length; right ++) {
            if (nums[right] == 0) {
                numZeros += 1;
            }
            if (numZeros > k) {
                if (nums[left] == 0) {
                    numZeros -= 1;
                }
                left += 1;
            }
            if (numZeros <= k) {
                maximum = Math.max(maximum, right - left + 1);
            }
        }
        return maximum;
    }
}
