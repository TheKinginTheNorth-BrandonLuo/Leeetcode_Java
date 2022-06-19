class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i ++) {
            map.putIfAbsent(equations.get(i).get(0), new HashMap<>());
            map.putIfAbsent(equations.get(i).get(1), new HashMap<>());
            map.get(equations.get(i).get(0)).put(equations.get(i).get(1), values[i]);
            map.get(equations.get(i).get(1)).put(equations.get(i).get(0), 1 / values[i]);
        }
        
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i ++) {
            res[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet<String>(), map);
        }
        
        return res;
    }
    
    private double dfs(String x, String y, HashSet<String> visited, HashMap<String, HashMap<String, Double>> map) {
        if (!map.containsKey(x) || !map.containsKey(y)) {
            return -1;
        }
        
        HashMap<String, Double> xMap = map.get(x);
        if (xMap.containsKey(y)) {
            return xMap.get(y);
        }
        
        for (String s : xMap.keySet()) {
            if (!visited.contains(s)) {
                visited.add(s);
                double tmp = dfs(s, y, visited, map);
                if (tmp == -1) {
                    continue;
                }
                else {
                    return tmp * xMap.get(s);
                }
            }
        }
        return -1;
    }
}
