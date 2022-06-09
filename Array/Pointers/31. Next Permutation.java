class Solution {
    public void nextPermutation(int[] nums) {
        int pivot = nums.length - 1;
        while (pivot > 0 && nums[pivot] <= nums[pivot - 1]) {
            pivot --;
        }
        if (pivot == 0) {
            Arrays.sort(nums);
            return;
        }
        
        int successor = pivot;
        while (successor < nums.length && nums[successor] > nums[pivot - 1]) {
            successor ++;
        }
        successor --;
        int tmp = nums[pivot - 1];
        nums[pivot - 1] = nums[successor];
        nums[successor] = tmp;
        
        Arrays.sort(nums, pivot, nums.length);
    }
}
