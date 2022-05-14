class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> sCount = new HashMap<>();
        HashMap<Character, Integer> pCount = new HashMap<>();
        
        List<Integer> res = new ArrayList<>();
        
        if (p.length() > s.length()) {
            return res;
        }
        
        for (int i = 0; i < p.length(); i ++) {
            sCount.put(s.charAt(i), sCount.getOrDefault(s.charAt(i), 0) + 1);
            pCount.put(p.charAt(i), pCount.getOrDefault(p.charAt(i), 0) + 1);
        }
        
        if (sCount.equals(pCount)) {
            res.add(0);
        }
        
        int l = 0;
        
        for (int r = p.length(); r < s.length(); r ++) {
            sCount.put(s.charAt(r), sCount.getOrDefault(s.charAt(r), 0) + 1);
            sCount.put(s.charAt(l), sCount.getOrDefault(s.charAt(l), 0) - 1);
            
            if (sCount.get(s.charAt(l)) == 0) {
                sCount.remove(s.charAt(l));
            }
            l += 1;
            if (sCount.equals(pCount)) {
                res.add(l);
            }
        }
        return res;
    }
}
