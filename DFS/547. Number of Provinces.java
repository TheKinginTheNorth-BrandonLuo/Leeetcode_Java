// This one also has another solution in stack
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int[] visited = new int[isConnected.length];
        // mark visited as 0 -> not visited
        Arrays.fill(visited, 0);
        int count = 0;
        
        for (int i = 0; i < isConnected.length; i ++) {
            if (visited[i] == 0) {
                dfs(isConnected, visited, i);
                count += 1;
            }
        }
        return count;
    }
    
    private void dfs(int[][] isConnected, int[] visited, int i) {
        
        for (int j = 0; j < isConnected.length; j ++) {
            if (visited[j] == 0 && isConnected[i][j] == 1) {
                visited[j] = 1;
                dfs(isConnected, visited, j);
            }
        }
    }
}
