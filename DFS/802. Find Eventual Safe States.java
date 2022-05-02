class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> res = new ArrayList<>();
        int[] safe = new int[n];
        
        for (int i = 0; i < n; i ++) {
            if (dfs(i, graph, safe)) {
                res.add(i);
            }
        }
        return res;
    }
    
    private boolean dfs(int i, int[][] graph, int[] safe) {
        // 2-safe
        // 1-visiting
        if (safe[i] == 2) {
            return true;
        }
        if (safe[i] == 1) {
            return false;
        }
        safe[i] = 1;
        int[] nei = graph[i];
        
        for (int index = 0; index < nei.length; index ++) {
            if (!dfs(nei[index], graph, safe)) {
                return false;
            }
        }
        safe[i] = 2;
        return true;
    }
}
