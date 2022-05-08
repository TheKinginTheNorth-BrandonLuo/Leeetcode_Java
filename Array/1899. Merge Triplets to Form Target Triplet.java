class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int a = 0, b = 0, c = 0;
        
        for (int i = 0; i < triplets.length; i ++) {
            if (triplets[i][0] <= target[0] && triplets[i][1] <= target[1] && triplets[i][2] <= target[2]) {
                a = Math.max(a, triplets[i][0]);
                b = Math.max(b, triplets[i][1]);
                c = Math.max(c, triplets[i][2]);
            }
        }
        return a == target[0] && b == target[1] && c == target[2];
    }
}
