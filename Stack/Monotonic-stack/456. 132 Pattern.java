class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length, middleMax = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = n - 1; i >= 0; i --) {
            if (nums[i] < middleMax) {
                return true;
            }
            while (!stack.empty() && stack.peek() < nums[i]) {
                middleMax = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }
}
