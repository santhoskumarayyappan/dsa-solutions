14-06-2022
[Question](https://leetcode.com/problems/delete-operation-for-two-strings/)

From This 
```
class Solution {
    public int minDistance(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n2; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[n1][n2];
    }
}
```

To This

```
class Solution {
    public int minDistance(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        
        int[] dp = new int[n2 + 1];
        
        for (int j = 1; j <= n2; j++) {
            dp[j] = j;
        }
        int prev = 0; //dp[i - 1][j - 1]
        for (int i = 1; i <= n1; i++) {
            prev = dp[0];
            dp[0] = i;
            for (int j = 1; j <= n2; j++) {
                int temp = dp[j];
                if (s1.charAt(i - 1) != s2.charAt(j - 1)) {
                    dp[j] = Math.min(dp[j], dp[j - 1]) + 1;
                } else {
                    dp[j] = prev;
                }
                prev = temp;
            }
        }
        return dp[n2];
    }
}
```
