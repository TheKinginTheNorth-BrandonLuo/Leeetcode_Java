class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> sortedList = new ArrayList<>();
        int[] arr = new int[nums.length];
        
        for (int i = nums.length - 1; i >= 0; i --) {
            arr[i] = binarySearch(nums[i], 0, sortedList.size(), sortedList);
        }
        List<Integer> res = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i ++) {
            res.add(arr[i]);
        }
        
        return res;
    }
    
    private int binarySearch(int cur, int left, int right, List<Integer> list) {
        int mid = (left + right) / 2;
        if(left >= right){
            list.add(mid, cur);
            return mid;
        }
        
        if (cur <= list.get(mid)){
            return binarySearch(cur, left, mid, list);
        }
        else {
            return binarySearch(cur, mid + 1, right, list);
        }
    }
}
