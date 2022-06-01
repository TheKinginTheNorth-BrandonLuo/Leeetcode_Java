class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[][] visited = new boolean[s1.length() + 1][s2.length() + 1];
        visited[0][0] = true;
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {0, 0});
        
        while (!stack.isEmpty()) {
            int[] indices = stack.pop();
            int i = indices[0], j = indices[1];
            if (i + j == s3.length()) {
                return true;
            }
            
            if (i + 1 <= s1.length() && s1.charAt(i) == s3.charAt(i + j)) {
                int[] a1 = new int[] {i + 1, j};
                if (!visited[i + 1][j]) {
                    stack.push(new int[] {i + 1, j});
                    visited[i + 1][j] = true;
                }
            }
            if (j + 1 <= s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
                int[] a2 = new int[] {i, j + 1};
                if (!visited[i][j + 1]) {
                    stack.push(new int[] {i, j + 1});
                    visited[i][j + 1] = true;
                }  
            }
        }
        return false;
    }
}
