30-05-2022
[Question](https://leetcode.com/problems/n-queens/)
```
class Solution {
    
    public boolean isValid(int r, int c, List<StringBuilder> cur) {
        for (int i = 0; i < r; i++) {
            if (cur.get(i).charAt(c) == 'Q') {
                return false;
            }
        }
        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0 ; i--, j--) {
            if (cur.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        for (int i = r - 1, j = c + 1; i >= 0 && j < cur.size(); i--, j++) {
            if (cur.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        return true;
    }
    public void solve(int i, List<StringBuilder> cur, List<List<String>> ans) {
        if (i == cur.size()) {
            cur.stream().map(e -> e.toString()).collect(Collectors.toList());
            ans.add(cur.stream().map(e -> e.toString()).collect(Collectors.toList()));
            return;
        } 
        
        for (int j = 0; j < cur.size(); j++) {
            if (isValid(i, j, cur)) {
                cur.get(i).setCharAt(j, 'Q');
                solve(i + 1, cur, ans);
                cur.get(i).setCharAt(j, '.');
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<StringBuilder> cur = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            cur.add(new StringBuilder(String.valueOf('.').repeat(n)));
        }
        solve(0, cur, ans);
        return ans;
    }
}
```
