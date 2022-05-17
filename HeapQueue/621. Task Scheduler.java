class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c: tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        for (int cnt: map.values()) {
            maxHeap.offer(-cnt);
        }
        int totalTime = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        
        while (!queue.isEmpty() || !maxHeap.isEmpty()) {
            totalTime += 1;
            if (!maxHeap.isEmpty()) {
                int cnt = 1 + maxHeap.poll();
                if (cnt != 0) {
                    int[] arr = new int[2];
                    arr[0] = cnt;
                    arr[1] = totalTime + n;
                    queue.add(arr);
                }
            }
            if (!queue.isEmpty() && queue.peek()[1] == totalTime) {
                maxHeap.offer(queue.pollFirst()[0]);
            }
        }
        return totalTime;
    }
}
