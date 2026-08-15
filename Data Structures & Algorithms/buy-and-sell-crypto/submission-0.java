class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int lowestPriceTillNow = prices[0];
        int maxProfitTillNow = 0;

        for (int i=1; i<prices.length; i++) {
            int currentPrice = prices[i];
            if (currentPrice > lowestPriceTillNow) {
                maxProfitTillNow = Math.max(maxProfitTillNow, currentPrice - lowestPriceTillNow);
            } else {
                lowestPriceTillNow = currentPrice;
            }
        }
        return maxProfitTillNow;
    }
}
