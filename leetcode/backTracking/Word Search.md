30-05-2022
[Question](https://leetcode.com/problems/word-search/)
```
class Solution {
    int[][] dirs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    
    public boolean isValid(int i, int j, int m, int n, char[][] board, char ch) {
        return i >= 0 && i < m && j >= 0 && j < n && board[i][j] == ch;
    }
    
    public boolean helper(char[][] board, int i, int j, int k, String word) {
        boolean ans = false;
        if (k == word.length()) {
            return true;
        } else {
            for (int[] dir : dirs) {
                if (isValid(i + dir[0], j + dir[1], board.length, board[0].length, board, word.charAt(k))) {
                    
                    board[i + dir[0]][j + dir[1]] = '.';
                    if(helper(board, i + dir[0], j + dir[1], k + 1, word)) {
                        return true;
                    } else {
                        board[i + dir[0]][j + dir[1]] = word.charAt(k);
                    }
                }
            }
        }
        return false;
    }
    
    public boolean exist(char[][] board, String word) {
        for (int i = 0;  i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char ch = board[i][j];
                board[i][j] = '.';
                if (ch == word.charAt(0) && helper(board, i, j, 1, word)) {
                    return true;
                }
                board[i][j] = ch;
            }
        }
        return false;
    }
}
```
