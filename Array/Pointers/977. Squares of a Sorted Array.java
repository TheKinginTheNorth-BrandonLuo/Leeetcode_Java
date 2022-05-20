class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int[] res = new int[n];
        
        for (int i = n - 1; i >= 0; i --) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                res[i] = nums[left] * nums[left];
                left += 1;
            }
            else {
                res[i] = nums[right] * nums[right];
                right -= 1;
            }
        }
        return res;
    }
}
