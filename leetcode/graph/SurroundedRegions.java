//https://leetcode.com/problems/surrounded-regions/
//07-05-2022


class Solution {
    int[][] moves = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    
    public boolean isValid(int i, int j, int m, int n, char find, char[][] board) {
        return i >= 0 && i < m && j >= 0 && j < n && board[i][j] == find;
    }
    
    public void findAndReplace(char[][] board, int i, int j, int m, int n) {
        char find = 'O';
        char replace = 'Y';
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        board[i][j] = replace;
        while (!q.isEmpty()) {
            int[] curPos = q.poll();
            for (int[] move : moves) {
                if (isValid(curPos[0] + move[0], curPos[1] + move[1], m, n, find, board)) {
                    board[curPos[0] + move[0]][curPos[1] + move[1]] = replace;
                    q.add(new int[]{curPos[0] + move[0], curPos[1] + move[1]});
                }
            }
        }
    }
    
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                findAndReplace(board, i, 0, m, n);
            } 
            if (board[i][n - 1] == 'O') {
                findAndReplace(board, i, n - 1, m, n);
            }
        }       
        
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                findAndReplace(board, 0, j, m, n);
            } 
            if (board[m - 1][j] == 'O') {
                findAndReplace(board, m - 1, j, m, n);
            }   
        }
            
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                } 
            }
        }      
    }
}
