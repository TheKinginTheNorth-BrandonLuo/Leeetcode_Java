class Solution {
    public boolean stoneGame(int[] piles) {
        int l = 0, r = piles.length - 1;
        int alice = 0, bob = 0;
        while (l <= r) {
            alice = Math.max(piles[l], piles[r]);
            l += piles[l] > piles[r] ? 1 : 0;
            r -= piles[l] > piles[r] ? 0 : 1;
            
            alice = Math.max(piles[l], piles[r]);
            l += piles[l] > piles[r] ? 1 : 0;
            r -= piles[l] > piles[r] ? 0 : 1;
        }
        return alice > bob;
    }
}
