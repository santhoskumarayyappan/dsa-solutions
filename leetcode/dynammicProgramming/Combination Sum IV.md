30-05-2022
[Question](https://leetcode.com/problems/combination-sum-iv/)
```
class Solution {
    
    public int helper(int i, int target, int[] a, int[][] dp) {   
       if (target == 0) {
           return 1;
       }
       if (i == a.length) {
           return 0;
       }
       if (dp[i][target] != -1) {
           return dp[i][target];
       }
       int ans = 0;
       if (target - a[i] >= 0) {
           ans += helper(0, target - a[i], a, dp);
       }
       ans += helper(i + 1, target, a, dp); 
       dp[i][target] = ans;
       return ans;
    }
    
    public int combinationSum4(int[] a, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i <= target; i++) {
            for (int ele : a) {
                if (ele <= i)
                dp[i] += dp[i - ele];
            }
        }
        return dp[target];    
    }
}
```
