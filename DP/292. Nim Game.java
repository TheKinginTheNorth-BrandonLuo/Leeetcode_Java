class Solution {
    public boolean canWinNim(int n) {
        return (n % 4 != 0);
    }
}

class DPSolution {
    public boolean canWinNim(int n) {
        if (n < 4) {
            return true;
        }
        
        // boolean[] res = new boolean[n + 1];
        // res[0] = true;
        // res[1] = true;
        // res[2] = true;
        // res[3] = true;
        
        // for (int i = 4; i < n + 1; i ++) {
        //     res[i] = !(res[i - 1] && res[i - 2] && res[i - 3]);
        // }
        // return res[n];
        boolean[] results = {true,true,true,false};
        return results[(n - 1) % 4];
    }
}
