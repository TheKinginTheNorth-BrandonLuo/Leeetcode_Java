class Solution {
    public List<Integer> getRow(int rowIndex) {
        int[] arr = new int[rowIndex + 1];
        arr[0] = 1;
        
        for (int i = 1; i <= rowIndex; i ++) {
            for (int j = i; j > 0; j --) {
                arr[j] += arr[j - 1];
            }
        }
        
        List<Integer> res = new ArrayList<>();
        for (int a: arr) {
            res.add(a);
        }
        return res;
    }
}
