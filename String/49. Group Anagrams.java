class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        
        for (String s: strs) {
            char[] charArray = new char[26];
            for (char c: s.toCharArray()) {
                charArray[c - 'a'] ++;
            }
            String keyString = String.valueOf(charArray);
            if (!map.containsKey(keyString)) {
                map.put(keyString, new ArrayList<>());
            }
            map.get(keyString).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
