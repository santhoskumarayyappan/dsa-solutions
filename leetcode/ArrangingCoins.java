//29-03-2022
//https://leetcode.com/problems/arranging-coins/



class Solution {
    public int arrangeCoins(int sum) {
        // we need to find number of complete rows given total number of coins
        // cR range = [1, coinCount]
        // total number of coins in complete row of count n = (n * n + 1) / 2
        int left = 1;
        int right = Math.min(Integer.MAX_VALUE - 1 , sum)  + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid * (mid + 1l) / 2l > sum) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }
}
