class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> minQueue = new ArrayDeque<>();
        Deque<Integer> maxQueue = new ArrayDeque<>();
        int l = 0, r = 0;
        int res = 0;
        
        while (r < nums.length) {
            while (!minQueue.isEmpty() && nums[r] <= nums[minQueue.peekLast()]) {
                minQueue.pollLast();
            }
            while (!maxQueue.isEmpty() && nums[r] >= nums[maxQueue.peekLast()]) {
                maxQueue.pollLast();
            }
            minQueue.offer(r);
            maxQueue.offer(r);
            
            while (nums[maxQueue.peek()] - nums[minQueue.peek()] > limit) {
                l += 1;
                if (l > minQueue.peek()) {
                    minQueue.poll();
                }
                if (l > maxQueue.peek()) {
                    maxQueue.poll();
                }
            } 
            res = Math.max(res, r - l + 1);
            r += 1;
        }
        return res;
    }
}
