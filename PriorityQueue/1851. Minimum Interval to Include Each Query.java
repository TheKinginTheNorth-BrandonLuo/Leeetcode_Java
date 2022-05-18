class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int i = 0;
        int[] Q = queries.clone();
        Arrays.sort(queries);
        
        for (int q: queries) {
            while (i < intervals.length && intervals[i][0] <= q) {
                minHeap.offer(new int[] {intervals[i][1] - intervals[i][0]+1, intervals[i][1]});
                i += 1;
            }
            while (!minHeap.isEmpty() && minHeap.peek()[1] < q) {
                minHeap.poll();
            }
            map.put(q, minHeap.isEmpty() ? -1 : minHeap.peek()[0]);
        }
        int[] ans = new int[queries.length];
        i = 0;
        for (int q: Q) {
            ans[i ++] = map.get(q);
        }
        return ans;
    }
}
