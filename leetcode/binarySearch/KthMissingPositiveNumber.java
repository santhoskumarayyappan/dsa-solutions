//27-03-2022
//https://leetcode.com/problems/kth-missing-positive-number/



// No of missing numbers at index i = Current Value at index i - Correct Value as per contiguous sequence
// = A[i]-(i+1) // monotonic function
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] - (mid + 1) >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left + k;
    }
}
