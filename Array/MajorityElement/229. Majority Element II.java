class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int counter1 = 0;
        int counter2 = 0;
        Integer candidate1 = null;
        Integer candidate2 = null;
        for (int num : nums) {
            if (candidate1 != null && candidate1 == num) {
                counter1++;
            } else if (candidate2 != null && candidate2 == num) {
                counter2++;
            } else if (candidate1 == null || counter1 == 0) {
                candidate1 = num;
                counter1 = 1;
            } else if (candidate2 == null || counter2 == 0) {
                candidate2 = num;
                counter2 = 1;
            } else {
                counter1--;
                counter2--;
            }
        }
        List<Integer> res = new ArrayList<>();
        counter1 = 0;
        counter2 = 0;
        for (int num : nums) {
            if (num == candidate1) counter1++;
            else if (num == candidate2) counter2++;
        }
        if (counter1 > nums.length / 3) res.add(candidate1);
        if (counter2 > nums.length / 3) res.add(candidate2);
        return res;
    }
}
