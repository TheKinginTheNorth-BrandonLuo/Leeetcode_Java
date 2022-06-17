class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i: nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        
        for (Map.Entry entry: map.entrySet()) {
            int key = (int)entry.getKey();
            int val = (int)entry.getValue();
            pq.offer(new int[]{key, val});
        }
        
        int[] res = new int[k];
        int index = 0;
        
        while (index < k) {
            int[] tmp = pq.poll();
            res[index] = tmp[0];
            index ++;
        }
        
        return res;
    }
}
