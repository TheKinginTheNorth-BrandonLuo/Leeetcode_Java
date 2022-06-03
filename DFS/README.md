## Build visited int array for string
int[] visited = new int[26];
for (int i = 0; i < string.length(); i ++) {
    alpha[string.charAt(i) - 'a'] += 1;
}
