class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        HashMap<String, BiFunction<Integer, Integer, Integer>> operations = new HashMap<>();
        operations.put("+", (l, r) -> l + r);
        operations.put("-", (l, r) -> l - r);
        operations.put("*", (l, r) -> l * r);
        operations.put("/", (l, r) -> l / r);
        
        for (String token: tokens) {
            if (operations.get(token) != null) {
                int right = stack.pop();
                int left = stack.pop();
                int res = operations.get(token).apply(left, right);
                stack.push(res);
            } else {
             stack.push(Integer.valueOf(token));   
            }
        }
        return stack.pop();
    }
}
