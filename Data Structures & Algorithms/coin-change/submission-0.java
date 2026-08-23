class Solution {
    public int coinChange(int[] coins, int amount) {
        return coinChange(coins, amount, new HashMap<>());
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
