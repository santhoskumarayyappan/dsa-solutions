//30-04-2022
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii


class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for (int i = 0; i < n; i++) {
            while (i + 1 < n && prices[i] >= prices[i + 1]) i++;
            int buy = prices[i];
            while (i + 1 < n && prices[i] <= prices[i + 1]) i++;
            int sell = prices[i];
            ans += sell - buy;
        }
        return ans;
    }
}
