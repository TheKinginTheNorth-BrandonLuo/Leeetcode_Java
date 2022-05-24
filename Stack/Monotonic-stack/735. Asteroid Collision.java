class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int a: asteroids) {
            while (!stack.empty() && stack.peek() > 0 && a < 0) {
                int diff = a + stack.peek();
                
                if (diff > 0) {
                    a = 0;
                }
                else if (diff < 0) {
                    stack.pop();
                }
                else {
                    a = 0;
                    stack.pop();
                }
            }
            if (a != 0) {
                stack.push(a);
            }
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }
}
