class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        for (String root: path.split("/")) {
            if (root.equals("") || root.equals(".")) {
                continue;
            }
            if (root.equals("..")) {
                if (!stack.empty()) {
                    stack.pop();
                }
            }
            else {
                stack.push(root);
            }
        }
        return "/" + String.join("/", stack);
    }
}
