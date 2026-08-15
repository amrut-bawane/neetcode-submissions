class Solution {
    // Can't rob two adjacent houses. Maximum amount robbed
    public int rob(int[] houses) {
        if (houses == null || houses.length == 0) return 0;
        if (houses.length == 1) return houses[0];

        int robMinusTwoHouse = houses[0];
        int robMinusOneHouse = 0;
        if (houses.length >= 2) {
            robMinusOneHouse = Math.max(houses[0], houses[1]);
        }
        for (int i=2; i<houses.length; i++) {
            // Include current house
            int robIncludingCurrent = houses[i] + robMinusTwoHouse;
            int robExcludingCurrent = robMinusOneHouse;

            robMinusTwoHouse = robMinusOneHouse;
            robMinusOneHouse = Math.max(robIncludingCurrent, robExcludingCurrent);
        }
        return robMinusOneHouse;
    }

    private int rob(int[] houses, int i, int[] cache) {
        // Base case, last house or second last
        if (i == houses.length - 2) {
            return Math.max(houses[houses.length - 1], houses[houses.length - 2]);
        }
        if (i == houses.length - 1) {
            return houses[i];
        }

        if (cache[i] != -1) return cache[i];

        // Include the current house, or don't include & option to rob next
        int result = Math.max(houses[i] + rob(houses, i+2, cache), rob(houses, i+1, cache));
        cache[i] = result;
        return result;
    }
}
