// Can't use HashMap. Must use array
class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] countText = new int[26];
        int[] countBalloon = new int[26];
        
        for (char c: text.toCharArray()) {
            countText[c - 'a'] += 1;
        }
        
        for (char c: "balloon".toCharArray()) {
            countBalloon[c - 'a'] += 1;
        }
        int min = text.length();
        for (char c: "balloon".toCharArray()) {
            min = Math.min(min, countText[c - 'a'] / countBalloon[c - 'a']);
        }
        return min;
    }
}
