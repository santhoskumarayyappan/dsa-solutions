02-06-2022
[Question](https://leetcode.com/problems/interleaving-string)
```
class Solution {
    boolean[][] dp;
     public boolean solve(int i, int j, int k, String s1, String s2, String s3) {
         boolean ans = false;
        
         if (i == -1 && j == -1 && k == -1) {
             return true;
         } else if ((i == -1 && j == -1 && k != -1) ||
                    (k == -1)) {
             return false;
         }
         else {
             if (i >= 0 && j >= 0 && dp[i][j] != null) {
                 return dp[i][j];
             }
             if (i >= 0 && s1.charAt(i) == s3.charAt(k)) {
                 ans |= solve(i - 1, j, k - 1, s1, s2, s3);
             }
             if (j >= 0 && s2.charAt(j) == s3.charAt(k)) {
                 ans |= solve(i, j - 1, k - 1, s1, s2, s3);
             }            
         }
         if (i >= 0 && j >= 0) {
             dp[i][j] = ans;
         }
         return ans;
     }
    
    public boolean isInterleave(String s1, String s2, String s3) {
        dp = new boolean[s1.length() + 1][s2.length() + 1];
        //return solve(s1.length() - 1, s2.length() - 1, s3.length() - 1, s1, s2, s3); top down
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else {
                    if (j == 0) {
                        dp[i][j] |= dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i - 1);
                    } else if (i == 0) {
                        dp[i][j] |= dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
                    } else {
                        dp[i][j] |= dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)
                            || dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                    }
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
```
