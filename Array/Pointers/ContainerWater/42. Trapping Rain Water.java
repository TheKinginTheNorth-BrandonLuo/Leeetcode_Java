class Solution {
    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        
        int leftMax = height[0], rightMax = height[height.length - 1];
        int left = 1, right = height.length - 2;
        int res = 0;
        
        while (left <= right) {
            if (leftMax <= rightMax) {
                leftMax = Math.max(leftMax, height[left]);
                res += leftMax - height[left];
                left ++;
            }
            else {
                rightMax = Math.max(rightMax, height[right]);
                res += rightMax - height[right];
                right --;
            }
        }
        return res;
    }
}
