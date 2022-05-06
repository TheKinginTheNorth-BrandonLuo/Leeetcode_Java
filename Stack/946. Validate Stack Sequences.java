class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int N = popped.length, i = 0;
        
        for (int p: pushed) {
            stack.push(p);
            while (!stack.empty() && i < N && stack.peek() == popped[i]) {
                i += 1;
                stack.pop();
            }
        }
        return stack.empty();
    }
}
