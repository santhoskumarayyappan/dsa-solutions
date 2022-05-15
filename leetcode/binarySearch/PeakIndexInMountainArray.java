//26-03-2022
//https://leetcode.com/problems/peak-index-in-a-mountain-array/




class Solution {
    public int peakIndexInMountainArray(int[] a) {
        int left = 0, right = a.length - 1; 
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (a[mid] < a[mid - 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }
}
