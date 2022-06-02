class Solution {
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks == null || matchsticks.length < 4) {
            return false;
        }
        int sum = 0;
        for (int i: matchsticks) {
            sum += i;
        }
        if (sum % 4 != 0) {
            return false;
        }
        int edgeLength = sum / 4;
        int[] sides = new int[4];
        int[] sortedMatchsticks = Arrays.stream(matchsticks)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
        return backtrack(0, sortedMatchsticks, sides, edgeLength);
    }
    
    private boolean backtrack(int i, int[] matchsticks, int[] sides, int edgeLength) {
        if (i == matchsticks.length) {
            return true;
        }
        for (int j = 0; j < 4; j ++) {
            if (sides[j] + matchsticks[i] <= edgeLength) {
                sides[j] += matchsticks[i];
                if (backtrack(i + 1, matchsticks, sides, edgeLength)) {
                    return true;
                }
                sides[j] -= matchsticks[i];
            }
        }
        return false;
    }
}
