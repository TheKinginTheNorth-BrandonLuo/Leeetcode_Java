class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int[][] diffs = new int[costs.length][3];
        for (int i = 0; i < costs.length; i ++) {
            diffs[i][0] = costs[i][1] - costs[i][0];
            diffs[i][1] = costs[i][0];
            diffs[i][2] = costs[i][1];
        }
        
        int res = 0;
        Arrays.sort(diffs, (a, b) -> (a[0] - b[0]));
        
        for (int i = 0; i < diffs.length; i ++) {
            if (i < diffs.length / 2) {
                res += diffs[i][2];
            }
            else {
                res += diffs[i][1];
            }
        }
        return res;
    }
}
