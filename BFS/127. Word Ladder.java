class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for (String s: wordList) {
            set.add(s);
        }
        if (!set.contains(endWord)) {
            return 0;
        }
        
        HashMap<String, List<String>> map = new HashMap<>();
        for (String word: set) {
            for (int i = 0; i < word.length(); i ++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
                if (!map.containsKey(pattern)) {
                    map.put(pattern, new ArrayList<>());
                }
                map.get(pattern).add(word);
            } 
        }
        
        int res = 1;
        Deque<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        HashSet<String> visited = new HashSet<>();
        visited.add(beginWord);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i ++) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return res;
                }
                for (int j = 0; j < word.length(); j ++) {
                    String pattern = word.substring(0, j) + "*" + word.substring(j + 1);
                    if (map.containsKey(pattern)) {
                        for (String neiWord: map.get(pattern)) {
                            if (!visited.contains(neiWord)) {
                                visited.add(neiWord);
                                queue.offer(neiWord);
                            }
                        }
                    }
                    
                }
            }
            res += 1;
        }
        return 0;
    }
}
