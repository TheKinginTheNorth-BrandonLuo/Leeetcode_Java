class Solution {
    public String smallestSubsequence(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i ++) {
            map.put(s.charAt(i), i);
        }
        
        Stack<Character> stack = new Stack<>();
        HashSet<Character> visited = new HashSet<>();
        
        for (int i = 0; i < s.length(); i ++) {
            if (visited.contains(s.charAt(i))) {
                continue;
            }
            
            while (!stack.empty() && stack.peek() > s.charAt(i) && map.get(stack.peek()) > i) {
                visited.remove(stack.peek());
                stack.pop();
            }
            stack.push(s.charAt(i));
            visited.add(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}
