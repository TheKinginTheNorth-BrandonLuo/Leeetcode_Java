class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, mid = (n % 2 == 0 ? n / 2 - 1 : n / 2);
        
        int[] tmp = Arrays.copyOf(nums, n);
        
        int index = 0;
        
        for (int i = 0; i <= mid; i ++) {
            nums[index] = tmp[mid - i];
            if (index + 1 < n) {
                nums[index + 1] = tmp[n - i - 1];
            }
            index += 2;
        }
    }
}
