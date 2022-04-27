class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        
        while (!stack.isEmpty()) {
            int r = stack.pop();
            visited.add(r);
            
            for (int key: rooms.get(r)) {
                if (!visited.contains(key)) {
                    stack.add(key);
                }
            }
        }
        return rooms.size() == visited.size();
        
    }
}
