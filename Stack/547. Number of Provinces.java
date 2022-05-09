class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length, res = 0;
        HashSet<Integer> visited = new HashSet<>();
        
        for (int i = 0; i < n; i ++) {
            if (visited.contains(i)) {
                continue;
            }
            Stack<Integer> stack = new Stack<>();
            stack.add(i);
            visited.add(i);
            res += 1;
            
            while (!stack.empty()) {
                int cur = stack.pop();;
                for (int j = 0; j < n; j ++) {
                    if (!visited.contains(j) && isConnected[cur][j] == 1) {
                        stack.add(j);
                        visited.add(j);
                    }
                }
            }
        }
        return res;
    }
}
