03-05-2025
[Question](https://leetcode.com/problems/search-a-2d-matrix/)
```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0, high = m * n - 1, mid;
        
        while (low < high) {
            mid = low + (high - low) / 2;

            if (matrix[mid / n][mid % n] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return matrix[low / n][low % n] == target;
    }
}
```
