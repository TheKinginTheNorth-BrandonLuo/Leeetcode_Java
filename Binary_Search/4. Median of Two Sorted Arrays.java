class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int len = m + n;
        if (len % 2 == 0) {
            double leftMid = (double)getKth(nums1, 0, nums2, 0, len / 2);
            double rightMid = (double)getKth(nums1, 0, nums2, 0, len / 2 + 1);
            return (double)(leftMid + rightMid) / 2;
        }
        else {
            return getKth(nums1, 0, nums2, 0, len / 2 + 1);
        }
    }
    
    private int getKth(int[] A, int aStart, int[] B, int bStart, int k) {
        if (aStart >= A.length) {
            return B[bStart + k - 1];
        }
        if (bStart >= B.length) {
            return A[aStart + k - 1];
        }
        if (k == 1) {
            return Math.min(A[aStart], B[bStart]);
        }
        int aMid = aStart + k / 2 - 1;
        int bMid = bStart + k / 2 - 1;
        
        int aVal = aMid >= A.length ? Integer.MAX_VALUE : A[aMid];
        int bVal = bMid >= B.length ? Integer.MAX_VALUE : B[bMid];
        
        if (aVal <= bVal) {
            return getKth(A, aMid + 1, B, bStart, k - k / 2);
        }
        else {
            return getKth(A, aStart, B, bMid + 1, k - k / 2);
        }
    }
}
