class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        
        int product1 = 1;
        for (int i = 0 ; i < nums.length; i ++) {
            res[i] = product1;
            product1 *= nums[i];
        }
        
        int product2 = 1;
        for (int i = res.length - 1; i >= 0; i --) {
            res[i] *= product2;
            product2 *= nums[i];
        }
        return res;
    }
}
