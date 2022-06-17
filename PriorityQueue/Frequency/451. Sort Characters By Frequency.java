class Solution {
    public String frequencySort(String s) {
        char[] charArr = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char i: charArr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        pq.addAll(map.entrySet());
        
        StringBuilder sb = new StringBuilder();
        
        while (!pq.isEmpty()) {
            Map.Entry tmp = pq.poll();
            for (int i = 0; i < (int)tmp.getValue(); i ++) {
                sb.append(tmp.getKey());
            }
        }
        return sb.toString();
    }
}
