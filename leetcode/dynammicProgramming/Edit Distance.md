31-05-2022
[Question](https://leetcode.com/problems/edit-distance/)
```
class Solution {
    public int[][] dp;
    public int helper(String word1, String word2, int i, int j) {
        if (i == word1.length()) {
            return word2.length() - j;
        } else if (j == word2.length()) {
            return word1.length() - i;
        }
        else {
            if (dp[i][j] != -1) {
                return dp[i][j];
            }
            if (i < word1.length() && j < word2.length() && word1.charAt(i) == word2.charAt(j)) {
                dp[i][j] = helper(word1, word2, i + 1, j + 1);
                return dp[i][j];
            } else {
                dp[i][j] = Math.min(Math.min(helper(word1, word2, i, j + 1),
                               helper(word1, word2, i + 1, j)),
                               helper(word1, word2, i + 1, j + 1)) + 1;
                return dp[i][j];
            }
        }
    }
    public int minDistance(String word1, String word2) {
        dp = new int[word1.length() + 1][word2.length() + 1];
        
        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= word2.length(); j++) {
            dp[0][j] = j;    
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
```


// insert i, j + 1
// delete i + 1, j
// replace i + 1, i + 1
