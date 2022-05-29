29-05-2022
[Question](https://leetcode.com/problems/generate-parentheses/)
```
class Solution {
    public void helper(int i, int n, int left, int right, List<String> ans, StringBuilder cur) {
        if (i == 2 * n) {
            ans.add(cur.toString());
        } else {
            if (left < n) {
                cur.append('(');
                helper(i + 1, n, left + 1, right, ans, cur);
                cur.setLength(cur.length() - 1);
            }
            if (right < left) {
                cur.append(')');
                helper(i + 1, n, left, right + 1, ans, cur);
                cur.setLength(cur.length() - 1);
            }
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(0, n, 0, 0, ans, new StringBuilder());
        return ans;
    }
}
```
