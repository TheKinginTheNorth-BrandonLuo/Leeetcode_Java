class Solution {
    public int longestStrChain(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        Arrays.sort(words, (a, b) -> (a.length() - b.length()));
        int res = 0;
        
        for (String word: words) {
            int cur = 1;
            for (int i = 0; i < word.length(); i ++) {
                String tmp = word.substring(0, i) + word.substring(i + 1);
                if (map.containsKey(tmp)) {
                    cur = Math.max(cur, map.get(tmp) + 1);
                }
            }
            map.put(word, cur);
            res = Math.max(res, cur);
        }
        return res;
    }
}
