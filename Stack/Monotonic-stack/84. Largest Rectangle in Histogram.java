class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int[]h2 = new int[]{0};
        int aLen = heights.length;
        int bLen = h2.length;
        int[] newHeights = new int[aLen + bLen];

        System.arraycopy(heights, 0, newHeights, 0, aLen);
        System.arraycopy(h2, 0, newHeights, aLen, bLen);
        
        for (int i = 0; i < newHeights.length; i ++) {
            while (!stack.empty() && newHeights[stack.peek()] > newHeights[i]) {
                int h = stack.pop();
                h = newHeights[h];
                max = Math.max(max, h *(stack.empty() ? i : i - stack.peek() - 1));
            }
            stack.push(i);
        }
        return max;
    }
}
