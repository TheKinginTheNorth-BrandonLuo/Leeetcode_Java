class Solution {
    public int calculate(String s) {
        int output = 0, cur = 0, sign = '+';
        s = s + '+';
        Stack<Integer> stack = new Stack<>();
        
        for (char c: s.toCharArray()) {
            if (Character.isDigit(c)) {
                cur = 10 * cur + (int)(c - '0');
            }
            else if (c == '+' || c == '-' || c == '*' || c == '/') {
                if (sign == '+') {
                    stack.push(cur);
                }
                else if (sign == '-') {
                    stack.push(-cur);
                }
                else if (sign == '*') {
                    stack.push(stack.pop() * cur);
                }
                else if (sign == '/') {
                    stack.push(stack.pop() / cur);
                }
                cur = 0;
                sign = c;
            }
        }
        while (!stack.empty()) {
            output += stack.pop();
        }
        return output;
    }
}
