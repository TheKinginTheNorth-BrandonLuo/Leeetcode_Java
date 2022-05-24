class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Character> charStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        
        for (char c: s.toCharArray()) {
            if (charStack.size() > 0 && charStack.peek() == c) {
                countStack.push(countStack.peek() + 1);
            }
            else {
                countStack.push(1);
            }
            charStack.push(c);
            
            if (countStack.peek() == k) {
                for (int i = 0; i < k; i ++) {
                    charStack.pop();
                    countStack.pop();
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!charStack.empty()) {
            sb.insert(0, charStack.pop());
        }
        return sb.toString();
    }
}
