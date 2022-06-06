class Solution {
    public boolean detectCapitalUse(String word) {
        int capitals = 0;
        for (char c: word.toCharArray()) {
            if (Character.isUpperCase(c)) {
                capitals += 1;
            }
        }
        
        if (capitals == 0 || capitals == word.length()) {
            return true;
        }
        return capitals == 1 && Character.isUpperCase(word.charAt(0));
    }
}

class SecondSolution {
    public boolean detectCapitalUse(String word) {
        if (word.length() < 2) {
            return true;
        }
        if (word.toUpperCase().equals(word)) {
            return true;
        }
        if (word.substring(1).toLowerCase().equals(word.substring(1))) {
            return true;
        }
        return false;
    }
}
