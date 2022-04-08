//08-04-2022
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/


class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        int ans = 0;
        int leftMin = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            leftMin = Math.min(leftMin, prices[i]);
            ans = Math.max(ans, prices[i] - leftMin);
        }
        return ans;
    }
}
