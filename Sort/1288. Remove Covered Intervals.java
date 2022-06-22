class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int res = 0, right = 0;
        Arrays.sort(intervals, (a, b) -> (a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]));
        
        for (int[] interval : intervals) {
            if (interval[1] > right) {
                res ++;
                right = interval[1];
            }
        }
        return res;
    }
}
