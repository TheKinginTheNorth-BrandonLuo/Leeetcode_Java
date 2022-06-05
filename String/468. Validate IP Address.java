class Solution {
    public String validIPAddress(String queryIP) {
        if (queryIP.split("\\.").length == 4) {
            return ipV4(queryIP);
        }
        if (queryIP.split(":").length == 8) {
            return ipV6(queryIP);
        }
        
        return "Neither";
        
    }
    
    private String ipV4(String queryIP) {
        if (queryIP.charAt(0) == '.' || queryIP.charAt(queryIP.length() - 1) == '.') {
            return "Neither";
        }
        String[] arrOfStr = queryIP.split("\\.");
        for (String s: arrOfStr) {
            if (s.length() < 1 || s.length() > 3) {
                return "Neither";
            }
            if ((s.charAt(0) == '0' && s.length() != 1)) {
                return "Neither";
            }
            for (char c: s.toCharArray()) {
                if (c < '0' || c > '9') {
                    return "Neither";
                }
            }
            if (Integer.parseInt(s) < 0 || Integer.parseInt(s) > 255) {
                return "Neither";
            }
            
            for (char c: s.toCharArray()) {
                if (c < '0' || c > '9') {
                    return "Neither";
                }
            }
        }
        return "IPv4";
    }
    
    private String ipV6(String queryIP) {
        if (queryIP.charAt(0) == ':' || queryIP.charAt(queryIP.length() - 1) == ':') {
            return "Neither";
        }
        String[] arrOfStr = queryIP.split(":");
        for (String s: arrOfStr) {
            if (s.length() < 1 || s.length() > 4) {
                return "Neither";
            }
            for (char c : s.toLowerCase().toCharArray()) {
                if((c<'0' || c>'9') && (c!='a' && c!='b' && c!='c' && c!='d' && c!='e' && c!='f')) {
                    return "Neither";
                }
            }
        }
        return "IPv6";
    }
}
