class Solution {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        maxHeap.addAll(map.entrySet());
        
        Map.Entry<Character, Integer> prev = null;
        StringBuilder res = new StringBuilder();
        
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> tmpEntry = maxHeap.poll();
            if (prev != null && prev.getValue() > 0) {
                maxHeap.offer(prev);
            }
            res.append((char) tmpEntry.getKey());
            tmpEntry.setValue(tmpEntry.getValue() - 1);
            prev = tmpEntry;
        }
        return (res.length() == s.length()) ? res.toString() : "";
    }
}
