class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }
        
        List<List<Integer>> courses = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i ++) {
            courses.add(new ArrayList<>());
        }
        
        for (int i = 0 ; i < prerequisites.length; i ++) {
            courses.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i ++) {
            if (!dfs(i, courses, visited)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean dfs(int course, List<List<Integer>> courses, int[] visited) {
        visited[course] = 1; // mark as visited
        List<Integer> childrenCourses = courses.get(course); // get its children
        
        for (int i = 0; i < childrenCourses.size(); i ++) {
            int childrenCourse = childrenCourses.get(i);
            if (visited[childrenCourse] == 1) {
                return false;
            }
            if (visited[childrenCourse] == 0) {
                if (!dfs(childrenCourse, courses, visited)) {
                    return false;
                }
            }
        }
        
        visited[course] = 2; // mark as done visiting
        return true;
    }
}
