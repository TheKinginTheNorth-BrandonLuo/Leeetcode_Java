class Solution {
    public boolean isHappy(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        
        int nextNum = n;
        while (true) {
            nextNum = getNextNum(nextNum);
            if (nextNum == 1) {
                return true;
            }
            if (nextNum == 89) {
                return false;
            }
        }
    }
    
    private int getNextNum(int n) {
        int nextNum =0;
        while (n != 0) {
            nextNum += (n % 10) * (n % 10);
            n = n / 10;
        }
        return nextNum;
    }
}
