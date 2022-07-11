class Solution {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        pq.addAll(map.entrySet());
        
        StringBuilder sb = new StringBuilder();
        
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> entry = pq.poll();
            char c1 = entry.getKey();
            int count1 = entry.getValue();
            int len = sb.length();
            if (len > 0 && c1 == sb.charAt(len - 1)) {
                if (pq.isEmpty()) {
                    break;
                }
                Map.Entry<Character, Integer> entry2 = pq.poll();
                char c2 = entry2.getKey();
                int count2 = entry2.getValue();
                sb.append(c2);
                count2 --;
                if (count2 > 0) {
                    entry2.setValue(count2);
                    pq.offer(entry2);
                }
            }
            else {
                sb.append(c1);
                count1 --;
            }
            if (count1 > 0) {
                entry.setValue(count1);
                pq.offer(entry);
            }
        }
        return sb.length() == s.length() ? sb.toString() : "";
    }
}
