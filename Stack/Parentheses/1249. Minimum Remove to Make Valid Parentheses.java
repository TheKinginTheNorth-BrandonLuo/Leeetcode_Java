class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < sb.length(); i ++) {
            if (sb.charAt(i) == '(') {
                stack.add(i);
            } else if (sb.charAt(i) == ')') {
                if (!stack.empty()) {
                    stack.pop();
                } else {
                    sb.setCharAt(i, '*');
                }
            }
        }
        
        while (!stack.empty()) {
            sb.setCharAt(stack.pop(), '*');
        }
        
        return sb.toString().replaceAll("\\*", "");
    }
}
// python version is a little different

// class Solution:
//     def minRemoveToMakeValid(self, s):
//         s = list(s)
//         stack = []
        
//         for i, char in enumerate(s):
//             if char == "(":
//                 stack.append(i)
//             elif char == ")":
//                 if stack:
//                     stack.pop()
//                 else:
//                     s[i] = ""
//         while stack:
//             s[stack.pop()] = ""
        
//         return "".join(s)
