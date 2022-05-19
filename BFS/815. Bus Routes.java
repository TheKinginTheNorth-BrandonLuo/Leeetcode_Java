class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i ++) {
            for (int j: routes[i]) {
                if (!map.containsKey(j)) {
                    map.put(j, new HashSet<Integer>());
                }
                map.get(j).add(i);
            }
        }
        
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{source, 0});
        HashSet<Integer> visited = new HashSet<>();
        boolean[] seen = new boolean[routes.length];
        
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int stop = tmp[0], bus = tmp[1];
            
            if (stop == target) {
                return bus;
            }
            
            for (int i: map.get(stop)) {
                if (seen[i]) {
                    continue;
                }
                for (int j: routes[i]) {
                    if (!visited.contains(j)) {
                        queue.offer(new int[]{j, bus + 1});
                        visited.add(j);
                    }
                }
                seen[i] = true;
            }
        }
        return -1;
    }
}
