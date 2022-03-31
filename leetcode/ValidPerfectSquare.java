class Solution {
    public boolean isPerfectSquare(int n) {
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int numerator = n / mid;
            int remainder = n % mid;
            if (numerator == mid && remainder == 0) {
                return true;
            } else if (numerator  > mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
