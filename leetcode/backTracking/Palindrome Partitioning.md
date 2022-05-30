30-05-2022
[Question](https://leetcode.com/problems/palindrome-partitioning/)
```
class Solution {
    public boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                break;
            }
        }
        return i >= j;
    }
    public void helper(String s, List<String> cur, List<List<String>> ans, int start) {
        if (start == s.length()) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        int end = start;
        while (end < s.length()) {
            if (isPalindrome(s, start, end)) {
                cur.add(s.substring(start, end + 1));
                helper(s, cur, ans, end + 1);
                cur.remove(cur.size() - 1);
            }
            end++;
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        helper(s, new ArrayList<>(), ans, 0);
        return ans;
    }
}
```
