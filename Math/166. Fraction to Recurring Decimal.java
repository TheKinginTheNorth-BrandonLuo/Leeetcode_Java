class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        if (numerator == 0) {
            return "0";
        }
        
        String sign = (numerator < 0 == denominator < 0 || numerator == 0) ? "" : "-";
        sb.append(sign);
        
        long n = Math.abs((long)numerator);
        long d = Math.abs((long)denominator);
        
        sb.append(n / d);
        long remainder = n % d;
        
        if (remainder == 0) {
            return sb.toString();
        }
        sb.append(".");
        
        HashMap<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            if (!map.containsKey(remainder)) {
                map.put(remainder, sb.length());
            }
            else {
                int index = map.get(remainder);
                return sb.substring(0, index) + "(" + sb.substring(index) + ")";
            }
            
            remainder *= 10;
            sb.append(remainder / d);
            remainder = remainder % d;
        }
       return sb.toString(); 
    }
}
