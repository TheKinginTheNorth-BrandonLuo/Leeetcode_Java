class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int[] factorial = new int[n];
        factorial[0] = 1;
        
        for (int i = 1; i < n; i ++) {
            nums.add(i);
            factorial[i] = factorial[i - 1] * i;
        }
        nums.add(n);
        
        k --;
        
        for (int i = n; i > 0; i --) {
            int idx = k / factorial[i - 1];
            k = k % factorial[i - 1];
            
            sb.append(nums.get(idx));
            nums.remove(idx);
        }
        return sb.toString();
    }
}
