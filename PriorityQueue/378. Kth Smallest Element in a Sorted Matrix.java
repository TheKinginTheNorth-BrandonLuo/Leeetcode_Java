class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int ROWS = matrix.length, COLS = matrix[0].length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        
        for (int r = 0; r < ROWS; r ++) {
            for (int c = 0; c < COLS; c ++) {
                maxHeap.offer(-matrix[r][c]);
                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }
        }
        return -maxHeap.poll();
    }
}
