class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] strArr = new String[n];
        for (int i = 0; i < n; i ++) {
            strArr[i] = String.valueOf(nums[i]);
        }
        
        for (int i = 0; i < n - 1; i ++) {
            for (int j = i + 1; j < n; j ++) {
                if (Long.parseLong(strArr[i] + strArr[j]) <= Long.parseLong(strArr[j] + strArr[i])) {
                    String temp = strArr[i];
                    strArr[i] = strArr[j];
                    strArr[j] = temp;
                }
            }
        }
        String res = String.join("", strArr);
        return res.charAt(0) == '0' ? "0" : res;
    }
}
