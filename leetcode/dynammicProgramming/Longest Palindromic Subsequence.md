31-05-2025 [Question](https://leetcode.com/problems/longest-palindromic-subsequence/)

```java
class Solution {
    public int longestPalindromeSubseq(String s) {
        String s1 = s, s2 = new StringBuilder(s).reverse().toString();;
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1; 
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
```
