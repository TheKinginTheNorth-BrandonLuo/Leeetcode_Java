class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(res, sb, num, 0, target, 0, 0);
        return res;
    }
    
    private void backtrack(List<String> res, StringBuilder sb, String num, int pos, int target, long prev, long multi) {
        if (pos == num.length()) {
            if (target == prev) {
                res.add(sb.toString());
            }
        }
        for (int i = pos; i < num.length(); i ++) {
            if (num.charAt(pos) == '0' && i != pos) {
                break;
            }
            Long cur = Long.parseLong(num.substring(pos, i + 1));
            int len = sb.length();
            if (pos == 0) {
                backtrack(res, sb.append(cur), num, i + 1, target, cur, cur);
                sb.setLength(len);
            }
            else {
                backtrack(res, sb.append("+").append(cur), num, i + 1, target, prev + cur, cur);
                sb.setLength(len);
                backtrack(res, sb.append("-").append(cur), num, i + 1, target, prev -cur, -cur);
                sb.setLength(len);
                backtrack(res, sb.append("*").append(cur), num, i + 1, target, prev - multi + multi * cur, multi * cur);
                sb.setLength(len);
            }
            
        }
    }
}
