15-06-2022
[Question](https://leetcode.com/problems/longest-string-chain/)

```java
class Solution {
    public boolean isPredecessor(String a, String b) {
        if (a.length() + 1 != b.length()) {
            return false;
        }      
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i + diff)) {
                diff++;
                i--;
                if (diff > 1) {
                    return false;
                }
            }
        } 
        return true;
    }
    
    public int longestStrChain2(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int[] dp = new int[words.length];
        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i < words.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (isPredecessor(words[j], words[i]) && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
    
    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        Map<String, Integer> wordToLen = new HashMap<>();
        int maxLen = 1;
        
        for (String word : words) {
            int curLen = 1;
            for (int i = 0; i < word.length(); i++) {
               curLen = Math.max(curLen, wordToLen.getOrDefault(word.substring(0, i) + word.substring(i + 1, word.length()), 0) + 1); 
            }
            wordToLen.put(word, curLen);
            maxLen = Math.max(maxLen, curLen);
        }
        return maxLen;
    }
}```
