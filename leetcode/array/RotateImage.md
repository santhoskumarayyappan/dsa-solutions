09-04-2022
[Question](https://leetcode.com/problems/rotate-image/)

```java
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


// Moving towards approach
// Start from left corner and loop till center
// so i varies from [0, n / 2 - 1]
// in each iteration swap circularly n - 2i - 1 elements from j E [i, n - i - 2]
// index formula can be deduced from thinking what varies along that dimension
// For example
// in first row -> row index is fixed and column index incremented
// in first column -> row index is decremented and column index is fixed
// in last row -> row index is fixed and column index is decremented
// in last column -> row index is incremented and column index is fixed
// in each inner loop iteration, i is fixed and j varies so deduce based on this 

class Solution {
    public void rotate(int[][] a) {
        int n = a.length;

        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int temp = a[i][j];
                a[i][j] = a[n - 1 - j][i];
                a[n - 1 - j][i] = a[n - 1 - i][n - 1 - j];
                a[n - 1 - i][n - 1 - j] = a[j][n - 1 - i];
                a[j][n - 1 - i] = temp;
            }
        }
    }
}
```
