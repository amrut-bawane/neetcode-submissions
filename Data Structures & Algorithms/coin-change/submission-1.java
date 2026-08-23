class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount == -1) return -1;

        // dp[i] = min coins needed to create amount i 
        int[] dp = new int[amount+1];
        int max_answer = amount + 1;
        Arrays.fill(dp, max_answer); // Instead of Integer.MAX_VALUE, use amount+1 > max possible answer amount with 1 Re coin

        dp[0] = 0;
        
        for (int a=1; a<=amount; a++) {
            for (int i=0; i<coins.length; i++) {
                int coin = coins[i];
                if (a >= coin) {
                    dp[a] = Math.min(dp[a], 1 + dp[a-coin]);
                }
            }
        }
        if (dp[amount] == max_answer) return -1;
        return dp[amount];
        // return coinChange(coins, amount, new HashMap<>());
    }

    private int coinChange(int[] coins, int amount, Map<Integer, Integer> cache) {
        if (amount < 0) return -1;
        if (amount == 0) {
            return 0;
        }
        if (cache.containsKey(amount)) return cache.get(amount);

        int minCoins = Integer.MAX_VALUE;
        for (int coin: coins) {
            if (coin <= amount) {
                int coinsRemaining = coinChange(coins, amount - coin, cache);
                if (coinsRemaining != -1 && coinsRemaining + 1 < minCoins) {
                    minCoins = coinsRemaining + 1;
                }
            }
        }
        if (minCoins == Integer.MAX_VALUE) minCoins = -1;
        cache.put(amount, minCoins);
        return minCoins;
    }
}
