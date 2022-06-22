class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) {
            return false;
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        for (int key : map.keySet()) {
            pq.offer(key);
        }
        
        while (!pq.isEmpty()) {
            int start = pq.peek();
            for (int i = start; i < start + k; i ++) {
                if (!map.containsKey(i)) {
                    return false;
                }
                map.put(i, map.getOrDefault(i, 0) - 1);
                if (map.get(i) == 0) {
                    if (i != pq.peek()) {
                        return false;
                    }
                    pq.poll();
                }
            }
        }
        return true;
    }
}
