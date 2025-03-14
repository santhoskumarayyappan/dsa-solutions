13-03-2025
[Question](https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/description/)


Time Complexity: O(n^2)
```Java

class Solution {
    public String reverseParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                int start = st.pop();
                int end = builder.length();
                builder.replace(start, end, new StringBuilder(builder.substring(start, end)).reverse().toString());
            } else if(s.charAt(i) == '(') {
                st.push(builder.length());
            } else {
                builder.append(s.charAt(i));
            }
        }

        return builder.toString();
    }
}
```




Time Complexity: O(n)
```Java

\\ Worm Hole concept - each entry into a bracket teleports to its pair 
class Solution {
    public String reverseParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int[] pair = new int[s.length()];
        StringBuilder builder = new StringBuilder();

        int temp;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                temp = st.pop();
                pair[i] = temp;
                pair[temp] = i;
            } else if (s.charAt(i) == '(') {
                st.push(i);
            }
        }

        for (int i = 0, d = 1; i < s.length(); i += d) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                i = pair[i];
                d = -d;
            } else {
                builder.append(s.charAt(i));
            }
        }

        return builder.toString();
    }
}
```
