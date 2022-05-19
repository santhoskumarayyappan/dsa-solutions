//20-05-2022
//https://leetcode.com/problems/valid-sudoku/

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    if (!seen.add(ch + " in row " + i) ||
                        !seen.add(ch + " in col " + j) ||
                        !seen.add(ch + " in box " + i / 3 + ":" + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
