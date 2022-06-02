class Solution {
    int res = 0;
    public int countArrangement(int n) {
        boolean[] visited = new boolean[n + 1];
        backtrack(n, 1, visited);
        return res;
    }
    
    private void backtrack(int n, int pos, boolean[] visited) {
        if (pos > n) {
            res += 1;
        }
        for (int i = 1; i <= n; i ++) {
            if (!visited[i] && (pos % i == 0 || i % pos == 0)) {
                visited[i] = true;
                backtrack(n, pos + 1, visited);
                visited[i] = false;
            }
        }
    }
}
