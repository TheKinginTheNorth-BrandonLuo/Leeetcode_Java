class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int n = cardPoints.length;
        // calculate first k cards
        for (int i = 0; i < k; i ++) {
            sum += cardPoints[i];
        }
        int res = sum;
        for (int r = k - 1; r >= 0; r --) {
            sum += cardPoints[r + n - k] - cardPoints[r];
            res = Math.max(res, sum);
        }
        return res;
    }
}
