16-06-2022
[Question](https://leetcode.com/problems/longest-palindromic-substring/)
```java
class Solution {
    class Range {
        int start;
        int end;
        int size;
        Range(int start, int end, int size) {
            this.start = start;
            this.end = end;
            this.size = size;
        }
    }
    
    public Range expandAround(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return new Range(i + 1, j - 1, (j - 1) - (i + 1) + 1);
    }
    public String longestPalindrome(String s) {
        int maxLen = 0;
        int start = -1, end = -1;
        for (int i = 0; i < s.length(); i++) {
            Range oddLengthRange = expandAround(s, i, i);
            if (maxLen < oddLengthRange.size) {
                maxLen = oddLengthRange.size;
                start = oddLengthRange.start;
                end = oddLengthRange.end;
            }
            
            Range evenLengthRange = expandAround(s, i, i + 1);
            if (maxLen < evenLengthRange.size) {
                maxLen = evenLengthRange.size;
                start = evenLengthRange.start;
                end = evenLengthRange.end;
            }
        }
        return s.substring(start, end + 1);
    }
}
```
