//26-03-2022
//https://leetcode.com/problems/search-a-2d-matrix-ii/




class Solution {
    // find first index s.t. a[index] > target where index E [left, right]
    public int searchHorizontally(int[] a, int left, int right, int target) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (a[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    // find first index s.t. a[index][y] >= target where index E [top, bottom] and y is constant
    public int searchVertically(int[][] a, int top, int bottom, int target, int y) {
        while (top < bottom) {
            int mid = top + (bottom - top) / 2;
            if (a[mid][y] >= target) {
                bottom = mid;
            } else {
                top = mid + 1;
            }
        }
        return top;
    }
    
    public boolean searchMatrix(int[][] a, int target) {
        int i = 0;
        int j = a[0].length - 1;
        
        // simple Approach
        // while (i < a.length && j >= 0) {
        //     if (a[i][j] == target) {
        //         return true;
        //     } else if (a[i][j] < target) {
        //         i++;
        //     } else {
        //         j--;
        //     }
        // }
        // return false;
        
        while (i < a.length && j >= 0) { 
            if (a[i][j] == target) {
                return true;
            } else if (a[i][j] < target) {
                i = searchVertically(a, i, a.length, target, j);
            } else {
                j = searchHorizontally(a[i], 0, j + 1, target) - 1;
            }
        }
        return false;
        
    }
}
