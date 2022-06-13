class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return new ArrayList<>();
        }
        HashMap<String, List<List<String>>> layer = new HashMap<>();
        layer.put(beginWord, new ArrayList<>());
        layer.get(beginWord).add(new ArrayList<>(Arrays.asList(beginWord)));
        
        while (!layer.isEmpty()) {
            HashMap<String, List<List<String>>> newLayer = new HashMap<>();
            for (String word: layer.keySet()) {
                if (word.equals(endWord)) {
                    return layer.get(word);
                }
                for (int i = 0; i < word.length(); i ++) {
                    for (char c = 'a'; c < 'a' + 26; c ++) {
                        String newWord = word.substring(0, i) + c + word.substring(i + 1);
                        if (!wordSet.contains(newWord)) {
                            continue;
                        }
                        if (!newLayer.containsKey(newWord)) {
                            newLayer.put(newWord, new ArrayList<>());
                        }
                        for (List<String> list: layer.get(word)) {
                            List<String> newList = new ArrayList<>(list);
                            newList.add(newWord);
                            newLayer.get(newWord).add(newList);
                        }
                    }
                }
            }
            layer = newLayer;
            for (String str: newLayer.keySet()){
                wordSet.remove(str);
            }
        }
        return new ArrayList<>();
    }
}
