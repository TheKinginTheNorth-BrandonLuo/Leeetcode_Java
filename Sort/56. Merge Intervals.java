class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        List<int[]> res = new ArrayList<>();
        
        int[] tmpInterval = intervals[0];
        res.add(tmpInterval);
        
        for (int i = 0; i < intervals.length; i ++) {
            if (intervals[i][0] <= tmpInterval[1]) {
                tmpInterval[1] = Math.max(tmpInterval[1], intervals[i][1]);
            }
            else {
                tmpInterval = intervals[i];
                res.add(tmpInterval);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
