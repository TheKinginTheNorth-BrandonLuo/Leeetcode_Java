class Solution {
    int res = 0;
    public int minReorder(int n, int[][] connections) {
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        for (int[] row: connections) {
            if (!map.containsKey(row[0])) {
                map.put(row[0], new ArrayList<>());
            }
            if (!map.containsKey(row[1])) {
                map.put(row[1], new ArrayList<>());
            }
            map.get(row[0]).add(new int[]{row[1], 1});
            map.get(row[1]).add(new int[]{row[0], 0});
        }
        
        HashSet<Integer> visited = new HashSet<>();
        
        dfs(0, map, visited);
        return res;
    }
    
    private void dfs(int city, HashMap<Integer, List<int[]>> map, HashSet<Integer> visited) {
        visited.add(city);
        for (int i = 0; i < map.get(city).size(); i ++) {
            if (!visited.contains(map.get(city).get(i)[0])) {
                visited.add(map.get(city).get(i)[0]);
                res += map.get(city).get(i)[1];
                dfs(map.get(city).get(i)[0], map, visited);
            }
        }
    }
}
