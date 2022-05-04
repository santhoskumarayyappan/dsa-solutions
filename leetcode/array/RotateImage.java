//09-04-2022
//https://leetcode.com/problems/rotate-image/



class Solution {
    
    //Reflection on Secondary Diagonal and then reflection on Mid Row
    public void rotateClockWise(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][n - i - 1];
                matrix[n - j - 1][n - i - 1] = temp;
            }
        }
        for (int i = 0; i < n / 2; i++) {  
            int[] temp = matrix[i];
            matrix[i] = matrix[n - i - 1];
            matrix[n - i - 1] = temp;
        }
        
    }
    
    //Reflection on Main Diagonal and then reflection on Mid Row
    public void rotateAntiClockWise(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < n / 2; i++) {  
            int[] temp = matrix[i];
            matrix[i] = matrix[n - i - 1];
            matrix[n - i - 1] = temp;
        }
        
    }
}

//Reflection on Secondary Diagonal From and To Positions
// 0, 0 - 2, 2
// 0, 1 - 1, 2
// 0, 2 - 0, 2

//Reflection on Main Diagonal From and To Positions
// 0, 0 - 0, 0
// 0, 1 - 1, 0
// 0, 2 - 2, 0
