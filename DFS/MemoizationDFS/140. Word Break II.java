class Solution {
    HashMap<String, List<String>> map = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        set.addAll(wordDict);
        
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return map.get(s);
        }
        
        if (set.contains(s)) {
            res.add(s);
        }
        
        for (int i = 1; i < s.length(); i ++) {
            String subString = s.substring(i);
            if (set.contains(subString)) {
                List<String> temp = wordBreak(s.substring(0, i), wordDict);
                if (temp.size() != 0) {
                    for (int j = 0; j < temp.size(); j ++) {
                        res.add(temp.get(j) + " " + subString);
                    }
                }
            }
        }
        map.put(s, res);
        return res;
    }
}
