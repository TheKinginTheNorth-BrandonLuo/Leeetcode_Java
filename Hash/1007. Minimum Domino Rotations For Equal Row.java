class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        if (tops.length != bottoms.length) {
            return -1;
        }
        
        HashMap<Integer, Integer> mutualMap = new HashMap<>();
        HashMap<Integer, Integer> topMap = new HashMap<>();
        HashMap<Integer, Integer> bottomMap = new HashMap<>();
        
        for (int t: tops) {
            topMap.put(t, topMap.getOrDefault(t, 0) + 1);
        }
        for (int b: bottoms) {
            bottomMap.put(b, bottomMap.getOrDefault(b, 0) + 1);
        }
        
        for (int i = 0; i < tops.length; i ++) {
            if (tops[i] == bottoms[i]) {
                mutualMap.put(tops[i], mutualMap.getOrDefault(tops[i], 0) + 1);
            }
        }
        
        for (int i = 0; i < 7; i ++) {
            if (topMap.containsKey(i) && bottomMap.containsKey(i) && mutualMap.containsKey(i) && topMap.get(i) + bottomMap.get(i) - mutualMap.get(i) == tops.length) {
                return Math.min(topMap.get(i), bottomMap.get(i)) - mutualMap.get(i);
            } else if (topMap.containsKey(i) && bottomMap.containsKey(i) && !mutualMap.containsKey(i) && topMap.get(i) + bottomMap.get(i) == tops.length) {
                return Math.min(topMap.get(i), bottomMap.get(i));
            }
        }
        return -1;
    }
}
