class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> deadEnds = new HashSet<>(Arrays.asList(deadends));
        HashSet<String> visited = new HashSet<>();
        // visited.add("0000");
        
        Deque<Pair<String, Integer>> queue = new ArrayDeque<>();
        queue.offer(new Pair("0000", 0));
        
        while (!queue.isEmpty()) {
            Pair<String, Integer> temp = queue.poll();
            String s = temp.getKey();
            int step = temp.getValue();
            if (target.equals(s)) {
                return step;
            }
            else if (deadEnds.contains(s)) {
                continue;
            }
            StringBuilder sb = new StringBuilder(s);
            for (int i = 0; i < 4; i ++) {
                char currentDigit = sb.charAt(i);
                int digitUp = (currentDigit == '9' ? 0 : currentDigit-'0'+1);
                int digitDown = (currentDigit == '0' ? 9 : currentDigit-'0'-1);
                String s1 = sb.substring(0,i) + digitUp + sb.substring(i+1);
                String s2 = sb.substring(0,i) + digitDown + sb.substring(i+1);
                if (!visited.contains(s1)) {
                    visited.add(s1);
                    queue.offer(new Pair(s1, step + 1));
                }
                if (!visited.contains(s2)) {
                    visited.add(s2);
                    queue.offer(new Pair(s2, step + 1));
                }
            }
        }
        return -1;
    }
}
