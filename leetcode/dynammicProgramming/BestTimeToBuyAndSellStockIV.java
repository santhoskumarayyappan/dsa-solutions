//01-05-2022
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv


class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0 || k == 0) {
            return 0;
        }
        
        int[] buy = new int[k];
        Arrays.fill(buy, Integer.MAX_VALUE);        
        int[] sell = new int[k];
        
        
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < k; j++) {
                if (j > 0) {
                    buy[j] = Math.min(buy[j], prices[i] - sell[j - 1]);
                    sell[j] = Math.max(sell[j], prices[i] - buy[j]);
                } else {
                    buy[j] = Math.min(buy[j], prices[i]);
                    sell[j] = Math.max(sell[j], prices[i] - buy[j]);
                }
            }
        }
        return sell[k - 1];
    }
}
