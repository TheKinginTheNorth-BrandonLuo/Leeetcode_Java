class Solution {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        int n = arr.length;
        int left = 0, right = n - 1;
        
        while (left < n - 1 && arr[left] < arr[left + 1]) {
            left ++;
        }
        
        while (right > 0 && arr[right] < arr[right - 1]) {
            right --;
        }
        
        return ((left == right) && (left != 0) && (right != n - 1));
    }
}
