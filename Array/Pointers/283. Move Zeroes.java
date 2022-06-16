class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        
        int cur = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] != 0) {
                if (i != cur) {
                    nums[cur] = nums[i];
                    nums[i] = 0;
                }
                cur ++;
            }
        }
    }
}
