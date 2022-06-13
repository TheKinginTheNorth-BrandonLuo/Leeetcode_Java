class Solution {
    public int maxProduct(int[] nums) {
        int posProduct = nums[0], negProduct = nums[0];
        
        int res = nums[0];
        
        for (int i = 1; i < nums.length; i ++) {
            int tmpPos = posProduct;
            posProduct = Math.max(Math.max(nums[i], tmpPos * nums[i]), negProduct * nums[i]);
            negProduct = Math.min(Math.min(nums[i], tmpPos * nums[i]), negProduct * nums[i]);
            res = Math.max(res, posProduct);
        }
        return res;
    }
}
