class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0, start = 0;
        
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }
            else {
                if (stack.empty()) {
                    start = i + 1;
                }
                else {
                    stack.pop();
                    if (stack.empty()) {
                        res = Math.max(res, i - start + 1);
                    }
                    else {
                        res = Math.max(res, i - stack.peek());
                    }
                }
            }
        }
        return res;
    }
}
