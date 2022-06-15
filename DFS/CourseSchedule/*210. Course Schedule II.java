class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> courses = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i ++) {
            courses.add(new ArrayList<>());
        }
        
        for (int i = 0 ; i < prerequisites.length; i ++) {
            courses.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        HashMap<Integer, Integer> visited = new HashMap<>();
        for (int i = 0; i < numCourses; i ++) {
            visited.put(i, 0); // 0 -> unvisited, 1 -> visiting, 2 -> visited
        }
        List<Integer> res = new ArrayList<>();
        
        for (int i = 0; i < numCourses; i ++) {
            if (!topoSort(i, courses, visited, res)) {
                return new int[0];
            }
        }
            
        int[] result=  new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            result[i] = res.get(numCourses - i - 1);
        }
        return result;
    }
    
    private boolean topoSort(int course, List<List<Integer>> courses, HashMap<Integer, Integer> visited, List<Integer> res) {
        int visit = visited.get(course);
        if (visit == 2) {
            return true;
        }
        if (visit == 1) {
            return false;
        }
        
        visited.put(course, 1);
        for (int j: courses.get(course)) {
            if (!topoSort(j, courses, visited, res)) {
                return false;
            }
        }
        visited.put(course, 2);
        res.add(course);
        return true;
    }
}
