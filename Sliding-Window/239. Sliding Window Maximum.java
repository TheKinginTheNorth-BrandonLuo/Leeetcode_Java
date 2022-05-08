class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int l = 0, r = 0;
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> q = new ArrayDeque<>();
        int index = 0;
        
        while (r < nums.length) {
            while (!q.isEmpty() && nums[q.peekLast()] < nums[r]) {
                q.pollLast();
            }
            
            q.offer(r);
            
            if (l > q.peekFirst()) {
                q.poll();
            }
            
            if (r + 1 >= k) {
                res[index ++] = nums[q.peek()];
                l += 1;
            }
            r += 1;
        }
        return res;
    }
}
