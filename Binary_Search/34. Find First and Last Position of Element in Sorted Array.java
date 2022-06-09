class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums.length == 0) {
            return res;
        }
        
        
        if (nums[0] <= target && nums[nums.length - 1] >= target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    left = mid;
                    right = mid;
                    while (left - 1 >= 0 && nums[left - 1] == target) {
                        left --;
                    }
                    while (right + 1 <= nums.length - 1 && nums[right + 1] == target) {
                        right ++;
                    }
                    res[0] = left;
                    res[1] = right;
                    return res;
                }
                else if (nums[mid] < target) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
        }
        return res;
    }
}
