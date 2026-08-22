class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0) return -1;
        int startIndex = -1;
        int gasAccumulated = 0;

        int totalGas = 0, totalCost = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            if (gasAccumulated + gas[i] < cost[i]) {
                // Cannot start from the chosen point. Reset
                gasAccumulated = 0;
                startIndex = -1;
            } else {
                gasAccumulated += (gas[i] - cost[i]);
                if (startIndex == -1) {
                    startIndex = i;
                }
            }
        }

        if (totalGas < totalCost) return -1;

        return startIndex;
    }
}
