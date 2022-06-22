class Solution {
    public int[] runningSum(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        
        int left = 0;
        int[] res = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i --) {
            res[i] = sum - left;
            left += nums[i];
        }
        return res;
    }
}
