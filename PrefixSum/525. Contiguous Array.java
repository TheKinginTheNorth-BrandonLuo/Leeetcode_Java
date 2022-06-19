class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int maxLen = 0, cumSum = 0;
        
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] == 0) {
                cumSum -= 1;
            }
            else {
                cumSum += 1;
            }
            
            if (cumSum == 0) {
                maxLen = i + 1;
            }
            else if (map.containsKey(cumSum)) {
                maxLen = Math.max(maxLen, i - map.get(cumSum));
            }
            else {
                map.put(cumSum, i);
            }
        }
        
        return maxLen;
    }
}
