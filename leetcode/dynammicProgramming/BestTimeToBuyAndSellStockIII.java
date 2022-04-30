//01-05-2022
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii



class Solution {
    
    public int maxProfit(int[] prices) {
        int mininumPriceOfStockSoFar = Integer.MAX_VALUE;
        int maximumProfitMadeByOneSaleSoFar = Integer.MIN_VALUE;
        int minimumNetPriceOfStockSoFar = Integer.MAX_VALUE;
        int maximumProfitMadeByTwoSaleSoFar = Integer.MIN_VALUE;
        
        for (int i = 0; i < prices.length; i++) {
            mininumPriceOfStockSoFar = Math.min(mininumPriceOfStockSoFar, prices[i]);
            maximumProfitMadeByOneSaleSoFar = Math.max(maximumProfitMadeByOneSaleSoFar, prices[i] - mininumPriceOfStockSoFar);
            minimumNetPriceOfStockSoFar = Math.min(minimumNetPriceOfStockSoFar, prices[i] - maximumProfitMadeByOneSaleSoFar);
            maximumProfitMadeByTwoSaleSoFar = Math.max(maximumProfitMadeByTwoSaleSoFar, prices[i] - minimumNetPriceOfStockSoFar);
        }
        return maximumProfitMadeByTwoSaleSoFar;
    }
}
