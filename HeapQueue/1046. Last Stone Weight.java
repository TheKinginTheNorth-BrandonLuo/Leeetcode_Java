class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int s: stones) {
            maxHeap.offer(s);
        }
        while (maxHeap.size() > 1) {
            maxHeap.offer(maxHeap.poll() - maxHeap.poll());
        }
        return maxHeap.poll();
    }
}
