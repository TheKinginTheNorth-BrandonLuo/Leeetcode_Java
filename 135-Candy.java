class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] res = new int[n];
        
        for (int i = 0; i < n; i ++) {
            res[i] = 1;
        }
        
        for (int i = 0; i < n - 1; i ++) {
            if (ratings[i] < ratings[i + 1]) {
                res[i + 1] = 1 + res[i];
            }
        }
        
        for (int i = n - 2; i >= 0; i --) {
            if (ratings[i + 1] < ratings[i]) {
                res[i] = Math.max(res[i], 1 + res[i + 1]);
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i ++) {
            sum += res[i];
        }
        return sum;
    }
}
