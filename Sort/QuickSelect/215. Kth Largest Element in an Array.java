class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        return quickSelect(nums, k, 0, nums.length - 1);
        
    }
    private int quickSelect(int[] nums, int k, int l, int r) {
        int pivot = nums[r], p = l;
        for (int i = l; i < r; i ++) {
            if (nums[i] <= pivot) {
                int temp = nums[i];
                nums[i] = nums[p];
                nums[p] = temp;
                p += 1;
            }
        }
        int temp2 = nums[p];
        nums[p] = nums[r];
        nums[r]  = temp2;
        
        if (p > k) {
            return quickSelect(nums, k, l, p - 1);
        }
        else if (p < k) {
            return quickSelect(nums, k, p + 1, r);
        }
        else {
            return nums[p];
        }
    }
}
