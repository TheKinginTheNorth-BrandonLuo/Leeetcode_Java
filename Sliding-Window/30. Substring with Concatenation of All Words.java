class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        int m = words.length;
        int n = words[0].length();
        List<Integer> res = new ArrayList<>();
        
        for (String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        for (int k = 0; k < n; k ++) {
            int l = k;
            HashMap<String, Integer> subd = new HashMap<>();
            int count = 0;
            
            for (int j = k; j < s.length() - n + 1; j += n) {
                String w = s.substring(j, j + n);
                if (map.containsKey(w)) {
                    subd.put(w, subd.getOrDefault(w, 0) + 1);
                    count += 1;
                    while (subd.get(w) > map.get(w)) {
                        subd.put(s.substring(l, l + n), subd.getOrDefault(s.substring(l, l + n), 0) - 1);
                        l += n;
                        count -= 1;
                    }
                    if (count == m) {
                        res.add(l);
                    }
                } else {
                    l = j + n;
                    subd = new HashMap<>();
                    count = 0;
                }
            }
        }
        return res;
    }
}
