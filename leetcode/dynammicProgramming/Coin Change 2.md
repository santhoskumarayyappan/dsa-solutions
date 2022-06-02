02-06-2022
[Question](https://leetcode.com/problems/coin-change-2/)
``` 
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin]; // as we can take single coin multiple times
            }
        }
        return dp[amount];
    }
}
```
