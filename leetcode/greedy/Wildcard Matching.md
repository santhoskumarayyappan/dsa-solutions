//29-05-2022
[Question](https://leetcode.com/problems/wildcard-matching)
```
class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0, j = 0;
        int lastStarPos = -1, lastMatchedPos = -1;
        while (i < s.length()) {
            if (j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            } else if (j < p.length() && p.charAt(j) == '*') {
                lastStarPos = j;
                lastMatchedPos = i;
                j++;
            } else if (lastStarPos != -1) {
                j = lastStarPos + 1;
                lastMatchedPos++;
                i = lastMatchedPos;
            } else {
                return false;
            }
        }
        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }
        return j == p.length();
    }
}
```
