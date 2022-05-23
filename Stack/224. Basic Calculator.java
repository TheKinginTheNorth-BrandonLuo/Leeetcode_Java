class Solution {
    public int calculate(String s) {
        int output = 0, cur = 0, sign = 1;
        Stack<Integer> stack = new Stack<>();
        
        for (char c: s.toCharArray()) {
            if (Character.isDigit(c)) {
                cur = 10 * cur + (int)(c - '0');
            }
            else if (c == '+') {
                output += cur * sign;
                cur = 0;
                sign = 1;
            }
            else if (c == '-') {
                output += cur * sign;
                cur = 0;
                sign = -1;
            }
            else if (c == '(') {
                stack.push(output);
                stack.push(sign);
                output = 0;
                sign = 1;
            }
            else if (c == ')') {
                output += cur * sign;
                output *= stack.pop();
                output += stack.pop();
                cur = 0;
            }
        }
        return output + cur * sign;
    }
}
