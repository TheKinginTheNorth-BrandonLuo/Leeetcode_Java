// 3 methods
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int[] arr = nums.clone();
        for (int i = 0; i < n; i ++) {
            nums[(i + k) % n] = arr[i];
        }
    }
}

class SecondSolution {
    public void rotate(int[] nums, int k) {
        if (nums.length == 1) {
            return;
        }
        
        int n = nums.length;
        k %= n;
        
        // 1,2,3,4,5,6,7
        // first, reverse all --> 7,6,5,4,3,2,1
        // second, reverse 0 to k - 1 --- > 5,6,7,4,3,2,1
        // last, reverse k to rest part --> 5,6,7,1,2,3,4
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }
    
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left ++;
            right --;
        }
    }
}
