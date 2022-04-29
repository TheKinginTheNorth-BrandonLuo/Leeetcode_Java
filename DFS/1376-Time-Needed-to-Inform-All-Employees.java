class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        
        for (int i = 0; i < manager.length; i ++) {
            int j = manager[i];
            if (!graph.containsKey(j)) {
                graph.put(j, new ArrayList<>());
            }
            graph.get(j).add(i);
        }
        return dfs(graph, informTime, headID);
    }
    
    private int dfs(HashMap<Integer, List<Integer>> graph, int[] informTime, int head ) {
        int res = 0;
        if (!graph.containsKey(head))
            return res;
        for (int i = 0; i < graph.get(head).size(); i ++) {
            res = Math.max(res, dfs(graph, informTime, graph.get(head).get(i)) + informTime[head]);
        }
        return res;
    }
}
