class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> res = new ArrayList<>();
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();
        Stack<String> stack = new Stack<>();
        
        for (List<String> list: tickets) {
            if (!map.containsKey(list.get(0))) {
                map.put(list.get(0), new PriorityQueue<String>());
            }
            map.get(list.get(0)).offer(list.get(1));
        }
        
        stack.push("JFK");
        
        while (!stack.empty()) {
            String next = stack.peek();
            if (map.containsKey(next) && map.get(next).size() > 0) {
                stack.push(map.get(next).poll());
            }
            else {
                res.add(0, stack.pop());
            }
        }
        return res;
    }
}
