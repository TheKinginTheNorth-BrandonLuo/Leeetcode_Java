class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i: hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
        for (int key: map.keySet()) {
            minHeap.offer(key);
        }
        
        while (!minHeap.isEmpty()) {
            int start = minHeap.peek();
            for (int i = start; i < start + groupSize; i ++) {
                if (!map.containsKey(i)) {
                    return false;
                }
                map.put(i, map.getOrDefault(i, 0) - 1);
                if (map.get(i) == 0) {
                    if (i != minHeap.peek()) {
                        return false;
                    }
                    minHeap.poll();
                }
            }
        }
        return true;
    }
}
