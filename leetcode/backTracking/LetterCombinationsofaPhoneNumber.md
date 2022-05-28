29-05-2022
[Question](https://leetcode.com/problems/letter-combinations-of-a-phone-number/)

```
class Solution {
    String[] numbersToLetters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public void helper(String s, List<String> ans, StringBuilder cur) {
        if (cur.length() == s.length()) {
            ans.add(cur.toString());
        } else {
            String letters = numbersToLetters[s.charAt(cur.length()) - '2'];
            for (int i = 0; i < letters.length(); i++) {
                cur.append(letters.charAt(i));
                helper(s, ans, cur);
                cur.setLength(cur.length() - 1);
            }
        }
    }
    
    public List<String> letterCombinations(String s) {
        List<String> ans = new ArrayList<>();
        if (s.isEmpty()) {
            return ans;
        }
        helper(s, ans, new StringBuilder());
        return ans;
    }
}
```
