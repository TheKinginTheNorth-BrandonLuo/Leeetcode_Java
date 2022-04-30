/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int l = 0, r = n - 1;
        
        while (l < r) {
            int m = (l + r) / 2;
            if (mountainArr.get(m) < mountainArr.get(m + 1)) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        int peak = l;
        if (mountainArr.get(peak) == target) {
            return peak;
        }
        
        l = 0;
        r = peak - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            int cur = mountainArr.get(m);
            if (cur == target) {
                return m;
            } else if (cur > target){
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        
        l = peak + 1;
        r = n - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            int cur = mountainArr.get(m);
            if (cur == target) {
                return m;
            } else if (cur > target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }
}
