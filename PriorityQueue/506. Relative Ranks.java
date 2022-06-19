class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] res = new String[n];
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (score[b] - score[a]));
        
        for (int i = 0; i < n; i ++) {
            pq.offer(i);
        }
        
        int i = 0;
        while (!pq.isEmpty()) {
            int index = pq.poll();
            
            if (i == 0) {
                res[index] = "Gold Medal";
            }
            else if (i == 1) {
                res[index] = "Silver Medal";
            }
            else if (i == 2) {
                res[index] = "Bronze Medal";;
            }
            else if (i >= 3) {
                res[index] = Integer.toString(i + 1);
            }
            i ++;
        }
        
        return res;
    }
}
