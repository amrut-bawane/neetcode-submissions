class Solution {
    // Can't rob two adjacent houses. Maximum amount robbed
    public int rob(int[] houses) {
        if (houses == null || houses.length == 0) return 0;
        int[] cache = new int[houses.length];
        Arrays.fill(cache, -1);
        return rob(houses, 0, cache);
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
