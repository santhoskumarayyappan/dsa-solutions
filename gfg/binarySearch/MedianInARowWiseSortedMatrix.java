//24-05-2022
//https://practice.geeksforgeeks.org/problems/median-in-a-row-wise-sorted-matrix1527/1/
//Given a row-wise sorted matrix where the number of rows and columns is always odd, find the median of the matrix.
//Each row will be sorted, column wise we dont know
// Assumption is odd length matrix so only one median possible
// Median is basically an element 'median' in sorted array of length n, s.t a[i] <= median where i E [0, n / 2]   
// last element of array s.t number of elements before median including it <= n / 2 + 1
// first element of array s.t number of elements before median including it >= n / 2 + 1

class Solution {

    // in other words , find first i s.t a[i] > x 
    public int getNumberOfElementsLeX(int[] a, int x) {
        int low = 0, high = a.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (a[mid] > x) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public boolean isNumberOfElementsLeXGeSize(int[][] a, int x, int size) {
        int numberOfElementsLeX = 0;
        for (int i = 0; i < a.length; i++) {
            numberOfElementsLeX += getNumberOfElementsLeX(a[i], x);
            if (numberOfElementsLeX >= size) {
                return true;
            }
        }
        return false;
    }

    // in other words Find First Occurence of Number x 
    // s.t (Number of Elements <= x) >= (m * n / 2) + 1
    int median(int a[][], int r, int c) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int i = 0; i < r; i++) {
            if (low > a[i][0]) {
                low = a[i][0];
            }
            if (high < a[i][c - 1]) {
                high = a[i][c - 1];
            }
        }

        int medianPos = r * c / 2 + 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            //System.out.println("h " + high + " l " + low);
            if (isNumberOfElementsLeXGeSize(a, mid, medianPos)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
