class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        
        for (char c: s.toCharArray()) {
            if (c == '(') {
                stack.push(res);
                res = 0;
            }
            else {
                res = stack.pop() + Math.max(2 * res, 1); // case (())
            }
        }
        return res;
    }
}
