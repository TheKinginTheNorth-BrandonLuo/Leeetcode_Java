class Solution {
    public String pushDominoes(String dominoes) {
        char[] dom = dominoes.toCharArray();
        Deque<Pair<Integer, Character>> queue = new ArrayDeque<>();
        for (int i = 0; i < dom.length; i ++) {
            if (dom[i] != '.') {
                queue.offer(new Pair(i, dom[i]));
            }
        }
        
        while (!queue.isEmpty()) {
            Pair<Integer, Character> temp = queue.poll();
            int i = temp.getKey();
            char c = temp.getValue() ;
            if (c == 'L' && i > 0 && dom[i - 1] == '.') {
                queue.offer(new Pair(i - 1, 'L'));
                dom[i - 1] = 'L';
            }
            else if (c == 'R') {
                if (i + 1 < dom.length && dom[i + 1] == '.') {
                    if (i + 2 < dom.length && dom[i + 2] == 'L') {
                        queue.poll();
                    }
                    else {
                        queue.offer(new Pair(i + 1, 'R'));
                        dom[i + 1] = 'R';
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c: dom) {
            sb.append(c);
        }
        return sb.toString();
    }
}
