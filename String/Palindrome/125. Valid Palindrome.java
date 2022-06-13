class Solution {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            char head = s.charAt(left), tail = s.charAt(right);
            if (!Character.isLetterOrDigit(head)) {
                left ++;
            }
            else if (!Character.isLetterOrDigit(tail)) {
                right --;
            }
            else {
                if (Character.toLowerCase(head) != Character.toLowerCase(tail)) {
                    return false;
                }
                left ++;
                right --;
            }
        }
        return true;
        
    }
}
