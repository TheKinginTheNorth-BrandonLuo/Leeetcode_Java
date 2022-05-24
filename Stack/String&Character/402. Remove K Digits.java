class Solution {
    public String removeKdigits(String num, int k) {
        int i = 0, n = num.length();
        
        if (k >= n) {
            return "0";
        }
        
        Stack<Character> stack = new Stack<>();
        
        while (i < n) {
            while (!stack.empty() && k > 0 && stack.peek() > num.charAt(i)) {
                stack.pop();
                k -= 1;
            }
            stack.push(num.charAt(i));
            i += 1;
        }
        
        while (k > 0) {
            stack.pop();
            k -= 1;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.insert(0, stack.pop());
        }
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
