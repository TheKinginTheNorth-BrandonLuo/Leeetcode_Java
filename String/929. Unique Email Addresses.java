class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        
        for (String email: emails) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < email.length(); i ++) {
                if (email.charAt(i) == '.') {
                    continue;
                }
                else if (email.charAt(i) == '+'){
                    int end = email.length() - 1;
                    while (email.charAt(end) != '@') {
                        end --;
                    }
                    sb.append(email.substring(end));
                    break;
                }
                else if (email.charAt(i) == '@') {
                    sb.append(email.substring(i));
                    break;
                }
                else {
                    sb.append(email.charAt(i));
                }
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
