class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        int[] nums = new int[10];
        
        for (int i = 0; i < secret.length(); i ++) {
            int s = Character.getNumericValue(secret.charAt(i));
            int g = Character.getNumericValue(guess.charAt(i));
            if (s == g) {
                bulls += 1;
            }
            else {
                if (nums[s] < 0) {
                    cows += 1;
                }
                if (nums[g] > 0) {
                    cows += 1;
                }
                nums[s] += 1;
                nums[g] -= 1;
            }
        }
        return bulls + "A" + cows + "B";
    }
}
