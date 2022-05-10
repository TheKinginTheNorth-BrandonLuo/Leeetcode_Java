class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> setJ = new HashSet<>();
        for (char c: jewels.toCharArray()) {
            setJ.add(c);
        }
        
        int sum = 0;
        
        for (char s: stones.toCharArray()) {
            if (setJ.contains(s)) {
                sum += 1;
            }
        }
        return sum;
    }
}
