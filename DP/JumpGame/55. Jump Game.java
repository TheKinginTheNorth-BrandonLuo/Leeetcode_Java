class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int maxDestination = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (maxDestination < i) {
                return false;
            }
            maxDestination = Math.max(maxDestination, nums[i] + i);
            if (maxDestination >= nums.length) {
                return true;
            }
        }
        return true;
    }
}
