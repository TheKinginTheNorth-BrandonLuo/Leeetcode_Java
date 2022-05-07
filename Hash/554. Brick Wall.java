class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> count = new HashMap<>();
        count.put(0, 0);
        
        for (int i = 0; i < wall.size(); i ++) {
            int total = 0;
            for (int j = 0; j < wall.get(i).size() - 1; j ++) {
                total += wall.get(i).get(j);
                count.put(total, count.getOrDefault(total, 0) + 1);
            }
        }
        int maxValueInMap = (Collections.max(count.values()));
        return wall.size() - maxValueInMap;
    }
}
