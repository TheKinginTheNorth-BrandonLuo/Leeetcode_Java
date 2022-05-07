class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas = 0, sumCost = 0;
        for (int value : gas) {
            sumGas += value;
        }
        for (int value : cost) {
            sumCost += value;
        }
        if (sumGas < sumCost) {
            return -1;
        }
        
        int total = 0, res = 0;
        
        for (int i = 0; i < gas.length; i ++) {
            total += gas[i] - cost[i];
            
            if (total < 0) {
                total = 0;
                res = i + 1;
            }
        }
        return res;
    }
}
