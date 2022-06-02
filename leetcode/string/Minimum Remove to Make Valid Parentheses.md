02-06-2022
[Question](https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/)
```
class Solution {
    public String solve1(String s) {
       int[] right = new int[s.length()]; //right[i] = number of closingBrackets in [i+1, ...]
       right[s.length() - 1] = 0;
       for (int i = s.length() - 2; i >= 0; i--) {
           right[i] = right[i + 1];
           if (s.charAt(i + 1) == ')') {
               right[i]++;
           }
       }
        
       int opening = 0; // number of unBalanced openingBrackets seen so far
       StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (opening + 1 <= right[i]) { 
                    opening++;
                    ans.append(s.charAt(i));
                }
            } else if (s.charAt(i) == ')') {
                if (opening > 0) {
                    opening--;
                    ans.append(s.charAt(i));
                }
            } else {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }
    // Without extra array
    public String solve2(String s) {
        int curBrackets = 0;
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        // Replace all unbalanced ')' with '#
        for (int i = 0; i < n; i++) {
            if (sb.charAt(i) == '(') {
                curBrackets++;
            } else if (sb.charAt(i) == ')') {
                if (curBrackets == 0) {
                    sb.setCharAt(i, '#');
                } else {
                    curBrackets--;
                }
            }
        }
        
        sb = sb.reverse();
        curBrackets = 0;
        // Replace all unbalanced ')' with '#
        for (int i = 0; i < n; i++) {
            if (sb.charAt(i) == ')') {
                curBrackets++;
            } else if (sb.charAt(i) == '(') {
                if (curBrackets == 0) {
                    sb.setCharAt(i, '#');
                } else {
                    curBrackets--;
                }
            }
        }
        sb = sb.reverse();
        StringBuilder ans = new StringBuilder();
        // Remove all '#'
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != '#') {
                ans.append(sb.charAt(i));
            }
        }
        return ans.toString();
    }
    public String minRemoveToMakeValid(String s) {
       return solve2(s);
    }
}
```
