class Solution {
    public String decodeString(String s) {
        Stack<Integer> intStack = new Stack<>();
        Stack<String> stack = new Stack<>();
        int i = 0;
        stack.push("");
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                int start = i;
                while (s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
                    i += 1;
                }
                intStack.push(Integer.parseInt(s.substring(start, i + 1)));
            }
            else if (c == '[') {
                stack.push("");
            }
            else if (c == ']') {
                String temp = stack.pop();
                int times = intStack.pop();
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < times; j ++) {
                    sb.append(temp);
                }
                stack.push(stack.pop() + sb.toString());
            }
            else {
                stack.push(stack.pop() + c);
            }
            i += 1;
        }
        return stack.pop();
    }
}
