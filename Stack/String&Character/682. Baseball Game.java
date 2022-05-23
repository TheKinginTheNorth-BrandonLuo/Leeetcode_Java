class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        // note we can't just sum(stack)
        // paye attention to "" and ''!!!!!!!!!
        int res = 0;
        for (String c: ops) {
            if (c.equals("+")) {
                int second = stack.peek();
                stack.pop();
                int first = stack.peek();
                int sum = first + second;
                stack.push(second);
                stack.push(sum);
                res += sum;
            } else if (c.equals("D")){
                stack.push(stack.peek() * 2);
                res += stack.peek();
            } else if (c.equals("C")) {
                res -= stack.pop();
            } else {
                stack.push(Integer.parseInt(c));
                res += stack.peek();
            }
        }
        return res;
    }
}
