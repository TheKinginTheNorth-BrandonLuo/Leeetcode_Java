class Solution {
    public String findDifferentBinaryString(String[] nums) {
        HashSet<String> set = new HashSet<>();
        for (String s: nums) {
            set.add(s);
        }
        return backtrack(set, "", nums[0].length());
    }
    
    private String backtrack(HashSet<String> set, String s, int n) {
        if (s.length() == n) {
            return (!set.contains(s)) ? s : "";
        }
        String s1 = s + "0";
        String s2 = s + "1";
        String ans1 = backtrack(set, s1, n);
        if (ans1 != "") {
            return ans1;
        }
        String ans2 = backtrack(set, s2, n);
        if (ans2 != "") {
            return ans2;
        }
        return "";
    }
}
